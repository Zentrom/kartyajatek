package edu.elte.ik.preszk.cardgame;

import java.util.*;
import java.io.*;

/**
 * Ez az osztály a pakli és az ahhoz tartozó lapok kezelését valósítja meg.
 * @author Peter Kovacs AKD7MZ
 *
 */
public class Deck {
	
	private Map <Integer,String> belsoMap = new TreeMap<Integer,String>();
    private HashMap <String,Map<Integer,String>> pakli = new HashMap<String,Map<Integer,String>>();
	private List<String> sortedDeck = new ArrayList<String>();       //megkevert pakli
	
	
	/**
	 * Az osztály konstruktora amely létrehozza a paklit.
	 * @param magyarKartya ha igaz magyar kártya paklit, ha hamis francia kártya paklit hoz létre.
	 */
	public Deck(boolean magyarKartya){          //hamis-francia  igaz-magyar
		if(magyarKartya){
			belsoMap.put(7,"VII");
			belsoMap.put(8,"VIII");
			belsoMap.put(9,"XI");
			belsoMap.put(10,"X");
			belsoMap.put(2,"Also");
			belsoMap.put(3,"Felso");
			belsoMap.put(4,"Kiraly");
			belsoMap.put(11,"Asz");
			
			pakli.put("Piros",belsoMap);
			pakli.put("Tok",belsoMap);
			pakli.put("Zold",belsoMap);
			pakli.put("Makk",belsoMap);
			
			SortMagyar();
		}else{
			belsoMap.put(2,"2");
			belsoMap.put(3,"3");
			belsoMap.put(4,"4");
			belsoMap.put(5,"5");
			belsoMap.put(6,"6");
			belsoMap.put(7,"7");
			belsoMap.put(8,"8");
			belsoMap.put(9,"9");
			belsoMap.put(10,"10");
			belsoMap.put(20,"J");
			belsoMap.put(30,"K");
			belsoMap.put(40,"Q");
			belsoMap.put(11,"A");
			
			pakli.put("Clover",belsoMap);
			pakli.put("Spades",belsoMap);
			pakli.put("Hearts",belsoMap);
			pakli.put("Diamonds",belsoMap);
			
			SortDeck();
		}
	}
	
	
	/**
	 * Ez a metódus visszaadja a paklit.
	 * @return egy HashMap-ben adja vissza a pakli tartalmát
	 */
	public HashMap<String,Map<Integer,String>> getPakli(){
		return this.pakli;
	}
        
	/**
	 * Kiírja a pakli tartalmát.
	 */
	public void printDeck(){
		System.err.println("Pakli kiírása");
		
		for (String name: pakli.keySet()){
			String key = name.toString();
			for(Integer num : belsoMap.keySet()){
				String value = pakli.get(name).toString();
				String num_value = belsoMap.get(num).toString();
				System.out.println(key + " " + num_value);
			}
		} 
	}
	
	/**
	 * Visszaadja a pakli egy lapját.
	 * @param szin a kártya színe.
	 * @param szam a kártya száma.
	 * @return ha tartalmazza a pakli a lekérdezett kártyát szin + " " + szam formatumban tér vissza, ha nincs benne akkor "hibas laplekerdezes! hibaüzenettel.
	 */
	public String getLap(String szin, int szam){
		for (String name: pakli.keySet()){
			if(name.equals(szin)){
				name = name.toString();
				for(Integer num : belsoMap.keySet()){
					if(num == szam){
						String num_value = belsoMap.get(num).toString();
						return (name + " " + num_value);
					}
				}
			}

		}
		return ("hibas laplekerdezes!");
	}
	/**
	 * Bekeveri a paklit egy ArrayListbe.	
	 */
	private void SortDeck(){			//paklikeverés egy arrayListbe
		int hanyKartya = 52;
		Random random = new Random();
		String szintomb[] = {"Clover" , "Spades" , "Hearts" , "Diamonds"};
		int szamtomb[] = {2,3,4,5,6,7,8,9,10,11,20,30,40};
		Boolean beteheto = true;
		
		String szin;
		int szam;
		String betenniValo;
		
		while(hanyKartya>0){
			beteheto = true;
			szin = szintomb[random.nextInt(4)];
			szam = szamtomb[random.nextInt(13)];
			betenniValo=getLap(szin, szam);
			for(String lap : sortedDeck){
				if(lap.equals(betenniValo)) beteheto = false;
			}
			
			if(beteheto){
				sortedDeck.add(betenniValo);
				hanyKartya--;
			}
		}
	}
	
	/**
	 * paklikeverés magyar kártyák esetén
	 */
	private void SortMagyar(){			
		int hanyKartya = 32;
		Random random = new Random();
		String szintomb[] = {"Piros" , "Tok" , "Zold" , "Makk"};
		int szamtomb[] = {7,8,9,10,2,3,4,11};
		Boolean beteheto = true;
		
		String szin;
		int szam;
		String betenniValo;
		
		while(hanyKartya>0){
			beteheto = true;
			szin = szintomb[random.nextInt(4)];
			szam = szamtomb[random.nextInt(8)];
			betenniValo=getLap(szin, szam);
			for(String lap : sortedDeck){
				if(lap.equals(betenniValo)) beteheto = false;
			}
			
			if(beteheto){
				sortedDeck.add(betenniValo);
				hanyKartya--;
			}
		}
	}
	
	
	/**
	 * Vissza adja, a sorbarendezett pakli x. elemét.
	 * @param hanyadik kártyát kéri a sorbarendezett pakliból.
	 * @return a sorbarendezett kártyával, hiba esetén hibas kartyalekerdezes! hibaüzenet.
	 */
	public String getSortedCard(int hanyadik){
		String value;
		try{
			value=sortedDeck.get(hanyadik);
		}catch(IndexOutOfBoundsException ib){
			value="hibas kartyalekerdezes!";
		}
		return value;
	}
	
}