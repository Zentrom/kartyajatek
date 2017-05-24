/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.casualGames;

import java.util.Random;

import edu.elte.ik.preszk.cardgame.Deck;
import edu.elte.ik.preszk.cardgame.controller.casualGames.SzinreSzinController;
import edu.elte.ik.preszk.cardgame.panel.SzinPanel;

/**
 *
 * @author Lipcsei
 */
public class SzinreSzin {

	public SzinreSzin() {
	}

	/**
	 * Elindítja a Színre szín kártyajátékot.
	 * 
	 * 
	 */
	void game() {
		SzinPanel panel = new SzinPanel(new SzinreSzinController(new Deck(true), new Random()));
		panel.setVisible(true);
	}

}
