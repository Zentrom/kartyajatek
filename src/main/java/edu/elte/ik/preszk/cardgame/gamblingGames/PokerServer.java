package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;
import edu.elte.ik.preszk.cardgame.Deck;
/**
 * Ez az osztály a Póker kártyajáték szerverének megvalósításáért felel.
 * @author Preszk Team
 *
 */
public class PokerServer{
	
	private ServerSocket server;
	private Socket firstClient;

	/**
	 * A Póker szerver létrehozásáért felelős konstruktor.
	 * 
	 * @throws IOException
	 *             ha olvasási hiba történik.
	 */
	public PokerServer() throws IOException {
		server = new ServerSocket(23456);

		firstClient = server.accept();

		PokerJatek jatek = new PokerJatek(server, firstClient);
		jatek.start();
	}

	public static void main(String args[]) throws IOException {
		// BlackJackServer bjServer= new BlackJackServer();

	}
	
}

/**
 * Ez az osztály a Póker játék többszálú megoldására szolgál.
 * 
 * @author Preszk Team
 *
 */
class PokerJatek extends Thread {
	ServerSocket server;
	Socket firstClient;

	String currentCard;
	Deck pokerPakli=new Deck(false);
	
	String firstJatekos;
	String firstJatekosKartyak[][] = new String[2][5];
	int firstBet;
	int hanyadik = 0;
	int folytatodik = 0;
	String uzenet="";


	/**
	 * A játék elindításáért felelős konstruktor.
	 * 
	 * @param server
	 *            a szerver
	 * @param firstClient
	 *            az első kliens.
	 */
	public PokerJatek(ServerSocket server, Socket firstClient) {
		this.server = server;
		this.firstClient = firstClient;
		folytatodik++;

		reset();
	}

	/**
	 * Elindítja szervert.
	 */
	@Override
	public void run() {
		try {
			PrintWriter fpw = new PrintWriter(firstClient.getOutputStream(), true);
			Scanner fsc = new Scanner(firstClient.getInputStream());

			while (folytatodik != 0) {
				System.out.println("A jatek elkezdodik!");
				
				reset();
				firstJatekos = fsc.nextLine();
				fpw.println("giveBets");
				firstBet = Integer.parseInt(fsc.nextLine());

				for(int i=0;i<5;i++){
					handleSzett(i);
					fpw.println("Az " + i + ". kapott kartyaja: " + firstJatekosKartyak[0][i] + " " + firstJatekosKartyak[1][i]);
					System.out.println(firstJatekos +" " + i + ". kapott kartyaja: " + firstJatekosKartyak[0][i] + " " + firstJatekosKartyak[1][i]);
				}
				
				int tmpSzam=0;
				while(!uzenet.equals("0")){
					uzenet=fsc.nextLine();
					tmpSzam=Integer.parseInt(uzenet);
					handleSzett(tmpSzam);
					fpw.println("Az " + tmpSzam + ". kapott kartyaja: " + firstJatekosKartyak[0][tmpSzam] + " " + firstJatekosKartyak[1][tmpSzam]);
					System.out.println(firstJatekos +" " + tmpSzam + ". kapott kartyaja: " + firstJatekosKartyak[0][tmpSzam] + " " + firstJatekosKartyak[1][tmpSzam]);
				}
				
				jatekHandler(firstJatekosKartyak, fpw);
				
				
				folytatodik=Integer.parseInt(fsc.nextLine());
			}

			fsc.close();
			fpw.close();
			firstClient.close();
			
			System.exit(0);

		} catch (IOException e) {
			System.out.println("Szerver Iras-olvasasi hiba");
		} catch (NoSuchElementException nos){
			System.out.println("Megszakadt a kapcsolat a kliensel!");
		}
	}
	
	/**
	 * Beállítja a játékos egyik kártyáját.
	 * 
	 */
	private void handleSzett(int hely){
		String tmp[] = pokerPakli.getSortedCard(hanyadik).split(" ");
		firstJatekosKartyak[0][hely]= tmp[0];
		firstJatekosKartyak[1][hely]= tmp[1];
		hanyadik++;
	}
	
	
	/**
	 * Lekezeli a Poker játékot a játékos kártyái alapján.
	 * 
	 */
	private void jatekHandler(String jatekosKartyak[][], PrintWriter pw) { 
		/*try{
			
		}catch(IOException io){
			System.out.println("Szerver irasi hiba!");
		}*/
	}

	
	/**
	 * mindent visszaállít alapértékre.
	 */
	private void reset() { // visszaallit mindent alapertekre
		uzenet="";
		hanyadik = 0;
		firstBet = 0;
		pokerPakli = new Deck(false);

		for (int i = 0; i < 2; i++) {
			for(int j=0; j<5; j++){
				firstJatekosKartyak[i][j]="";
			}
		}
		
	}

}