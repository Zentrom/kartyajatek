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
  * SzerencseJatek.java
  -Szerencsejátékos kártyajátékok menüje. 
  -Be kell lépni/regisztrálni(adatok "data" fileba).
    * BlackJackClient.java
    -BlackJack kliens implementációja.
    * BlackJackServer.java
    -BlackJack szerver implementáció.
    * Poker.java
    -Póker implementációja.
* Deck.java 
-Paklit létrehoz&visszaad egy Map<szin,Map<szam,érték>>-ben.(nembiztos hogy jó még)
-Paraméter hamis:francia/igaz:magyar
-Pakli elemeinek kiiratása
-Pakli egy lapjának kiírása
