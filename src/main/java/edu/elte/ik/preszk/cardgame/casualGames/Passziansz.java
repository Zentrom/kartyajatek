package edu.elte.ik.preszk.cardgame.casualGames;

import edu.elte.ik.preszk.cardgame.Deck;

/**
 * Passziánsz játék.
 * @author Preszk Team
 *
 */
public class Passziansz{

	/**
	 * Elindítja a passziánsz játékot.
	 */
    public void game(){
        while(true){
            boolean francia = false;
            Deck pakli = new Deck(francia);
            
            pakli.printDeck();
            
            break;
        }
    }
}   
