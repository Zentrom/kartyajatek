package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.*;
import java.util.*;

public class KartyaJatek{
	
	public KartyaJatek()
    {
		int valasztas=-1;
		
        System.out.println( "\nKerem valasszon a menupontok kozul?\n" );
		
		try{
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			while(valasztas!=0&&valasztas!=1&&valasztas!=2&&valasztas!=3){       
				
					System.out.println( "1.Admiralis" );
					System.out.println( "2.Passziansz" );
                                        System.out.println( "3.Treff-nem" );
					System.out.println( "0.Kilepes" );
					
                                        try{
                                            valasztas = Integer.parseInt(stdin.readLine());
                                        } catch (NumberFormatException ex){
                                            System.out.println("Írjon be egy számot!!");
                                            valasztas = -1;
                                        }
				
			}
			stdin.close();
		}catch(IOException io){
			System.out.println("Nem jo erteket adott meg!");
		}
		switch (valasztas){
			case 1:
				Admiralis admiralis = new Admiralis();
				break;
			case 2:
				Passziansz passziansz = new Passziansz();
                                //passziánsz game metódusa, elindítja a játékot
                                passziansz.game();
				break;
                        case 3:
                            Treffnem treffnem = new Treffnem();
                            //treffnem game metódusa, elindítja a játékot
                            treffnem.game();
                            break;
			default:
				break;
		}
		
    }
	
}