package edu.elte.ik.preszk.cardgame;

import java.util.*;
import java.io.*;


public class Deck {
	
	private Map <Integer,String> belsoMap = new TreeMap<Integer,String>();
    private HashMap <String,Map<Integer,String>> pakli = new HashMap<String,Map<Integer,String>>();
	private List<String> sortedDeck = new ArrayList<String>();       //megkevert pakli
	
	
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
	
	public HashMap<String,Map<Integer,String>> getPakli(){
		return this.pakli;
	}
        
	//a pakli kiiratása
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
	
	//megadott lap lekérése a pakliból
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
	
	private void SortMagyar(){			//paklikeverés magyar kártyák esetén
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