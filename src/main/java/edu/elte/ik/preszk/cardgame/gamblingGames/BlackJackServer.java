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
	
	public static void main (String args[]) throws IOException{
		//BlackJackServer bjServer= new BlackJackServer();
		
		
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
	int kor = 0;
	
	String dealerKartyak[]= new String[5];
	int dealerPoints[]= new int[5];
	
	String firstJatekos;
	String firstJatekosKartyak[][]= new String[4][5];
	int firstBet;
	int firstSzal = 0;
	int firstPoints[][]= new int[4][5];
	int firstJatekosState = -1;
	
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
		
		reset();
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
				while(jatekVege!=true && kor<2){
					
					currentCard=bjHandler.getNextCardName();
					//int firstPoints[0][0]=bjHandler.getCardValue(currentCard);
					if(bjHandler.getCardValue(currentCard)==11){
						firstSzal++;
						firstPoints[firstSzal][kor] = 1;
						firstJatekosKartyak[firstSzal][kor] = currentCard;
					}
					firstPoints[0][kor] = bjHandler.getCardValue(currentCard);
					firstJatekosKartyak[0][kor]=currentCard;
					fpw.println(firstJatekos + " kartyat kapott: " + firstJatekosKartyak[0][kor]);
					System.out.println(firstJatekos + " kartyat kapott: " + firstJatekosKartyak[0][kor]);
					
					currentCard=bjHandler.getNextCardName();
					dealerPoints[kor] = (kor==1?-1:bjHandler.getCardValue(currentCard));
					dealerKartyak[kor] = currentCard;
					fpw.println("A dealer kartyat kapott: " + (kor!=1?dealerKartyak[kor]:"fejjel lefele van."));
					System.out.println("A dealer kartyat kapott: " + (kor!=1?dealerKartyak[kor]:"fejjel lefele van."));
					
					kor++;
					
				}
				firstJatekosState=jatekHandler();
				while(firstJatekosState==0){
					fpw.println("Mit szeretne tenni?\n4.Kerek meg egy lapot!\n5.Megallok!");
					int firstJatekosState = Integer.parseInt(fsc.nextLine());
					
					if(firstJatekosState==4){												//4-es state a lapkeres
						currentCard=bjHandler.getNextCardName();
						firstPoints[0][kor] = bjHandler.getCardValue(currentCard);
						firstJatekosKartyak[0][kor]=currentCard;
						fpw.println(firstJatekos + " kartyat kapott: " + firstJatekosKartyak[0][kor]);
						System.out.println(firstJatekos + " kartyat kapott: " + firstJatekosKartyak[0][kor]);
						jatekHandler();
					}else{																		//5-os state a megallas
						if(kor==2){
							dealerPoints[kor-1] = bjHandler.getCardValue(currentCard);
							fpw.println("A dealer felfedte a lapot: " + dealerKartyak[kor]);
							System.out.println("A dealer felfedte a lapot: " + dealerKartyak[kor]);
						}else{
							currentCard=bjHandler.getNextCardName();
							dealerPoints[kor] = bjHandler.getCardValue(currentCard);
							dealerKartyak[kor] = currentCard;
							fpw.println("A dealer kartyat kapott: " + dealerKartyak[kor]);
							System.out.println("A dealer kartyat kapott: " + dealerKartyak[kor]);
						}
						jatekHandler();
					}
				}
				
				if(firstJatekosState==1)fpw.println("STATE WIN");
				else if(firstJatekosState==2)fpw.println("STATE PUSH");
				else if(firstJatekosState==3)fpw.println("STATE LOSE");
				
				//System.out.println("Vege a jateknak! Lesz folytatas?");
				//pw.println("Szeretne folytatni?igen/nem");
			}
			
			fsc.close();
			fpw.close();
			firstClient.close();

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
	
	private int jatekHandler(){                           //jatekos-állapotot módosít 1-re ha nyert 2,ha döntetlen,3 ha vesztett
		//int osszeg=0;
		//int vissza=0;
		Boolean kiesettE=true;
		for(int i=0;i<=firstSzal;i++){
			if(osszesit(firstPoints[i])<22){
				kiesettE = false;
				if(osszesit(firstPoints[i])==21){
					return 1;
				}
			}
		}
		if(kiesettE) return 3;
		if(osszesit(dealerPoints)>21){
			return 1;
		}else if(osszesit(dealerPoints)>17){
			//if(nev.equals(firstJatekos)){
				for(int i=0;i<=firstSzal;i++){
					if(osszesit(firstPoints[i])>osszesit(dealerPoints)){
						return 1;
					}
				}
				for(int i=0;i<=firstSzal;i++){
					if(osszesit(firstPoints[i])==osszesit(dealerPoints)){
						return 2;
					}
				}
						return 3;
			//}
		}
		return 0;
		
	}
	
	private void reset(){								//visszaallit mindent alapertekre
		kor = 0;
		firstBet = 0;
		firstSzal = 0;
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