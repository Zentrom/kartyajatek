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
	
	private String username;
	private int vagyon;
	private int bet=99999999;
	
	
	/**
	 * Új kliens létrehozásáért felelős konstruktor.
	 */
	public BlackJackClient(){
	}
	
	
	/**
	 * BlackJack játék elindítása kliens oldalról.
	 * @return mennyi pénze maradt a kliensnek.
	 * @throws IOException ha olvasási hiba történik.
	 */
	public int play()throws IOException{
		Scanner stdin = new Scanner(System.in);
		//System.out.println("Adja meg a nevet!");
		
		//int indulasSzam = 0;
		
		try{
			Socket socket = new Socket("localhost", 12345);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			Scanner sc = new Scanner(socket.getInputStream());
		
		
			pw.println(getUsername());
			
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
			System.out.println(sc.nextLine());          //2-2lap
			
			String uzenet=sc.nextLine();
			String uziSplit[] = uzenet.split(" ");
			while(!uziSplit[0].equals("STATE")){
				System.out.println(uzenet);
				
				int valasztas=0;
				
				while(valasztas != 4 && valasztas!= 5){
					try{
						valasztas= Integer.parseInt(stdin.nextLine());
					}catch(NumberFormatException num){
						System.out.println("4-est vagy 5-ost irjon be!");
						valasztas=9999;
					}
				}
				pw.println(valasztas);
				
				System.out.println(sc.nextLine());
				uzenet=sc.nextLine();
				uziSplit = uzenet.split(" ");
			}
			
			if(uzenet.equals("STATE WIN")){
				setVagyon(getVagyon() + bet);
				System.out.println("Gratulalok!Nyert!");
			}else if(uzenet.equals("STATE PUSH")){
				System.out.println("Dontetlen lett!");
			}else if(uzenet.equals("STATE LOSE")){
				setVagyon(getVagyon() - bet);
				System.out.println("Sajnos vesztett!");
			}
			
			
			sc.close();
			pw.close();
			socket.close();
			
			
		
		}catch(ConnectException Ce){
			System.out.println("Nem sikerult szerverhez csatlakozni! Uj szerver indul!");
			BlackJackServer BJServer= new BlackJackServer();
			BJServer.main(new String[]{""});
		}catch(NoSuchElementException nos){
			System.out.println("Megszakadt a kapcsolat a szerverrel!");
		}
			
			
		
		return getVagyon();
	}


	public String getUsername() {
		return username;
	}


	public int getVagyon() {
		return vagyon;
	}


	public void setVagyon(int vagyon) {
		this.vagyon = vagyon;
	}


	public void setUsername(String username) {
		this.username = username;
	}
}