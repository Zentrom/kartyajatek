package edu.elte.ik.preszk.cardgame.gamblingGames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.elte.ik.preszk.cardgame.Deck;

public class BJCardHandlerTest {

	@Mock
	Deck deck;

	@InjectMocks
	BJCardHandler handler;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetNextCardName() {
		// GIVEN
		Mockito.when(deck.getSortedCard(Mockito.anyInt())).thenReturn("card");
		// WHEN
		String actual = handler.getNextCardName();
		// THEN
		Assert.assertEquals("card", actual);
	}

	@Test
	public void testGetNextCardValueWhen2() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 2");
		// THEN
		Assert.assertEquals(2, actual);
	}

	@Test
	public void testGetNextCardValueWhen3() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 3");
		// THEN
		Assert.assertEquals(3, actual);
	}

	@Test
	public void testGetNextCardValueWhen4() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 4");
		// THEN
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testGetNextCardValueWhen5() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 5");
		// THEN
		Assert.assertEquals(5, actual);
	}

	@Test
	public void testGetNextCardValueWhen6() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 6");
		// THEN
		Assert.assertEquals(6, actual);
	}

	@Test
	public void testGetNextCardValueWhen7() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 7");
		// THEN
		Assert.assertEquals(7, actual);
	}

	@Test
	public void testGetNextCardValueWhen8() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 8");
		// THEN
		Assert.assertEquals(8, actual);
	}

	@Test
	public void testGetNextCardValueWhen9() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 9");
		// THEN
		Assert.assertEquals(9, actual);
	}

	@Test
	public void testGetNextCardValueWhen10() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 10");
		// THEN
		Assert.assertEquals(10, actual);
	}

	@Test
	public void testGetNextCardValueWhenJ() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart J");
		// THEN
		Assert.assertEquals(10, actual);
	}

	@Test
	public void testGetNextCardValueWhenQ() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart Q");
		// THEN
		Assert.assertEquals(10, actual);
	}

	@Test
	public void testGetNextCardValueWhenK() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart K");
		// THEN
		Assert.assertEquals(10, actual);
	}

	@Test
	public void testGetNextCardValueWhenA() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart A");
		// THEN
		Assert.assertEquals(11, actual);
	}

	@Test
	public void testGetNextCardValueWhenInvalid() {
		// GIVEN
		// WHEN
		int actual = handler.getCardValue("Heart 555");
		// THEN
		Assert.assertEquals(0, actual);
	}
	
}
