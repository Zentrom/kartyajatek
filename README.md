# kartyajatek
[PrEszk] Kártyajáték projekt

* App.java 
-Menü főrésze.
  * KartyaJatek.java 
  -Sima kartyajatek menü része.
    * Admiralis.java 
    -Admiralis kártyajáték implementáció.
    * Passziánsz.java 
    -Passziánsz játék implementáció.
    * Treffnem.java 
    -Treff-nem játék implementáció.
      * TreffPanel.java 
    -Grafikus interfész a játékhoz.
    * SzinreSzin.java 
    -Színre-szín játék implementáció.
      * SzinPanel.java 
    -Grafikus interfész a játékhoz.
    * Parkereso.java 
    -Párkereső kártya-játék implementáció.
      * ParkeresoPanel.java 
    -Grafikus interfész a játékhoz.
  * SzerencseJatek.java
  -Szerencsejátékos kártyajátékok menüje. 
  -Be kell lépni/regisztrálni(adatok "data" fileba).
    * BlackJackClient.java
    -BlackJack kliens implementációja.
    * BlackJackServer.java
    -BlackJack szerver implementáció.
      * BJCardHandler.java
    -Segédosztály mely lekezeli a kártyákat a BlackJack pontszámainak megfelelően.
    * PokerServer.java
    -Póker szerver implementációja.
    * PokerClient.java
    -Póker kliens implementációja.
* Deck.java 
-Paklit létrehoz&visszaad egy Map<szin,Map<szam,érték>>-ben.
-Paraméter hamis:francia/igaz:magyar
-Pakli elemeinek kiiratása
-Pakli egy lapjának kiírása