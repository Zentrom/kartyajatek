package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.Random;

import edu.elte.ik.preszk.cardgame.Deck;

public class TreffNemController {

	private String szintomb[] = {"Clover" , "Spades" , "Hearts" , "Diamonds"};
    private int szamtomb[] = {2,3,4,5,6,7,8,9,10,11,20,30,40};
	private Deck deck;
	private Random random;
	String szin = "";
	
	public TreffNemController(Deck deck, Random random) {
		this.deck = deck;
		this.random = random;
	}

	public String getKovetkezoKartya() {
    	szin = szintomb[random.nextInt(4)];        
        int szam = szamtomb[random.nextInt(13)];
        
		return deck.getLap(szin, szam);
	}

	public int getPontszam(int pontszam) {
		int ujPontszam = pontszam;
		 if(szin.equals("Clover")){
			 ujPontszam = pontszam + 1;
	        } else {
	        	ujPontszam = pontszam - 1;
	        }
		 return ujPontszam;
	}
	
	
	
	
}
