package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.elte.ik.preszk.cardgame.Deck;

/**
 * A színre szín játék funkcionalitásáért felel.
 * @author Preszk Team
 *
 */
public class SzinreSzinController {

	private Deck pakli;
	private String lastCard = "";
	private String gepLapja = "";
	private Random random;
	// a játékos
	private List<String> player1 = new ArrayList<>();
	// számítógép
	private List<String> player2 = new ArrayList<>();

	/**
	 * A színre szín kontrollerének konstruktora.
	 * @param pakli {@link Deck} a pakli.
	 * @param random {@link Random} random generátor
	 */
	public SzinreSzinController(Deck pakli, Random random) {
		this.pakli = pakli;
		this.random = random;
	}

	/**
	 * Bekeveri a paklit és szétosztja
	 */
	public void setDecks() {
		for (int i = 0; i < 16; ++i) {
			player1.add(pakli.getSortedCard(i));
		}
		for (int i = 16; i < 32; ++i) {
			player2.add(pakli.getSortedCard(i));
		}
	}

	/**
	 * Visszaadja a játékos pakliját.
	 * @return a játékos paklija
	 */
	public List<String> getJatekosPakli() {
		return player1;
	}

	/**
	 * Megnézi, hogy helyes lépés-e
	 * @param choosed a választott kártyánk
	 * @return igaz, ha letehetjük a kártyát különben hamis.
	 */
	public boolean isCorrect(String choosed) {
		boolean correct = false;
		if (lastCard.isEmpty()) {
			correct = true;
		} else {
			String playerstr[] = choosed.split(" ");
			String laststr[] = lastCard.split(" ");
			if (playerstr[0].equals(laststr[0]) || playerstr[1].equals(laststr[1])) {
				correct = true;
			}
		}
		if (correct) {
			player1.remove(choosed);
			lastCard = choosed;
		}
		return correct;
	}

	/**
	 * Tud-e rakni a gép kártyát.
	 * @return igaz ha tud rakni különben hamis.
	 */
	public boolean gepTudERakni() {
		boolean isCorrect = false;
		List<String> lehetosegek = getLehetosegek();
		;
		getLehetosegek();

		if (!lehetosegek.isEmpty()) {
			int num = random.nextInt(lehetosegek.size() - 1);
			lastCard = lehetosegek.get(num).toString();
			gepLapja = lehetosegek.get(num).toString();
			player2.remove(lehetosegek.get(num));
			isCorrect = true;
		}

		return isCorrect;
	}

	private List<String> getLehetosegek() {
		List<String> lehetosegek = new ArrayList<>();
		String laststr[] = lastCard.split(" ");
		for (String kartya : player2) {
			String playerstr[] = kartya.split(" ");
			if (playerstr[0].equals(laststr[0]) || playerstr[1].equals(laststr[1])) {
				lehetosegek.add(kartya);
			}
		}
		return lehetosegek;
	}

	/**
	 * Visszatér a gép lapjával
	 * @return a gép utolsó lapja
	 */
	public String getGepLapja() {
		return gepLapja;
	}

	/**
	 * Utoljára kijátszott lap.
	 * @return az utoljára kijátszott lap
	 */
	public String getUtolsoLap() {
		return lastCard;
	}
}
