package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;
import java.net.*;

public class BlackJackServer{
	
	private ServerSocket server;
	private Socket firstClient;
	
	public BlackJackServer() throws IOException{
		server = new ServerSocket(12345);
		
		firstClient=server.accept();
		
		Jatek jatek = new Jatek(server,firstClient);
		jatek.start();
	}
}

class Jatek extends Thread{
	ServerSocket server;
	Socket firstClient;
	//Socket secondClient;
	//Deck pakli = new Deck(false);
	
	BJCardHandler bjHandler;
	//=new BJCardHandler();
	Boolean jatekVege=false;
	String currentCard;
	
	String dealerKartyak[]= new String[5];
	int dealerPoints[]= new int[5];
	
	String firstJatekos;
	String firstJatekosKartyak[][]= new String[4][5];
	int firstBet;
	int firstPoints[][]= new int[4][5];
	
	//String secondjatekos;
	Random r=new Random();
	int folytatodik = 0;
	String uzenet;
	//long currentTime=System.currentTimeMillis();
	//String nyertes;
	
	public Jatek(ServerSocket server,Socket firstClient){
		this.server=server;
		this.firstClient=firstClient;
		folytatodik++;
		
		//reset();
		//this.secondClient=secondClient;
	}
	
	@Override
	public void run(){
		try{
			PrintWriter fpw = new PrintWriter(firstClient.getOutputStream(), true);
			Scanner fsc = new Scanner(firstClient.getInputStream());
			//PrintWriter spw = new PrintWriter(secondClient.getOutputStream(), true);
			//Scanner ssc = new Scanner(secondClient.getInputStream());
			
			while(folytatodik!=0){
				
				reset();
				firstJatekos=fsc.nextLine();
				fpw.println("giveBets");
				firstBet=Integer.parseInt(fsc.nextLine());
				
				jatekVege=false;
				while(jatekVege!=true){
					
					currentCard=bjHandler.getNextCardName();
					//int firstPoints[0][0]=bjHandler.getCardValue(currentCard);
					
					if(firstPoints[0][0] == 11) firstPoints[1][0] = 1;
					
																											//INNEN KELL FOLYTASSAM!!!!
																											//
																											//
																											//
																											
																											//
																											
																											
																											
																											
																											//
																											
																											//
				}
			}
			
			fsc.close();
			fpw.close();
			

		}catch(IOException e){
			System.out.println("Szerver Iras-olvasasi hiba");
		}
	}
	
	private int osszesit(int[] kartyaSzett){             //jatekos/dealer pontjainak osszesitese 
		int vissza=0;
		for(int i=0;i<5;i++){
			vissza+= kartyaSzett[i];
		}
		return vissza;
	}
	
	private void reset(){								//visszaallit mindent alapertekre
		firstBet = 0;
		bjHandler=new BJCardHandler();
		
		//this.dealerKartyak[]=new String[5]("","","","","");
		//dealerPoints={0,0,0,0,0};
		
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				firstJatekosKartyak[i][j] = "";
				firstPoints[i][j]=0;
			}
		}
	}
	
}