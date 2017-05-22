/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.casualGames;

import edu.elte.ik.preszk.cardgame.Deck;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lipcsei
 */
public class SzinreSzin {
    boolean magyar = true;
    Deck pakli = new Deck(magyar);
    private BufferedReader br;
    String choose = "";
    String lastCard = "";

    public SzinreSzin(BufferedReader stdinkartya) {
        this.br = stdinkartya;
    }

    /**
     * Elindítja a Színre szín kártyajátékot.
     * @throws IOException ha olvasási hiba van.
     */
    void game() throws IOException {
        while(true){ 
            System.out.println("Ezt a játékot magyar kártyával játszák. Színre színt kell raknod. Az nyer akinek elfogynak a lapjai");
            //a játékos
            List player1 = new ArrayList();
            //számítógép
            List player2 = new ArrayList();
            
            for(int i = 0; i<16; ++i){
                player1.add(pakli.getSortedCard(i));
            }
            for(int i = 16; i<32; ++i){
                player2.add(pakli.getSortedCard(i));
            }
            
            boolean isover = false;
            
            System.out.println("Te kezdessz");
            while(!isover){
                System.out.println("A kártyáid a következők:");
                for(int i = 0; i<player1.size(); ++i){
                    System.out.print("[" + (i+1) + ".] " + player1.get(i) + " , ");
                }
                System.out.println();
                System.out.println("Válassz egy kártyát! (írd be a számát). Ha nem tudsz rakni, írd be hogy 0");
                try {
                    choose = br.readLine();
                } catch (IOException e) {
                    System.err.println("Hiba a beolvasas kozben");
                    break;
                }
                if(choose.equals("0")){
                    isover = true;
                    break;
                }else{
                    boolean isCorrect = false;
                    while(!isCorrect){
                        if(lastCard == ""){
                            lastCard = player1.get(Integer.parseInt(choose)-1).toString();
                            System.out.println("Az asztalon lévő felső lap: " + lastCard);
                            player1.remove(Integer.parseInt(choose)-1);
                            isCorrect = true;
                        }else{
                            String playerstr[] = player1.get(Integer.parseInt(choose)-1).toString().split(" ");
                            String laststr[] = lastCard.split(" ");
                            if(playerstr[0].equals(laststr[0]) || playerstr[1].equals(laststr[1])){
                                lastCard = player1.get(Integer.parseInt(choose)-1).toString();
                                System.out.println("Az asztalon lévő felső lap: " + player1.get(Integer.parseInt(choose)-1).toString());
                                player1.remove(Integer.parseInt(choose)-1);
                                isCorrect = true;
                            }else{
                                if(choose == "0"){
                                    isover = true;
                                }
                                System.out.println("Ezt a lapot nem tudod letenni!");
                                choose = br.readLine();
                                //isCorrect = true;
                            }
                        }
                    }
                }
                System.out.println("A gépi játékos következik!");
                //System.out.println("A gépi játékos kártyái a következők:");
                for(int i = 0; i<player1.size(); ++i){
                    System.err.print("[" + (i+1) + ".] " + player2.get(i) + " , ");
                }
                System.out.println();
                Random random = new Random();
                boolean isCorrect = false;
                int count = 0;
                while(!isCorrect){
                    int num = random.nextInt(player2.size()-1);
                    String laststr[] = lastCard.split(" ");
                    String playerstr[] = player2.get(num).toString().split(" ");
                    if(playerstr[0].equals(laststr[0]) || playerstr[1].equals(laststr[1])){
                        lastCard = player2.get(num).toString();
                        System.out.println("Az asztalon lévő felső lap: " + player2.get(num).toString());
                        player2.remove(num);
                        isCorrect = true;
                    }else{
                        count++;
                    }
                    if(count == 3 * player2.size()){
                        System.out.println("A gépi játékos nem tud rakni!");
                        isover = true;
                        isCorrect = true;
                    }
                }
                    
            }
            System.out.println("A játék véget ért");
            break;
        }
    }
    
    
}
