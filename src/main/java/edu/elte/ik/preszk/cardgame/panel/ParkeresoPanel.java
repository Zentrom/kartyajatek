/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.panel;

import edu.elte.ik.preszk.cardgame.Deck;
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
public class ParkeresoPanel extends JPanel{
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
    boolean park;
    
    HashMap<Integer, String> cards = new HashMap<>();
    
    public ParkeresoPanel(boolean fajta){
        park = fajta;
        Deck pakli = new Deck(fajta);
        Deck pakli2 = new Deck(fajta);
        
        if(fajta){
            size1 = 8;
            size2 = 8;
        }
        else{
            size1 = 8;
            size2 = 13;
        } 
        
        for(int i = 0; i<pakli.size(); ++i){
            cards.put(i,pakli.getSortedCard(i));
        }
        for(int i = 0; i<pakli.size(); ++i){
            cards.put(i+pakli.size(),pakli2.getSortedCard(i));
        }
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lButton = new JPanel();
        lButton.setLayout(new GridLayout(size1,size2));
        left = new JButton[size1][size2];
        int num = 0;
        for(int i=0; i<size1;i++){ 
            for(int j = 0; j<size2; ++j){
                left[i][j] = new JButton("X");
                left[i][j].setName(cards.get(num));
                //System.out.println(left[i][j].getName());
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
            if(button2 == null){
                button2 = button1;
            }
            selected = button1.getName();
            button1.setText(selected);
            doPair();
        }
    };
    
    private void doPair() {
        if (choosed1 == null && choosed2 == null){
            choosed1 = selected;
        }else if (choosed1 != null && choosed2 == null){
            choosed2 = selected;
            check();
        }
    }
    
    private void check(){
        
        if(choosed1.equals(choosed2)){
            button2.setText(choosed2);
            button1.setText(choosed1);
            button1.setEnabled(false);
            button2.setEnabled(false);
            eq++;
            button1 = null;
            button2 = null;
            choosed1 = null;
            choosed2 = null;
            if(eq == cards.size()/2){
                JOptionPane.showMessageDialog(this, "Nyertél");
                System.exit(0);
            }
        }else{
            button1.setText("X");
            button2.setText("X");
            button2 = null;
            choosed1 = null;
            choosed2 = null;
        }
        
    }
    
    public void run() {
        JFrame frame = new JFrame();
        ParkeresoPanel td = new ParkeresoPanel(park);
        frame.setTitle("Párkereső");
        frame.setAlwaysOnTop(true);
        frame.add(td);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
}

    
    
}
