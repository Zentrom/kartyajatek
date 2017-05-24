package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.elte.ik.preszk.cardgame.Deck;

public class TreffNemControllerTest {

	
	@Mock
	private Deck deck;
	
	@Mock
	private Random random;
	
	@InjectMocks
	private TreffNemController controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetKovetkezoKartya() {
		//GIVEN
		Mockito.when(random.nextInt(4)).thenReturn(0);
		Mockito.when(random.nextInt(13)).thenReturn(0);
		Mockito.when(deck.getLap("Clover", 2)).thenReturn("Clover 2");
		//WHEN
		String actual = controller.getKovetkezoKartya();
		//THEN
		Assert.assertEquals("Clover 2", actual);
		
	}
	
	@Test
	public void getPontszamWhenClover() {
		//GIVEN
		Mockito.when(random.nextInt(4)).thenReturn(0);
		Mockito.when(deck.getLap("Clover", 2)).thenReturn("Clover 2");
		//WHEN
		controller.getKovetkezoKartya();
		int actual = controller.getPontszam(2);
		//THEN
		Assert.assertEquals(3, actual);
		
	}
	
	@Test
	public void getPontszamWhenNotClover() {
		//GIVEN
		Mockito.when(random.nextInt(4)).thenReturn(1);
		Mockito.when(deck.getLap("Spades", 2)).thenReturn("Spades 2");
		//WHEN
		controller.getKovetkezoKartya();
		int actual = controller.getPontszam(2);
		//THEN
		Assert.assertEquals(1, actual);
		
	}
	
	
}

