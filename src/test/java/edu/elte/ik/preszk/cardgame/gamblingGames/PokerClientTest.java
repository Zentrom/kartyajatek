package edu.elte.ik.preszk.cardgame.gamblingGames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PokerClientTest {

	@Before
	public void setUp(){
		
	}
	
	@Test 
	public void testPlay() {
		//GIVEN
		PokerClient client = new PokerClient();
		//WHEN
		int actual = client.play();
		//THEN
		Assert.assertEquals(1000, actual);
	}
}
