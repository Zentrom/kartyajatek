package edu.elte.ik.preszk.cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.elte.ik.preszk.cardgame.casualGames.Admiralis;
import edu.elte.ik.preszk.cardgame.casualGames.KartyaJatek;
import edu.elte.ik.preszk.cardgame.casualGames.Passziansz;
import edu.elte.ik.preszk.cardgame.casualGames.SzinreSzin;
import edu.elte.ik.preszk.cardgame.casualGames.Treffnem;
import edu.elte.ik.preszk.cardgame.casualGames.Parkereso;
import edu.elte.ik.preszk.cardgame.gamblingGames.SzerencseJatek;
 /**
  * Ez az osztály a Játék elindításáért felel. 
  * @author Preszk Team
  *
  */
public class App 
{
	
	/**
	 * Felhozza a főmenüt.
	 * @param args console argumentumok.
	 * @throws IOException beolvasási hiba esetén.
	 */
    public static void main( String[] args ) throws IOException
    {
		int valasztas=-1;
        
        System.out.println( "\nKerem valasszon a menupontok kozul?\n" );
		
		//try{
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			while(valasztas!=0&&valasztas!=1&&valasztas!=2){       //eleg gagyi
				
					System.out.println( "1.Szerencse-kartyajatekok" );
					System.out.println( "2.Sima kartyajatekok" );
					System.out.println( "0.Kilepes" );
					
					try{
                                            valasztas = Integer.parseInt(stdin.readLine());
                                        } catch (NumberFormatException ex){
                                            System.out.println("Írjon be egy számot!!");
                                            valasztas = -1;
                                        }
				
			}
			//stdin.close();
		//}catch(IOException io){
		//	System.out.println("Nem jo erteket adott meg!");
		//}
		switch (valasztas){
			case 1:
				SzerencseJatek szerencseJ = new SzerencseJatek();
				break;
			case 2:
				BufferedReader stdinkartya = new BufferedReader(new InputStreamReader(System.in));
				Admiralis admiralis = new Admiralis();
				Passziansz passziansz = new Passziansz();
				Treffnem treffNem = new Treffnem(stdinkartya);
                                SzinreSzin szinreSzin = new SzinreSzin(stdinkartya);
                                Parkereso parkereso = new Parkereso(stdinkartya);
				KartyaJatek kartyaJ = new KartyaJatek(stdinkartya,admiralis,passziansz,treffNem,szinreSzin);
				kartyaJ.start();
				break;
			default:
				break;
		}
		
    }
}