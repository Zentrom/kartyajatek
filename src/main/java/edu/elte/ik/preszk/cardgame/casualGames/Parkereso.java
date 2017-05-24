/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Lipcsei
 */
import edu.elte.ik.preszk.cardgame.Deck;
import edu.elte.ik.preszk.cardgame.controller.casualGames.ParkeresoController;
import edu.elte.ik.preszk.cardgame.panel.ParkeresoPanel;

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
                ParkeresoPanel panel = new ParkeresoPanel(new ParkeresoController(new Deck(true), new Deck(true)));
                panel.run(); 
                break;
            case 2:
                //francia kártyával indítja a játékot
                //parkereso(false);
                ParkeresoPanel panel2 = new ParkeresoPanel(new ParkeresoController(new Deck(false), new Deck(false)));
                panel2.run();
                break;
            default:
                System.out.println("Megfelelő számot írj be!");
                break;
        }
    }
    
   
}
