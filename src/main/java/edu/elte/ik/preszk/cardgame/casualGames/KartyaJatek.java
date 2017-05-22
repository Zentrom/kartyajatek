package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Ez az osztály az egyszemélyes kártyajátékok elindításáért felel.
 * @author Preszk Team
 *
 */
public class KartyaJatek {

	private BufferedReader stdin;
	private Admiralis admiralis;
	private Passziansz passziansz;
	private Treffnem treffnem;
        private SzinreSzin szinreSzin;
        private Parkereso parkereso;

	/**
	 * 
	 * @param stdin {@link BufferedReader } mely a kommunikációért felel.
	 * @param admiralis {@link Admiralis} játék.
	 * @param passziansz {@link Passziansz} játék.
	 * @param treffnem {@link Treffnem} játék.
         * @param szinreSzin {@link szinreSzin} játék.
	 */
	public KartyaJatek(BufferedReader stdin, Admiralis admiralis, Passziansz passziansz, Treffnem treffnem, SzinreSzin szinreSzin, Parkereso parkereso) {
		this.stdin = stdin;
		this.admiralis = admiralis;
		this.passziansz = passziansz;
		this.treffnem = treffnem;
                this.szinreSzin = szinreSzin;
                this.parkereso = parkereso;

	}

	/**
	 * Elindítja az egyszemélyes kártyajátékok választó menüjét.
	 */
	public void start() {
		int valasztas = -1;

		System.out.println("\nKerem valasszon a menupontok kozul?\n");

		try {
			while (valasztas != 0 && valasztas != 1 && valasztas != 2 && valasztas != 3 && valasztas != 4 && valasztas != 5) {

				System.out.println("1.Admiralis");
				System.out.println("2.Passziansz");
				System.out.println("3.Treff-nem");
                                System.out.println("4.Szinre szín");
                                System.out.println("5.párkereső");
				System.out.println("0.Kilepes");

				try {
					valasztas = Integer.parseInt(this.stdin.readLine());
				} catch (NumberFormatException ex) {
					System.out.println("Írjon be egy számot!!");
					valasztas = -1;
				}

			}
			// nem szabad lezárni a streamet mert többet nem tudjuk a programban
			// használni
			// stdin.close();
		} catch (IOException io) {
			System.out.println("Nem jo erteket adott meg!");
		}
		switch (valasztas) {
		case 1:
			admiralis.game();
			break;
		case 2:
			// passziánsz game metódusa, elindítja a játékot
			passziansz.game();
			break;
		case 3:
			// treffnem game metódusa, elindítja a játékot
			treffnem.game();
			break;
                case 4:
                {
                    try {
                        // szinreSzin game metódusa, elindítja a játékot
                        szinreSzin.game();
                    } catch (IOException ex) {
                        System.err.println("Megnyitási hiba");
                    }
                }
			break;
                case 5:
                {
                    try {
                        parkereso.game();
                    } catch (IOException ex) {
                        System.err.println("Megnyitási hiba");
                    }
                }
                    break;
		default:
			break;
		}
	}

}