package edu.elte.ik.preszk.cardgame.controller.casualGames;

import java.util.HashMap;

import edu.elte.ik.preszk.cardgame.Deck;

/**
 * A párkereső játék funkcionalitásáért felel.
 * 
 * @author Preszk Team
 *
 */
public class ParkeresoController {

	private int size1 = 0;
	private int size2 = 0;
	private Deck pakli1;
	private Deck pakli2;
	private String choosed1;
	private String choosed2;
	private int points = 0;
	private HashMap<Integer, String> cards = new HashMap<>();

	/**
	 * A párkereső kontroller konstruktora.
	 * 
	 * @param pakli1
	 *            {@link Deck} az első pakli
	 * @param pakli2
	 *            {@link Deck} a második pakli
	 */
	public ParkeresoController(Deck pakli1, Deck pakli2) {
		this.pakli1 = pakli1;
		this.pakli2 = pakli2;

	}

	/**
	 * Bekeveri a paklikat.
	 */
	public void init() {
		if (pakli1.size() == 32) {
			size1 = 8;
			size2 = 8;
		} else {
			size1 = 8;
			size2 = 13;
		}

		for (int i = 0; i < pakli1.size(); ++i) {
			cards.put(i, pakli1.getSortedCard(i));
		}
		for (int i = 0; i < pakli2.size(); ++i) {
			cards.put(i + pakli1.size(), pakli2.getSortedCard(i));
		}
	}

	/**
	 * Visszaadja a két összekevert paklit.
	 * @return a kártyákat adja vissza.
	 */
	public HashMap<Integer, String> getKartyak() {
		return cards;
	}

	/**
	 * Hány sorra van szükségünk a megjelenítéshez.
	 * @return sorok száma
	 */
	public int getRows() {
		return size1;
	}

	/**
	 * Hány oszlopra van szükségünk a megjelenítéshez.
	 * @return az oszlopok száma
	 */
	public int getCols() {
		return size2;
	}

	/**
	 * Megmondja hogy a következő választás pár-2
	 * @param selected a választás
	 * @return pár-e vagy nem
	 */
	public boolean isNextChoicePair(String selected) {
		boolean isPair = false;
		if (choosed1 == null) {
			choosed1 = selected;
		} else {
			choosed2 = selected;
			if (choosed1.equals(choosed2)) {
				isPair = true;
				choosed1 = null;
				choosed2 = null;

			} else {
				choosed1 = null;
				choosed2 = null;
			}
		}
		return isPair;
	}

	/**
	 * Nyertem e
	 * @return igazzal tér vissza ha minden párt megtaláltunk
	 */
	public boolean didIWon() {
		return points == cards.size() / 2;
	}

	/**
	 * Visszaadja, hogy két kártyát fordítottunk-e fel.
	 * @return igaz ha már a második kártyát fordítjuk fel egyébként hamis.
	 */
	public boolean isTwoActive() {

		return choosed1 != null;
	}

	/**
	 * Ad egy pontot.
	 */
	public void addPoint() {
		points++;

	}

}
