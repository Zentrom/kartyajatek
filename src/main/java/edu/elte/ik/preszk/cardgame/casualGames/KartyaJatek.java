package edu.elte.ik.preszk.cardgame.casualGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KartyaJatek {

	private BufferedReader stdin;
	private Admiralis admiralis;
	private Passziansz passziansz;
	private Treffnem treffnem;

	public KartyaJatek(BufferedReader stdin, Admiralis admiralis, Passziansz passziansz, Treffnem treffnem) {
		this.stdin = stdin;
		this.admiralis = admiralis;
		this.passziansz = passziansz;
		this.treffnem = treffnem;

	}

	public void start() {
		int valasztas = -1;

		System.out.println("\nKerem valasszon a menupontok kozul?\n");

		try {
			while (valasztas != 0 && valasztas != 1 && valasztas != 2 && valasztas != 3) {

				System.out.println("1.Admiralis");
				System.out.println("2.Passziansz");
				System.out.println("3.Treff-nem");
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
		default:
			break;
		}
	}

}