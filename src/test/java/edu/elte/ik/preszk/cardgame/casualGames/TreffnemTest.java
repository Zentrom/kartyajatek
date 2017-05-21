package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TreffnemTest {

	@Mock
	BufferedReader br;

	@InjectMocks
	Treffnem treffnem;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGame() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("nem", "igen", "nem", "igen", "nem", "igen", "nem", "igen", "nem",
					"igen", "nem", "igen", "nem", "igen", "nem", "igen", "nem", "igen", "nem", "igen", "nem", "igen",
					"nem", "igen", "nem", "igen", "nem", "igen", "nem", "igen");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// WHEN
		treffnem.game();

		// THEN
	}
	
	@Test
	public void testGameWhenException() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenThrow(IOException.class);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// WHEN
		treffnem.game();

		// THEN
	}
}
