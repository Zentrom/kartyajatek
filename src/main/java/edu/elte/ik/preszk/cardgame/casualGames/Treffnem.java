package edu.elte.ik.preszk.cardgame.casualGames;

import edu.elte.ik.preszk.cardgame.panel.TreffPanel;
import edu.elte.ik.preszk.cardgame.Deck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Treffnem kártyajáték.
 * @author Lipcsei
 */
public class Treffnem {
	
	private BufferedReader br;
	
	/**
	 * A konstruktor amely inicializálja a Treffnem játékot. 
	 * @param br egy {@link BufferedReader} mely a kommunikációért felel.
	 */
	public Treffnem(BufferedReader br) {
		this.br = br;
	}

	/**
	 * Elindítja a Treffnem kártyajátékot.
	 */
    public void game(){
        TreffPanel panel = new TreffPanel();
        panel.setVisible(true);
        /*while(true){ 
            System.out.println("Ezt a játékot francia kártyával játszák. Tippeld meg hogy a következő kártya treff lesz e ;)");
            int pontszam = 0;
            Deck pakli = new Deck(false);
            int ingame = 0;
            String choose = "";
            
            while(ingame < 30){
                System.out.println("Treff - Clover? (igen-nem)");
                try {
					
                	choose = br.readLine();
				} catch (IOException e) {
					System.err.println("Hiba a beolvasas kozben");
					break;
				}
                
                
                Random random = new Random();
                String szintomb[] = {"Clover" , "Spades" , "Hearts" , "Diamonds"};
                String szin = szintomb[random.nextInt(4)];
                int szamtomb[] = {2,3,4,5,6,7,8,9,10,11,20,30,40};
                int szam = szamtomb[random.nextInt(13)];
                System.out.println(pakli.getLap(szin, szam));
                
                if(szin.equals("Clover")){
                    if(choose.equals("igen"))
                        pontszam = pontszam + 1;
                }
                else{
                    if(choose.equals("igen"))
                        System.out.println("NEM");
                        pontszam = pontszam - 1;
                }
                ingame++;
            }
            //br.close();
            System.out.println("Vége a játéknak! - pontszámod: " + pontszam);
            break;
        }*/
    }
}
