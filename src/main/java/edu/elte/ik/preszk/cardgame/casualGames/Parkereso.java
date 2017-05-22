/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.casualGames;

/**
 *
 * @author Lipcsei
 */
import edu.elte.ik.preszk.cardgame.Deck;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Párkereső kártyajáték.
 * @author Lipcsei
 */
 
public class Parkereso{
	private BufferedReader br;
	
	/**
	 * A konstruktor amely inicializálja a Párkereső játékot. 
	 * @param br egy {@link BufferedReader} mely a kommunikációért felel.
	 */
	public Parkereso(BufferedReader br) {
		this.br = br;
	}
	
	/**
	 * Elindítja a Treffnem kártyajátékot.
	 */
    public void game() throws IOException{
        System.out.println("Ezt a játékot bármilyen kártyával lehet játszani, Válassz hogy melyikkel szeretnéd: 1-magyar, 2-francia");
        int choosenum = Integer.parseInt(br.readLine());
        switch(choosenum){
            case 1:
                //magyar kártyával indítja a játékot
                parkereso(true);
                break;
            case 2:
                //francia kártyával indítja a játékot
                parkereso(false);
                break;
            default:
                System.out.println("Megfelelő számot írj be!");
                break;
        }
    }
	
    private void printMap(HashMap<Integer, String> cards, HashMap<Integer, String> NotFoundCards){
        //kezdő játéktér kiiratása
        for(int i = 0; i<cards.size(); ++i){
        if((i+1)%8 == 0){
            if((i+1)<10){
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
                System.out.println();
            } else {
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
                System.out.println();
                }
        } else {
            if((i+1)<10)
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
            else
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
        }
    }
	
    public void parkereso(boolean fajta) throws IOException{
        Deck pakli = new Deck(fajta);
        boolean run = true;
        HashMap<Integer, String> cards = new HashMap<Integer, String>();
        HashMap<Integer, String> NotFoundCards = new HashMap<Integer, String>();
        //kártyák feltöltése
        for(int i = 0; i<pakli.size(); ++i){
            cards.put(i,pakli.getSortedCard(i));
        }
        for(int i = 0; i<pakli.size(); ++i){
            NotFoundCards.put(i,"X");
        }


        int choose = 0;
        int choose2 = 0;
        int allFound = 0;
        while(run){
            printMap(cards, NotFoundCards);
            System.out.println("Válassz egy kártyát és nyomj entert!");
            choose = Integer.parseInt(br.readLine());
            NotFoundCards.put(choose,cards.get(choose));

            printMap(cards, NotFoundCards);
            System.out.println("Válassz egy másik kártyát és nyomj entert!");
            choose2 = Integer.parseInt(br.readLine());
            if(NotFoundCards.get(choose2).equals(cards.get(choose2))){
                NotFoundCards.put(choose2,cards.get(choose2));
                System.out.println("Talált!");
            } else {
                NotFoundCards.put(choose,"X");
                System.out.println("Nem talált!");
            }
            for(int i = 0; i<NotFoundCards.size(); ++i){
                if(NotFoundCards.get(i).equals("X")){
                    System.out.println("Következő kör!");
                } else {
                    allFound++;
                }				
            }
            if(allFound == 64){
                System.out.println("Megtaláltad az összes párt! A játéknak vége");
            }
            run = false;			
        }			
    }
}