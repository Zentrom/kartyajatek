package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;
/**
 * Ez az osztály a Póker kártyajáték kliensének megvalósításáért felel.
 * @author Preszk Team
 *
 */
public class PokerClient{
	
	
	private String username;
	private int vagyon;
	
	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 */
	public PokerClient(){
		
	}
	
	/**
	 * Póker játék elindítása kliens oldalról.
	 * @return mennyi pénze van a kliensnek
	 */
	public int play(){
		return 1000;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getVagyon() {
		return vagyon;
	}

	public void setVagyon(int vagyon) {
		this.vagyon = vagyon;
	}
}