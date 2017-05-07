package edu.elte.ik.preszk.cardgame;

/**
 * Hello world!
 *
 */
import java.util.*;
import java.io.*;

import edu.elte.ik.preszk.cardgame.gamblingGames.*;
import edu.elte.ik.preszk.cardgame.casualGames.*;
 
public class App 
{
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
					
					valasztas = Integer.parseInt(stdin.readLine());
				
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
				KartyaJatek kartyaJ = new KartyaJatek();
				break;
			default:
				break;
		}
		
    }
}
