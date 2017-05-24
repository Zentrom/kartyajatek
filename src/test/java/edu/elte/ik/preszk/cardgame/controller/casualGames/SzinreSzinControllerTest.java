package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.elte.ik.preszk.cardgame.Deck;

public class SzinreSzinControllerTest {

	@Mock
	private Deck deck;

	@Mock
	private Random random;

	@InjectMocks
	private SzinreSzinController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIsCorrectWhenEmpty() {
		// GIVEN
		controller.setDecks();
		// WHEN
		boolean actual = controller.isCorrect("Tok Also");
		// THEN
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsCorrectWhenNotEmptySzinJo() {
		// GIVEN
		controller.setDecks();
		controller.isCorrect("Tok Also");
		// WHEN
		boolean actual = controller.isCorrect("Tok Kiraly");
		// THEN
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsCorrectWhenNotEmptySzamJo() {
		// GIVEN
		controller.setDecks();
		controller.isCorrect("Tok Also");
		// WHEN
		boolean actual = controller.isCorrect("Makk Also");
		// THEN
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsCorrectWhenNemJoInput() {
		// GIVEN
		controller.setDecks();
		controller.isCorrect("Tok Also");
		// WHEN
		boolean actual = controller.isCorrect("Makk Kiraly");
		// THEN
		Assert.assertFalse(actual);
	}

	@Test
	public void testJatekosPakli() {
		// GIVEN
		controller.setDecks();
		// WHEN
		List<String> actual = controller.getJatekosPakli();
		// THEN
		Assert.assertEquals(16, actual.size());
	}

	@Test
	public void testGepTudERakniIgenSzint() {
		// GIVEN
		Mockito.when(deck.getSortedCard(Mockito.anyInt())).thenReturn("Makk Kiraly");
		controller.setDecks();
		controller.isCorrect("Makk Asz");
		// WHEN
		boolean actual = controller.gepTudERakni();
		// THEN
		Assert.assertTrue(actual);
	}

	@Test
	public void testGepTudERakniIgenSzamot() {
		// GIVEN
		Mockito.when(deck.getSortedCard(Mockito.anyInt())).thenReturn("Makk Asz");
		controller.setDecks();
		controller.isCorrect("Tok Asz");
		// WHEN
		boolean actual = controller.gepTudERakni();
		// THEN
		Assert.assertTrue(actual);
	}

	@Test
	public void testGepTudERakniNem() {
		// GIVEN
		Mockito.when(deck.getSortedCard(Mockito.anyInt())).thenReturn("Makk Asz");
		controller.setDecks();
		controller.isCorrect("Tok Kiraly");
		// WHEN
		boolean actual = controller.gepTudERakni();
		// THEN
		Assert.assertFalse(actual);
	}



	@Test
	public void testGetUtolsoLap() {
		// GIVEN
		controller.isCorrect("Tok Kiraly");
		// WHEN
		String actual = controller.getUtolsoLap();
		// THEN
		Assert.assertEquals("Tok Kiraly",actual);
	}
	
	
	@Test
	public void testGetGepLapja() {
		// GIVEN
		Mockito.when(deck.getSortedCard(Mockito.anyInt())).thenReturn("Tok Asz");
		controller.setDecks();
		controller.isCorrect("Tok Kiraly");
		controller.gepTudERakni();
		// WHEN
		String actual = controller.getGepLapja();
		// THEN
		Assert.assertEquals("Tok Asz",actual);
	}
}
