package edu.elte.ik.preszk.cardgame.gamblingGames;

import edu.elte.ik.preszk.cardgame.Deck;
import java.io.*;
import java.util.*;


public class BJCardHandler{
	
	//private String cardName;
	//private String cardValue;
	private Deck pakli = new Deck(false);
	private int hanyadik = 0;
	
	public BJCardHandler(){
		//semmi
	}
	
	public String getNextCardName(){               //következo kártya Stringbe
		String vissza=pakli.getSortedCard(hanyadik);
		hanyadik++;
		return vissza;
	}
	
	public int getCardValue(String cardName){						//visszaadja a kártya értékét blackjackben
		String[] felosztott = cardName.split(" ");
		
		switch(felosztott[1]){
			case "2":
				return 2;
				//break;
			case "3":
				return 3;
				//break;
			case "4":
				return 4;
				//break;
			case "5":
				return 5;
				//break;
			case "6":
				return 6;
				//break;
			case "7":
				return 7;
				//break;
			case "8":
				return 8;
				//break;
			case "9":
				return 9;
				//break;
			case "10":
				return 10;
				//break;
			case "J":
				return 10;
				//break;
			case "Q":
				return 10;
				//break;
			case "K":
				return 10;
				//break;
			case "A":
				return 11;
				//break;
			default:
				return 0;
				//break;
		}
	}
	
}