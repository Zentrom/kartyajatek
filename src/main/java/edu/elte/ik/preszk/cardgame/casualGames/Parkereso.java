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
import edu.elte.ik.preszk.cardgame.panel.ParkeresoPanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 * Elindítja a párkereső kártyajátékot.
	 * @throws IOException olvasási hiba esetén
	 */
    public void game() throws IOException{
        System.out.println("Ezt a játékot bármilyen kártyával lehet játszani, Válassz hogy melyikkel szeretnéd: 1-magyar, 2-francia");
        int choosenum = Integer.parseInt(br.readLine());
        switch(choosenum){
            case 1:
                //magyar kártyával indítja a játékot
                //parkereso(true);
                ParkeresoPanel panel = new ParkeresoPanel(true);
                panel.run();
                break;
            case 2:
                //francia kártyával indítja a játékot
                //parkereso(false);
                ParkeresoPanel panel2 = new ParkeresoPanel(false);
                panel2.run();
                break;
            default:
                System.out.println("Megfelelő számot írj be!");
                break;
        }
    }
    
    
    /**
    * kiírja a játékteret.
    * @param cards a pakli
    * @param NotFoundCards nem talált kártyák.
    */
    private void printMap(HashMap<Integer, String> cards, HashMap<Integer, String> NotFoundCards){
        //kezdő játéktér kiiratása
        for(int i = 0; i<cards.size(); ++i){
        if((i+1)%8 == 0){
            if((i+1)<10){
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
                System.out.println();
            } else {
                System.out.print("["+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
                System.out.println();
                }
        } else {
            if((i+1)<10)
                System.out.print("[0"+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
            else
                System.out.print("["+(i+1)+"]" + "-" + NotFoundCards.get(i) + ", ");
            }
        }
    }
	
    private void parkereso(boolean fajta){
        Deck pakli = new Deck(fajta);
        Deck pakli2 = new Deck(fajta);
        boolean run = true;
        HashMap<Integer, String> cards = new HashMap<>();
        HashMap<Integer, String> NotFoundCards = new HashMap<>();
        List pressedNums = new ArrayList();
        //kártyák feltöltése
        for(int i = 0; i<pakli.size(); ++i){
            cards.put(i,pakli.getSortedCard(i));
        }
        for(int i = 0; i<pakli.size(); ++i){
            cards.put(i+pakli.size(),pakli2.getSortedCard(i));
        }
        for(int i = 0; i<2 * pakli.size(); ++i){
            NotFoundCards.put(i,"X");
        }


        int choose = 0;
        int choose2 = 0;
        int allFound = 0;
        while(run){
            printMap(cards, NotFoundCards);
            System.out.println("Válassz egy kártyát és nyomj entert!");
            try {
                choose = Integer.parseInt(br.readLine())-1;
                while(pressedNums.contains(choose)){
                    System.out.println("Válassz egy kártyát ami még nem volt és nyomj entert!");
                    choose = Integer.parseInt(br.readLine())-1;
                }
            } catch (IOException ex) {
                System.err.println("Beolvasási hiba");
            }
            NotFoundCards.put(choose,cards.get(choose));

            printMap(cards, NotFoundCards);
            
            System.out.println("Válassz egy másik kártyát és nyomj entert!");
            try {
                choose2 = Integer.parseInt(br.readLine())-1;
                while(choose == choose2 || pressedNums.contains(choose2)){
                    System.out.println("Válassz egy másik kártyát és nyomj entert!");
                    choose2 = Integer.parseInt(br.readLine())-1;
                }
            } catch (IOException ex) {
                System.err.println("Beolvasási hiba");
            }
            
            if(NotFoundCards.get(choose).equals(cards.get(choose2))){
                NotFoundCards.put(choose2,cards.get(choose2));
                System.out.println("Talált!");
            } else {
                NotFoundCards.put(choose,"X");
                System.out.println("Nem talált!");
            }
            for(int i = 0; i<NotFoundCards.size(); ++i){
                if(NotFoundCards.get(i).equals("X")){
                    ;
                } else {
                    pressedNums.add(choose);
                    pressedNums.add(choose2);
                    allFound++;
                }				
            }            
            if(allFound == NotFoundCards.size()){
                System.out.println("Megtaláltad az összes párt! A játéknak vége");
                run = false;
            }
            
            System.out.println("Következő kör!");			
        }			
    }
}
