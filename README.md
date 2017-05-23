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
    * SzinreSzin.java 
    -Színre-szín játék implementáció.
    * Parkereso.java 
    -Párkereső kártya-játék implementáció.
  * SzerencseJatek.java
  -Szerencsejátékos kártyajátékok menüje. 
  -Be kell lépni/regisztrálni(adatok "data" fileba).
    * BlackJackClient.java
    -BlackJack kliens implementációja.
    * BlackJackServer.java
    -BlackJack szerver implementáció.
    * BJCardHandler.java
    -Segédosztály mely lekezeli a kártyákat a BlackJack pontszámainak megfelelően.
    * Poker.java
    -Póker implementációja.
* Deck.java 
-Paklit létrehoz&visszaad egy Map<szin,Map<szam,érték>>-ben.
-Paraméter hamis:francia/igaz:magyar
-Pakli elemeinek kiiratása
-Pakli egy lapjának kiírása