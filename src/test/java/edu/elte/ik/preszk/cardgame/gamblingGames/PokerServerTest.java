package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PokerServerTest {

	
	
	@Before
	public void setUp(){
		
	}
	
	@Test 
	public void test() {
		//GIVEN
		//WHEN
		try {
			PokerServer server = new PokerServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//THEN
	}
	
}
