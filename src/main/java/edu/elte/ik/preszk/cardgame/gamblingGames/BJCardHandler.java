package edu.elte.ik.preszk.cardgame.gamblingGames;

import edu.elte.ik.preszk.cardgame.Deck;

/**
 * Ez az osztály a BlackJack játék kártyakezeléséért felel.
 * @author Preszk Team
 *
 */
public class BJCardHandler{
	
	//private String cardName;
	//private String cardValue;
	private Deck pakli;
	private int hanyadik = 0;
	
	/**
	 * A kártyakezelés konstruktora.
	 * @param pakli {@link Deck} egy franciakártya pakli.
	 */
	public BJCardHandler(Deck pakli){
		this.pakli = pakli;
	}
	
	/**
	 * A következő kártyát adja vissza.
	 * @return {@link String} típusban a következő kártya.
	 */
	public String getNextCardName(){               //következo kártya Stringbe
		String vissza=pakli.getSortedCard(hanyadik);
		hanyadik++;
		return vissza;
	}
	
	
	/**
	 * Visszaadja, hogy az adott kártya mennyi ér BlackJackben.
	 * @param cardName a kártya neve.
	 * @return {@link int} típusban a kártya értéke.
	 */
	
	public int getCardValue(String cardName){						//visszaadja a kártya értékét blackjackben
		String[] felosztott = cardName.split(" ");
		
		if( felosztott[1].equals("2")) {
			
				return 2;
		}else if( felosztott[1].equals("3")) {
			return 3;
					
		} else if( felosztott[1].equals("4")) {
				return 4;
		} else if( felosztott[1].equals("5")) {		
				return 5;
		} else if( felosztott[1].equals("6")) {
				return 6;
		} else if( felosztott[1].equals("7")) {
				return 7;
		} else if( felosztott[1].equals("8")) {
				return 8;
		} else if( felosztott[1].equals("9")) {
				return 9;
		} else if( felosztott[1].equals("10") ||  felosztott[1].equals("J") ||  felosztott[1].equals("Q") ||  felosztott[1].equals("K")) {
				return 10;
		} else if( felosztott[1].equals("A")) {
				return 11;
		}else {
				return 0;
		}
	}
	
}