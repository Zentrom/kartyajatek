package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Ez az osztály a Póker kártyajáték kliensének megvalósításáért felel.
 * 
 * @author Preszk Team
 *
 */
public class PokerClient {

	private String username;
	private int vagyon;

	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 */
	public PokerClient() {

	}

	/**
	 * Póker játék elindítása kliens oldalról.
	 * 
	 * @return mennyi pénze van a kliensnek
	 */
	public int play() {
		return 1000;
	}

	/**
	 * Visszaadja a felhasználó nevét
	 * 
	 * @return a felhasználó neve
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Beállítja a felhasználó nevét
	 * 
	 * @param username
	 *            a felhasználó neve
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Vissza adja a felhasználó vagyonát
	 * 
	 * @return a felhasználó vagyona
	 */
	public int getVagyon() {
		return vagyon;
	}

	/**
	 * Beállítja a felhasználó vagyonát
	 * 
	 * @param vagyon
	 *            a felhasználó vagyona
	 */
	public void setVagyon(int vagyon) {
		this.vagyon = vagyon;
	}
}