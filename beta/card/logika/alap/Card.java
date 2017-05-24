package card.logika.alap;

/**
 *
 * @author Csaba
 */
public class Card {
    private int szin;
    private int tipus;
    
    public Card(int a, int b){
        this.szin = a;
        this.tipus = b;
    }
    
    public int getSzin(){
        return szin;
    }
    public int getTipus(){
        return tipus;
    }
    
    public String getFranciaSzin(){
        switch (szin) {
            case 1:
                return "Clover";
            case 2:
                return "Spades";
            case 3:
                return "Hearts";
            case 4:
                return "Diamonds";
            default:
                return "hiba";
        }
    }
    public String getFranciaTipus(){
        switch (tipus) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "hiba";
        }
    }

    public String getMagyarSzin(){
        switch (szin) {
            case 1:
                return "Piros";
            case 2:
                return "Tok";
            case 3:
                return "Zold";
            case 4:
                return "Makk";
            default:
                return "hiba";
        }
    }
    
    public String getMagyarTipus(){
        switch (tipus) {
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 11:
                return "Also";
            case 12:
                return "Felso";
            case 13:
                return "Kiraly";
            case 14:
                return "Asz";
            default:
                return "hiba";
        }
    }

}
