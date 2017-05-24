package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class KartyaJatekTest {

	
	@Mock
	BufferedReader br;
	
	@Mock
	Passziansz passziansz;
	
	@Mock
	Admiralis admiralis;
	
	@Mock
	Treffnem treffnem;
	
	@Mock
	private SzinreSzin szinreSzin;
	
	@Mock
	private Parkereso parkereso;
	
	@InjectMocks
	KartyaJatek kartyajatek;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	
	@Test
	public void testStartWhenExit() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("0");
			
		} catch (IOException e) {
		}
		
		
		//WHEN
		kartyajatek.start();
		//THEN
	}
	
	@Test
	public void testStartWhenAdmiralis() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("1");
		} catch (IOException e) {
		}
		//WHEN
		kartyajatek.start();
		//THEN
	}
	
	@Test
	public void testStartWhenPassziansz() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("2");
		} catch (IOException e) {
		}
		//WHEN
		kartyajatek.start();
		//THEN
	}
	
	@Test
	public void testStartWhenTreffnem() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("3");
			Mockito.doNothing().when(treffnem).game();
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
	
	
	@Test
	public void testStartWhenSzinreSzin() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("4");
			Mockito.doNothing().when(szinreSzin).game();
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
	

	
	@Test
	public void testStartWhenParkereso() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("5");
			Mockito.doNothing().when(parkereso).game();
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
	
	@Test
	public void testStartWhenParkeresoException() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("5");
			Mockito.doNothing().when(parkereso).game();
			Mockito.doThrow(IOException.class).when(parkereso).game();
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
	
	
	@Test
	public void testStartWhenInvalidNumber() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("6","Hello","0");
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
	
	@Test
	public void testStartWhenExceptionDuringRead() {
		//GIVEN
		try {
			Mockito.when(br.readLine()).thenThrow(IOException.class);
		} catch (IOException e) {
		}
		
		//WHEN
		kartyajatek.start();
		//THEN
		
	}
}
