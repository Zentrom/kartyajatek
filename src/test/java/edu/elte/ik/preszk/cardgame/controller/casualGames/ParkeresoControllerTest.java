package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.elte.ik.preszk.cardgame.Deck;

public class ParkeresoControllerTest {

	@Mock
	Deck pakli1;
	
	@Mock
	Deck pakli2;
	
	
	@InjectMocks
	ParkeresoController controller;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	 
	@Test
	public void testInitWhenMagyar() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(32);
		Mockito.when(pakli2.size()).thenReturn(32);
		//WHEN
		controller.init();
		//THEN
		
	}
	
	@Test
	public void testInitFrancia() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(52);
		Mockito.when(pakli2.size()).thenReturn(52);
		//WHEN
		controller.init();
		//THEN
		
	}
	
	@Test
	public void testGetKartyak() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		//WHEN
		HashMap<Integer, String> cards = controller.getKartyak();
		//THEN
		Assert.assertEquals(2, cards.size());
		
	}
	
	@Test
	public void testGetRowsWhenMagyar() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(32);
		Mockito.when(pakli2.size()).thenReturn(32);
		controller.init();
		//WHEN
		int rows = controller.getRows();
		//THEN
		Assert.assertEquals(8, rows);
		
	}
	
	@Test
	public void testGetRowsWhenFrancia() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(52);
		Mockito.when(pakli2.size()).thenReturn(52);
		controller.init();
		//WHEN
		int rows = controller.getRows();
		//THEN
		Assert.assertEquals(8, rows);
		
	}
	
	@Test
	public void testGetColsWhenMagyar() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(32);
		Mockito.when(pakli2.size()).thenReturn(32);
		controller.init();
		//WHEN
		int cols = controller.getCols();
		//THEN
		Assert.assertEquals(8, cols);
		
	}
	
	@Test
	public void testGetColsWhenFrancia() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(52);
		Mockito.when(pakli2.size()).thenReturn(52);
		controller.init();
		//WHEN
		int cols = controller.getCols();
		//THEN
		Assert.assertEquals(13, cols);
		
	}
	
	@Test
	public void testDidIWonTrue() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		controller.addPoint();
		//WHEN
		boolean actual = controller.didIWon();
		//THEN
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void testDidIWonFalse() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		//WHEN
		boolean actual = controller.didIWon();
		//THEN
		Assert.assertFalse(actual);
		
	}
	
	@Test
	public void testIsNextChoicePairTrue() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		controller.isNextChoicePair("Makk Asz");
		//WHEN
		boolean actual = controller.isNextChoicePair("Makk Asz");
		//THEN
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void testIsNextChoicePairFalse() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		controller.isNextChoicePair("Makk Kiraly");
		//WHEN
		boolean actual = controller.isNextChoicePair("Makk Asz");
		//THEN
		Assert.assertFalse(actual);
		
	}
	
	@Test
	public void testIsTwoActiveWhenTrue() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		controller.isNextChoicePair("Makk Kiraly");
		//WHEN
		boolean actual = controller.isTwoActive();
		//THEN
		Assert.assertTrue(actual);
		
	}
	
	@Test
	public void testIsTwoActiveWhenFalse() {
		//GIVEN
		Mockito.when(pakli1.size()).thenReturn(1);
		Mockito.when(pakli2.size()).thenReturn(1);
		controller.init();
		//WHEN
		boolean actual = controller.isTwoActive();
		//THEN
		Assert.assertFalse(actual);
		
	}
	
}
