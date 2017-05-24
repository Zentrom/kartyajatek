package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.util.Random;

import edu.elte.ik.preszk.cardgame.Deck;
import edu.elte.ik.preszk.cardgame.controller.casualGames.TreffNemController;
import edu.elte.ik.preszk.cardgame.panel.TreffPanel;

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
	
	
	/**
	 * A konstruktor amely inicializálja a Treffnem játékot. 
	 */
	public Treffnem() {
	}

	/**
	 * Elindítja a Treffnem kártyajátékot.
	 */
    public void game(){
    	TreffNemController treffNemController = new TreffNemController(new Deck(false), new Random());
        TreffPanel panel = new TreffPanel(treffNemController);
        panel.setVisible(true);
     
    }
}
