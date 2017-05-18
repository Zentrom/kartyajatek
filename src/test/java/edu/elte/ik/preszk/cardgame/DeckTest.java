/**
 * 
 */
package edu.elte.ik.preszk.cardgame;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author Peti
 *
 */
public class DeckTest extends TestCase {

	/**
	 * @param name
	 */
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructor() {
		//GIVEN
		//WHEN
		Deck magyar = new Deck(true);
		Deck francia = new Deck(false);
		//THEN
		Assert.assertNotNull(magyar);
		Assert.assertNotNull(francia);
	}

	public void testGetPakli() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		HashMap <String,Map<Integer,String>> pakli = magyar.getPakli();
		//THEN
		Assert.assertEquals(4, pakli.size());
	}
	
	public void testPrintDeck() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		magyar.printDeck();
		//THEN
		
	}
	
	public void testGetLapWhenNotFoundColor() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		String actual = magyar.getLap("Sarga",42);
		//THEN
		Assert.assertEquals("hibas laplekerdezes!", actual);
	}
	
	public void testGetLapWhenNotFoundNumber() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		String actual = magyar.getLap("Piros",42);
		//THEN
		Assert.assertEquals("hibas laplekerdezes!", actual);
	}
	
	public void testGetLap() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		String actual = magyar.getLap("Piros",3);
		//THEN
		Assert.assertEquals("Piros Felso", actual);
	}
	
	public void testGetSortedCard() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		String actual = magyar.getSortedCard(3);
		//THEN
	}
	
	public void testWhenInvalid() {
		//GIVEN
		Deck magyar = new Deck(true);
		//WHEN
		String actual = magyar.getSortedCard(42);
		//THEN
	}
}
