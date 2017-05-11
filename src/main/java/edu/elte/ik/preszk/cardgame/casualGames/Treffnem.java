package edu.elte.ik.preszk.cardgame.casualGames;

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
 *
 * @author Lipcsei
 */
public class Treffnem {
    public void game() throws IOException{
        while(true){
            System.out.println("Ezt a játékot francia kártyával játszák. Tippeld meg hogy a következő kártya treff lesz e ;)");
            int pontszam = 0;
            Deck pakli = new Deck(false);
            int ingame = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String choose = "";
            
            while(ingame < 30){
                System.out.println("Treff - Clover? (igen-nem)");
                
                choose = br.readLine();
                
                
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
                else if(szin != "Clover"){
                    if(choose.equals("igen"))
                        System.out.println("NEM");
                }
                ingame++;
            }
            //br.close();
            System.out.println("Vége a játéknak! - pontszámod: " + pontszam);
            break;
        }
    }
}
