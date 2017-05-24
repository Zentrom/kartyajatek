package card.Logika.Alap;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Csaba
 */
public class Deck {
    private ArrayList<Card> pakli = new ArrayList();
    private boolean magyar;
    
    public Deck(boolean magyarKartya){          //hamis-francia  igaz-magyar
        if(magyarKartya){
            for(int i = 1; i <= 4; i++){
                for(int j = 7; j <= 14; j++){
                    pakli.add(new Card(i,j));
                }
            }
        } else{
            for(int i = 1; i <= 4; i++){
                for(int j = 1; j <= 13; j++){
                    pakli.add(new Card(i,j));
                }
            }
        }
        
        this.magyar = magyarKartya;
    }
    
    /**
     * Kiírja a pakli tartalmát.
     */
    public void printDeck(){
	System.err.println("Pakli kiírása");
        if(magyar){
            for (int i=0; i<pakli.size();i++){
                    System.out.println("Szin: " + pakli.get(i).getMagyarSzin()
                                        +"  Tipus: " + pakli.get(i).getMagyarTipus());
            }
        } else{
            for (int i=0; i<pakli.size();i++){
                    System.out.println("Szin: " + pakli.get(i).getFranciaSzin()
                                        +"  Tipus: " + pakli.get(i).getFranciaTipus());
            }
        }
    }
    
    public Card drawCard(){
        Card id = pakli.get(0);
        pakli.remove(0);
        return id;
    }
    
    public void kever(){			//paklikeverés egy arrayListbe
		Random random = new Random();
		ArrayList<Card> id = new ArrayList();
                int szam;
		while(pakli.size()!= 0){
                    szam = random.nextInt(pakli.size());
                    id.add(pakli.get(szam));
                    pakli.remove(szam);
		}
                pakli = id;
	}
    
    public int size(){
            return pakli.size();
    }
    
}
