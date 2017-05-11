package edu.elte.ik.preszk.cardgame.gamblingGames;

import java.io.*;
import java.util.*;

public class SzerencseJatek{
	
	private String username;
	private String password;
	private int vagyon;
	private final String dataFile="data";
	
	private BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public SzerencseJatek() throws IOException{
		printMenu();
	}

	private void printMenu() throws IOException {				//kiirja a menut
		System.out.println("Kerem jelentkezzen be!");
		System.out.println("(Ha meg nincs fiokja regisztraljon)");
		
		int valasztas= -1;
		String str = "";
		
		//try{
			while(valasztas!=0&&valasztas!=1&&valasztas!=2){
				
				System.out.println("1.Bejelentkezes");
				System.out.println("2.Regisztracio");
				System.out.println("0.Kilepes");
				
                                //int ellenőrzés
				try{
                                    valasztas = Integer.parseInt(stdin.readLine());
                                } catch (NumberFormatException ex){
                                    System.out.println("Írjon be egy számot!!");
                                    valasztas = -1;
                                }
				
			}
		//}catch(IOException io){
		//	System.out.println("Nem jo erteket adott meg!" + io.getMessage());
		//}
		switch (valasztas){
			case 1:
				Belepes();
				break;
			case 2:
				Regisztracio();
				break;
			default:
				stdin.close();
				break;
		}
	}
	
	private void Belepes() throws IOException{				//belepest kezeli
		System.out.println("Kerem adja meg a felhasznalonevet!");
		this.username=stdin.readLine();
		
		String tmpPw = "";
		String tmpIn[];
		Boolean sikeresBelepes = false;
		try{
			Scanner readFile = new Scanner(new File(dataFile));
			while(readFile.hasNext()){
				if(username.equals(readFile.next())){
					tmpPw=readFile.next();
					for(int i=0;i<3;i++){
						System.out.println("Kerem adja meg a jelszavat!");
						tmpIn = stdin.readLine().split(" ");
						if(tmpPw.equals(tmpIn[0])){
							sikeresBelepes = true;
							this.password=tmpPw;
							this.vagyon=Integer.parseInt(readFile.next());
							break;
						}
					}
				}
			}
			readFile.close();
		}catch(FileNotFoundException Fn){
			System.out.println("Nincs data fajl!");
		}
		
		if(sikeresBelepes){
			SikeresBelepes();
			
		}else{
			System.out.println("Nem sikerult belepni!");
			printMenu();
		}
		
	}
	
	private void SikeresBelepes() throws IOException{ 			//menu mikor sikeres volt a bejelentkezes
	
		System.out.println("Sikerult a belepes,udvozoljuk!");
		System.out.println("A jelenlegi egyenlege: "+vagyon+" dollar\n");
		
		int valasztas=-1;
		
		while(valasztas!=0&&valasztas!=1&&valasztas!=2&&valasztas!=3){
			try{
				System.out.println("1.BlackJack");
				System.out.println("2.Poker");
				System.out.println("3.Nincs penzem");
				System.out.println("0.Kilepes");
				
				try{
                                    valasztas = Integer.parseInt(stdin.readLine());
                                } catch (NumberFormatException ex){
                                    System.out.println("Írjon be egy számot!!");
                                    valasztas = -1;
                                }
				
			}catch(NoSuchElementException No){
				System.out.println("Nem jo erteket adott meg!");
			}
		};
		switch (valasztas){
			case 1:
				BlackJackClient blackjack = new BlackJackClient(username,vagyon);   //az elso kliens ha nem tud csatlakozni a serverre
				this.vagyon= blackjack.play();										//akk elkéne inditsa BlackJackServer-t külön consoleba.
				updateStoredCredits();	
				SikeresBelepes();				
				break;														
			case 2:
				PokerClient poker = new PokerClient(username,vagyon);
				this.vagyon = poker.play();
				updateStoredCredits();
				SikeresBelepes();
				break;
			case 3:
				RestoreCredits();
				updateStoredCredits();
				SikeresBelepes();
				break;
			default:
				stdin.close();
				break;
		}
		
		//System.out.println("Koszonjuk hogy ittvolt! Vegso vagyona: " + this.vagyon);
	}
	
	private void Regisztracio() throws IOException{			//reget kezeli
		
		System.out.println("Kerem adjon meg egy felhasznalonevet!");
		this.username=stdin.readLine();
		
		Boolean vanMarIlyen = false;
		try{
			Scanner readFile = new Scanner(new File(dataFile));
			while(readFile.hasNext()){
				if(username.equals(readFile.next())){
					vanMarIlyen = true;
					break;
				}
			}
			readFile.close();
		}catch(FileNotFoundException Fn){
			System.out.println("Nincs data fajl!");
		}
		
		if(vanMarIlyen){
			System.out.println("Mar letezik ilyen felhasznalonev!");
			printMenu();
		}else{
			System.out.println("Kerem adjon meg egy jelszot!");
			this.password=stdin.readLine();
			
			try{
				PrintWriter updateData = new PrintWriter(new FileOutputStream(new File(dataFile),true /*append*/));
				updateData.print(username+"\t");
				updateData.println(password + "\t1000");
				updateData.close();
			}catch(FileNotFoundException Fn){
				System.out.println("Nincs data fajl!");
			}
			
			System.out.println("A regisztracio sikeres volt!");
			printMenu();
		}
	}
	
	private void RestoreCredits() throws IOException{			//visszaallitja az egyenleget az alapertekre
		if(this.vagyon==0){
			this.vagyon=1000;
			System.out.println("A keresztapa adott kolcson 1000 dollart amit nem ker vissza!");
		}else{
			System.out.println("Hazugsag!Meg van!");
		}
	}
	
	private void updateStoredCredits() throws IOException{
		File inputFile = new File("data");
		File tempFile = new File("myTempdata");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToSearch = this.username;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
			String tmp[] = currentLine.split("\t");
			if(tmp[0].equals(lineToSearch)){
				writer.write(this.username +"\t"+ this.password +"\t"+ this.vagyon + System.getProperty("line.separator"));
			}else{
				writer.write(currentLine + System.getProperty("line.separator"));
			}
		}
		writer.close(); 
		reader.close();
		inputFile.delete();
		//boolean successful = 
		tempFile.renameTo(inputFile);
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public int getVagyon(){
		return this.vagyon;
	}
	
	public void setVagyon(int vagyon){
		this.vagyon=vagyon;
	}
	
}









