package edu.elte.ik.preszk.cardgame;

import java.util.*;
import java.io.*;


public class Deck {
	
	private Map <Integer,String> belsoMap = new TreeMap<Integer,String>();
    private HashMap <String,Map<Integer,String>> pakli = new HashMap<String,Map<Integer,String>>();
	
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
}