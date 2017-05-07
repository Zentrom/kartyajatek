package edu.elte.ik.preszk.cardgame;

/**
 * Hello world!
 *
 */
import java.util.*;

 
public class App 
{
    public static void main( String[] args )
    {
		int valasztas=-1;
		
        System.out.println( "\nKerem valasszon a menupontok kozul?\n" );
		
		while(valasztas!=0&&valasztas!=1&&valasztas!=2){       //eleg gagyi
			try{
				System.out.println( "1.Szerencse-kartyajatekok" );
				System.out.println( "2.Sima kartyajatekok" );
				System.out.println( "0.Kilepes" );
				
				Scanner stdin = new Scanner(System.in);
				valasztas = stdin.nextInt();
				stdin.close();
			}catch(NoSuchElementException No){
				System.out.println("Nem jo erteket adott meg!");
			}
		}
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
