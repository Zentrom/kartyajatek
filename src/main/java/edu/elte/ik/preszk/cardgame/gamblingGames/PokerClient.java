package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Ez az osztály a Póker kártyajáték kliensének megvalósításáért felel.
 * 
 * @author Preszk Team
 *
 */
public class PokerClient {

	private String username;
	private int vagyon;
<<<<<<< HEAD

	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 */
	public PokerClient() {

=======
	private List<Integer> hasznaltSzamok = new ArrayList<>();
	private int bet=9999999;
	
	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 */
	public PokerClient() throws UnknownHostException{
		
>>>>>>> 43f8dcf67941b757dd89dd60ce8e5e2385a447a6
	}

	/**
	 * Póker játék elindítása kliens oldalról.
	 * 
	 * @return mennyi pénze van a kliensnek
	 */
<<<<<<< HEAD
	public int play() {
		return 1000;
=======
	public int play() throws UnknownHostException{
		Scanner stdin = new Scanner(System.in);
		int folytatas=1;
		
		try{
			
				Socket socket = new Socket("localhost", 23456);
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				Scanner sc = new Scanner(socket.getInputStream());
			
			while(folytatas!=0){
				hasznaltSzamok.clear();
				pw.println(getUsername());
				bet=9999999;
				
				if(sc.nextLine().equals("giveBets")){
					while(bet > getVagyon()){
						try{
							System.out.println("Kerem adja meg mennyit szeretne fogadni!");
							bet=Integer.parseInt(stdin.nextLine());
						}catch(NumberFormatException num){
							System.out.println("Nem szamot irt be, ugyhogy bunteteskeppen all-in lesz!");
							bet = getVagyon();
						}
					}
					pw.println(bet);
					System.out.println("Fogadas elkuldve a szervernek!");
				}
				
				System.out.println(sc.nextLine());
				System.out.println(sc.nextLine());
				System.out.println(sc.nextLine());
				System.out.println(sc.nextLine());
				System.out.println(sc.nextLine());    //az 5 kartya.
				
				
				int valasztas=9;
				while(valasztas!=0){
					System.out.println("Irja be hanyadik kartyat szerene lecserelni!(1-5 vagy 0 ha egyiket se)");
					try{
						valasztas=Integer.parseInt(stdin.nextLine());
						if(valasztas >0 && valasztas <= 5){
							if(!hasznaltSzamok.contains(valasztas)){
								hasznaltSzamok.add(valasztas);
								pw.println((valasztas-1));
								System.out.println(sc.nextLine());
							}else{
								System.out.println("Mar hasznalt kartyat akar lecserelni!");
							}
						}else{
							System.out.println("Mar hasznalt kartyat akar lecserelni!");
						}
					}catch(NumberFormatException num){
						System.out.println("Kerem jo erteket adjon meg!");
						valasztas=9;
					}
				}
				pw.println((valasztas-1));
				String uzenet = sc.nextLine();
				
				if(uzenet.equals("STATE RoyalFlush")){
					setVagyon(getVagyon() + (250*bet));
					System.out.println("Gratulalok,Nyert! Royal Flush--> +250x");
				}else if(uzenet.equals("STATE StraightFlush")){
					setVagyon(getVagyon() + (50*bet));
					System.out.println("Gratulalok,Nyert! Straight Flush--> +50x");
				}else if(uzenet.equals("STATE FourOfAKind")){
					setVagyon(getVagyon() + (25*bet));
					System.out.println("Gratulalok,Nyert! Four Of A Kind--> +25x");
				}else if(uzenet.equals("STATE FullHouse")){
					setVagyon(getVagyon() + (9*bet));
					System.out.println("Gratulalok,Nyert! Full House--> +9x");
				}else if(uzenet.equals("STATE Flush")){
					setVagyon(getVagyon() + (6*bet));
					System.out.println("Gratulalok,Nyert! Flush--> +6x");
				}else if(uzenet.equals("STATE Straight")){
					setVagyon(getVagyon() + (4*bet));
					System.out.println("Gratulalok,Nyert! Straight--> +4x");
				}else if(uzenet.equals("STATE ThreeOfAKind")){
					setVagyon(getVagyon() + (3*bet));
					System.out.println("Gratulalok,Nyert! Three Of A Kind--> +3x");
				}else if(uzenet.equals("STATE TwoPair")){
					setVagyon(getVagyon() + (2*bet));
					System.out.println("Gratulalok,Nyert! Two Pairs--> +2x");
				}else if(uzenet.equals("STATE OnePair")){
					setVagyon(getVagyon() + bet);
					System.out.println("Gratulalok,Nyert! One Pair--> +1x");
				}else if(uzenet.equals("STATE JacksOrBetter")){
					//setVagyon(getVagyon() + (25*bet));
					System.out.println("Magas kartya! Jacks Or Better--> +0x");
				}else if(uzenet.equals("STATE Lose")){
					setVagyon(getVagyon() - bet);
					System.out.println("Sajnos vesztett!");
				}else{
					System.out.println("Valami nemjo!");
				}
				
				System.out.println("Jelenlegi vagyona: " + getVagyon());
				System.out.println("Szeretne folytatni a jatekot?(0-val kilepes,mas szammal folytat)");
				try{
					folytatas=Integer.parseInt(stdin.nextLine());
					pw.println(folytatas);
				}catch(NumberFormatException nfe){
					System.out.println("Nem szamot irt be mar megen!Hat akkor nem jatszunk tobbet!");
					folytatas=0;
					pw.println(folytatas);
				}
				
			}
			
			sc.close();
			pw.close();
			socket.close();
			
			
		
		}catch(ConnectException Ce){
			try{
				System.out.println("Nem sikerult szerverhez csatlakozni! Uj szerver indul!");
				PokerServer POServer= new PokerServer();
				POServer.main(new String[]{""});
			}catch(IOException io){
				System.out.println("Iras-olvasasi hiba!");
			}
		}catch(NoSuchElementException nos){
			System.out.println("Megszakadt a kapcsolat a szerverrel!");
		}catch(IOException io){
			System.out.println("Iras-olvasasi hiba!");
		}
			
			
		
		return getVagyon();
>>>>>>> 43f8dcf67941b757dd89dd60ce8e5e2385a447a6
	}

	/**
	 * Visszaadja a felhasználó nevét
	 * 
	 * @return a felhasználó neve
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Beállítja a felhasználó nevét
	 * 
	 * @param username
	 *            a felhasználó neve
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Vissza adja a felhasználó vagyonát
	 * 
	 * @return a felhasználó vagyona
	 */
	public int getVagyon() {
		return vagyon;
	}

	/**
	 * Beállítja a felhasználó vagyonát
	 * 
	 * @param vagyon
	 *            a felhasználó vagyona
	 */
	public void setVagyon(int vagyon) {
		this.vagyon = vagyon;
	}
}