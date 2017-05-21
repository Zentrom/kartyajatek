package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;
/**
 * Ez az osztály a BlackJack kártyajáték kliensének megvalósításáért felel.
 * @author Preszk Team
 *
 */
public class BlackJackClient{
	
	private final String username;
	private int vagyon;
	private int bet=99999999;
	
	
	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 * @param username a felhasználó neve
	 * @param vagyon a felhasználó vagyona
	 */
	public BlackJackClient(String username,int vagyon){
		this.username = username;
		this.vagyon = vagyon;
	}
	
	
	/**
	 * BlackJack játék elindítása kliens oldalról.
	 * @return mennyi pénze maradt a kliensnek.
	 * @throws IOException ha olvasási hiba történik.
	 */
	public int play()throws IOException{
		Scanner stdin = new Scanner(System.in);
		//System.out.println("Adja meg a nevet!");
		
		try{
			Socket socket = new Socket("localhost", 12345);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			Scanner sc = new Scanner(socket.getInputStream());
		
		
			pw.println(username);
			
			if(sc.nextLine().equals("giveBets")){
				while(bet > vagyon){
					System.out.println("Kerem adja meg mennyit szeretne fogadni!");
					bet=Integer.parseInt(stdin.nextLine());
				}
				pw.println(bet);
				System.out.println("Fogadas elkuldve a szervernek!");
			}
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());          //2-2lap
			
			String uzenet=sc.nextLine();
			String uziSplit[] = uzenet.split(" ");
			while(!uziSplit[0].equals("STATE")){
				System.out.println(uzenet);
				
				int valasztas=0;
				
				while(valasztas != 4 && valasztas!= 5){
					valasztas= Integer.parseInt(stdin.nextLine());
				}
				pw.println(valasztas);
				
				System.out.println(sc.nextLine());
				uzenet=sc.nextLine();
				uziSplit = uzenet.split(" ");
			}
			
			if(uzenet.equals("STATE WIN")){
				vagyon +=bet;
				System.out.println("Gratulalok!Nyert!");
			}else if(uzenet.equals("STATE PUSH")){
				System.out.println("Dontetlen lett!");
			}else if(uzenet.equals("STATE LOSE")){
				vagyon -=bet;
				System.out.println("Sajnos vesztett!");
			}
			
			
			sc.close();
			pw.close();
			socket.close();
			
			
		
		}catch(ConnectException Ce){
			System.out.println("Nem sikerult szerverhez csatlakozni! Uj szerver indul!");
			BlackJackServer BJServer= new BlackJackServer();
			BJServer.main(new String[]{""});
		}
		
		return vagyon;
	}
}