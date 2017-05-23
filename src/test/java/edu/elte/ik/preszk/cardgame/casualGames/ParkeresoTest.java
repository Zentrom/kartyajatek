package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ParkeresoTest {

	@Mock
	BufferedReader br;

	@InjectMocks
	Parkereso parkereso;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/*@Test
	public void testGameWhenMagyar() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("1","2","3");
			// WHEN

			parkereso.game();
		} catch (IOException e) {
		}
		// THEN

	}*/
	
	@Test
	public void testGameWhenMagyarAndException() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("1").thenThrow(IOException.class);
			// WHEN

			parkereso.game();
		} catch (IOException e) {
		}
		// THEN

	}
	
	/*@Test
	public void testGameWhenFrancia() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("2","3","4");
			// WHEN

			parkereso.game();
		} catch (IOException e) {
		}
		// THEN

	}*/
	
	@Test
	public void testGameWhenInvalid() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("3");
			// WHEN

			parkereso.game();
		} catch (IOException e) {
		}
		// THEN

	}

}
