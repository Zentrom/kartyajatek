/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.panel;

import edu.elte.ik.preszk.cardgame.Deck;
import edu.elte.ik.preszk.cardgame.controller.casualGames.ParkeresoController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.SIZE;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Lipcsei
 */
public class ParkeresoPanel extends JPanel {
	private JPanel lButton;
	private JButton[][] left;
	int size1 = 0;
	int size2 = 0;
	String choosed1;
	String choosed2;
	String selected = "";

	JButton button1;
	JButton button2;

	int eq = 0;

	ParkeresoController controller;

	HashMap<Integer, String> cards = new HashMap<>();

	public ParkeresoPanel(ParkeresoController controller) {
		this.controller = controller;
		controller.init();
		cards = controller.getKartyak();
		size1 = controller.getRows();
		size2 = controller.getCols();
		setLayout(new FlowLayout(FlowLayout.CENTER));

		lButton = new JPanel();
		lButton.setLayout(new GridLayout(size1, size2));
		left = new JButton[size1][size2];
		int num = 0;
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; ++j) {
				left[i][j] = new JButton("X");
				left[i][j].setName(cards.get(num));
				// System.out.println(left[i][j].getName());
				left[i][j].setMargin(new Insets(0, 0, 0, 0));
				left[i][j].setPreferredSize(new Dimension(80, 40));
				left[i][j].addActionListener(actionListener);
				lButton.add(left[i][j]);
				num++;
			}
		}
		JPanel gameTest = new JPanel();
		gameTest.setLayout(new BorderLayout());
		gameTest.add(lButton, BorderLayout.LINE_START);
		add(gameTest);
	}

	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			button1 = (JButton) e.getSource();
			if (button2 == null) {
				button2 = button1;
			}
			selected = button1.getName();
			button1.setText(selected);
			setButtons();
			checkWin();
		}
	};

	private void setButtons() {
		boolean isTwoActive = controller.isTwoActive();
		boolean isPair = controller.isNextChoicePair(selected);
		if(isTwoActive) {
			if (isPair && !button1.equals(button2)) {
				button2.setText(selected);
				button1.setText(selected);
				button1.setEnabled(false);
				button2.setEnabled(false);
				button1 = null;
				button2 = null;
				controller.addPoint();
			} else {
				button1.setText("X");
				button2.setText("X");
				button2 = null;
			}
		}
	}

	private void checkWin() {
		boolean didIWon = controller.didIWon();
		if (didIWon) {
			JOptionPane.showMessageDialog(this, "Nyertél");
			System.exit(0);
		}
	}

	public void run() {
		JFrame frame = new JFrame();
		frame.setTitle("Párkereső");
		frame.setAlwaysOnTop(true);
		frame.add(this);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

