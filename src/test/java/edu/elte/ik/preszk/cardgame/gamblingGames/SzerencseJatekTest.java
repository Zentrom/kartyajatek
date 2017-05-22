package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SzerencseJatekTest {

	@Mock 
	BlackJackClient blackJackclient;
	
	@Mock
	PokerClient pokerClient;
	
	
	@Mock
	private BufferedReader br;

	@InjectMocks
	private SzerencseJatek szerencseJatek;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testprintMenuWhenExit() {
		// GIVEN
		try {
			Mockito.when(br.readLine()).thenReturn("0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN

	}
	
	@Test
	public void testprintMenuWhenRegisztracioSikeres() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN

	}
	
	@Test
	public void testprintMenuWhenRegisztracioHasznaltUser() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","a","a","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN

	}
	
	@Test
	public void testprintMenuWhenRegisztracioHasznaltUser2() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","a","2","b","b","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN

	}
	
	@Test
	public void testprintMenuWhenRegisztracioNincsFajl() {
		// GIVEN
		new File("data").delete();
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","a","2","b","b","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepes() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepesRestoreCredits1000() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","3","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepesRestoreCredits0() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","1","3","0");
			Mockito.when(blackJackclient.getVagyon()).thenReturn(0);
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepesInvalid() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","a","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepesBlackJack() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","1","0");
			Mockito.when(blackJackclient.getVagyon()).thenReturn(500);
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikeresBelepesPoker() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","a","2","0");
			Mockito.when(pokerClient.getVagyon()).thenReturn(500);
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenSikertelenBelepes() {
		// GIVEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Mockito.when(br.readLine()).thenReturn("2","a","a","2","b","b","1","a","b","b","b","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		
	}
	
	@Test
	public void testprintMenuWhenBelepesNincsFajl() {
		// GIVEN
		new File("data").delete();
		
		try {
			Mockito.when(br.readLine()).thenReturn("1","a","a","0");
		// WHEN
		szerencseJatek.printMenu();
		} catch (IOException e) {
		}
		// THEN
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("data"));
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
