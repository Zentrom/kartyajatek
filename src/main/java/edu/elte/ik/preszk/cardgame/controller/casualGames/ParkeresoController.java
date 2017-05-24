package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.HashMap;

import edu.elte.ik.preszk.cardgame.Deck;

public class ParkeresoController {

	private int size1 = 0;
	private int size2 = 0;
	private Deck pakli1;
	private Deck pakli2;
	private String choosed1;
	private String choosed2;
	private int points = 0; 
	private HashMap<Integer, String> cards = new HashMap<>();
	

	public ParkeresoController(Deck pakli1, Deck pakli2) {
		this.pakli1 = pakli1;
		this.pakli2 = pakli2;


	}

	public void init() {
		if (pakli1.size() == 32) {
			size1 = 8;
			size2 = 8;
		} else {
			size1 = 8;
			size2 = 13;
		}

		for (int i = 0; i < pakli1.size(); ++i) {
			cards.put(i, pakli1.getSortedCard(i));
		}
		for (int i = 0; i < pakli2.size(); ++i) {
			cards.put(i + pakli1.size(), pakli2.getSortedCard(i));
		}
	}

	public HashMap<Integer, String> getKartyak() {
		return cards;
	}

	public int getRows() {
		return size1;
	}
	
	public int getCols() {
		return size2;
	}

	public boolean isNextChoicePair(String selected) {
		boolean isPair = false;
		if (choosed1 == null){
            choosed1 = selected;
        }else {
        	choosed2 = selected;
            if(choosed1.equals(choosed2)){
            	isPair = true;
            	choosed1 = null;
            	choosed2 = null;
            	
            }else{
            	choosed1 = null;
            	choosed2 = null;
            }
        }
		return isPair;
	}

	public boolean didIWon() {
		return points == cards.size() / 2;
	}

	public boolean isTwoActive() {
		
		return choosed1 != null;
	}

	public void addPoint() {
		points++;
		
	}
	
	
}
