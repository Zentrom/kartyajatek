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

	/**
	 * Elindítja a szervert
	 * 
	 * @param args
	 *            bemeneti argumentumok
	 * @throws IOException
	 *             ha olvasási hiba van.
	 */
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
	 *  @param hely jatekos helye
	 */
	private void handleSzett(int hely){
		String tmp[] = pokerPakli.getSortedCard(hanyadik).split(" ");
		firstJatekosKartyak[0][hely]= tmp[0];
		firstJatekosKartyak[1][hely]= tmp[1];
		hanyadik++;
	}
	
	
	/**
	 * Lekezeli a Poker játékot a játékos kártyái alapján.
	 * @param jatekosKartyak a jatekos kartyai
	 * @param pw {@link PrintWriter} üzenet küldésére szolgál
	 */
	private void jatekHandler(String jatekosKartyak[][], PrintWriter pw) { 
		//try{
			Boolean ugyanazASzin = true;
			String tmpSzin = jatekosKartyak[0][0];
			for(int i=1;i<5;i++){
				if(!jatekosKartyak[0][i].equals(tmpSzin)){
					ugyanazASzin= false;
				}
			}
			
			//royalFlush
			Boolean vaneRoyal = true;
			Boolean royalFlush[]= new Boolean[5];
			Arrays.fill(royalFlush,false);
			int royalIndex = 0;
			if(ugyanazASzin){
				for(int i=0;i<5;i++){
					if(jatekosKartyak[1][i].equals("A")){
						royalFlush[royalIndex] = true;
						royalIndex++;
						break;
					}
				}
				for(int i=0;i<5;i++){
					if(jatekosKartyak[1][i].equals("K")){
						royalFlush[royalIndex] = true;
						royalIndex++;
						break;
					}
				}
				for(int i=0;i<5;i++){
					if(jatekosKartyak[1][i].equals("Q")){
						royalFlush[royalIndex] = true;
						royalIndex++;
						break;
					}
				}
				for(int i=0;i<5;i++){
					if(jatekosKartyak[1][i].equals("J")){
						royalFlush[royalIndex] = true;
						royalIndex++;
						break;
					}
				}
				for(int i=0;i<5;i++){
					if(jatekosKartyak[1][i].equals("10")){
						royalFlush[royalIndex] = true;
						royalIndex++;
						break;
					}
				}
			}
			for(int i=0;i<5;i++){
				if(royalFlush[i]==false) vaneRoyal=false;
			}
			
			if(vaneRoyal){
				pw.println("STATE RoyalFlush");
				System.out.println(firstJatekos+ " nyert! Royal Flush!");
				return;
			}
			
			//Arrays.sort(jatekosKartyak);
			Boolean kovetikEgymast = false;
			//Boolean egyezesek[] = new Boolean[5];
			//Arrays.fill(egyezesek,false)
			//egyezesek[0] = true;
			int egyezesekSzam = 1;
			String kezdoKartya = jatekosKartyak[1][0];
			switch(kezdoKartya){
				case "A":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("K")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("Q")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("J")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("10")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "K":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("Q")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("J")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("10")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("9")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "Q":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("J")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("10")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("9")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("8")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "J":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("10")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("9")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("8")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("7")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "10":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("9")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("8")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("7")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("6")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "9":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("8")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("7")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("6")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("5")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "8":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("7")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("6")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("5")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("4")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "7":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("6")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("5")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("4")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("3")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "6":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("5")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("4")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("3")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("2")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "5":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("4")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("3")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("2")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("A")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "4":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("3")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("2")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("A")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("K")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "3":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("2")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("A")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("K")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("Q")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
				case "2":
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("A")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("K")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("Q")){
							egyezesekSzam++;
							break;
						}
					}
					for(int i=1;i<5;i++){
						if(jatekosKartyak[1][i].equals("J")){
							egyezesekSzam++;
							break;
						}
					}
					if(egyezesekSzam==5) kovetikEgymast=true;
					break;
			}
			
			//StraightFlush
			if(ugyanazASzin && kovetikEgymast){
				pw.println("STATE StraightFlush");
				System.out.println(firstJatekos+ " nyert! Straight Flush!");
				return;
			}
			
			int parSzam[] = {1,0,0,0};
			String masodKartya = "";
			String harmadKartya ="";
			String negyedKartya = "";
			for(int i=1;i<5;i++){
				if(kezdoKartya.equals(jatekosKartyak[1][i])){
					parSzam[0]++;
				}else if(masodKartya.equals("") || masodKartya.equals(jatekosKartyak[1][i])){
					masodKartya = jatekosKartyak[1][i];
					parSzam[1]++;
				}else if(harmadKartya.equals("") || harmadKartya.equals(jatekosKartyak[1][i])){
					harmadKartya = jatekosKartyak[1][i];
					parSzam[2]++;
				}else if(negyedKartya.equals("") || negyedKartya.equals(jatekosKartyak[1][i])){
					negyedKartya = jatekosKartyak[1][i];
					parSzam[3]++;
				}
			}
			
			//FourOfAKind
			Boolean fourOfAKind = false;
			for(int i=0;i<4;i++){
				if(parSzam[i]==4) fourOfAKind = true;
			}
			
			if(fourOfAKind){
				pw.println("STATE FourOfAKind");
				System.out.println(firstJatekos+ " nyert! Four Of A Kind!");
				return;
			}
			//FullHouse
			Boolean fullHouseElsoFelt = false;
			Boolean fullHouseMasodikFelt = false;
			for(int i=0;i<4;i++){
				if(parSzam[i]==3) fullHouseElsoFelt = true;
				if(parSzam[i]==2) fullHouseMasodikFelt = true;
			}
			
			if(fullHouseElsoFelt && fullHouseMasodikFelt){
				pw.println("STATE FullHouse");
				System.out.println(firstJatekos+ " nyert! Full House!");
				return;
			}
			
			//Flush
			if(ugyanazASzin){
				pw.println("STATE Flush");
				System.out.println(firstJatekos+ " nyert! Flush!");
				return;
			}
			
			//Straight
			if(kovetikEgymast){
				pw.println("STATE Straight");
				System.out.println(firstJatekos+ " nyert! Straight!");
				return;
			}
			
			//ThreeOfAKind
			if(fullHouseElsoFelt){
				pw.println("STATE ThreeOfAKing");
				System.out.println(firstJatekos+ " nyert! Three Of A Kind!");
				return;
			}
			
			//TwoPair
			Boolean twoPairElso = false;
			Boolean twoPairMasodik = false;
			for(int i=0;i<4;i++){
				if(parSzam[i]==2 && twoPairElso==true) twoPairMasodik = true;
				if(parSzam[i]==2) twoPairElso=true;
			}
			
			if(twoPairElso && twoPairMasodik){
				pw.println("STATE TwoPair");
				System.out.println(firstJatekos+ " nyert! Two Pair!");
				return;
			}
			
			//OnePair
			if(twoPairElso){
				pw.println("STATE OnePair");
				System.out.println(firstJatekos+ " nyert! One Pair!");
				return;
			}
			
			//JacksOrBetter
			Boolean jacksOrBetter = false;
			for(int i=0;i<5;i++){
				if(jatekosKartyak[1][i].equals("A") || jatekosKartyak[1][i].equals("K") || jatekosKartyak[1][i].equals("Q") || jatekosKartyak[1][i].equals("J")){
					jacksOrBetter = true;
				}
			}
			
			if(jacksOrBetter){
				pw.println("STATE JacksOrBetter");
				System.out.println(firstJatekos+ " nyert! Jacks Or Better!");
				return;
			}
			
			pw.println("STATE Lose");
			System.out.println(firstJatekos+ " vesztett!");
			return;
			
		//}catch(IOException io){
		//	System.out.println("Szerver irasi hiba!");
		//}
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