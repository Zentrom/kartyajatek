/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elte.ik.preszk.cardgame.panel;

import edu.elte.ik.preszk.cardgame.Deck;
import edu.elte.ik.preszk.cardgame.controller.casualGames.SzinreSzinController;

import java.io.BufferedReader;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lipcsei
 */
public class SzinPanel extends javax.swing.JFrame {

	SzinreSzinController controller;
    String choose = "";
   
    int choosed = 0;
    
    /**
     * Creates new form SzinPanel
     * @param controller {@link SzinreSzinController} a játék kontrollere
     */
    public SzinPanel(SzinreSzinController controller) {
    	this.controller = controller;
        controller.setDecks();
        initComponents();
        List<String> player1 = controller.getJatekosPakli();
        for(int i = 0; i<player1.size(); ++i){
            lapokBox.addItem(player1.get(i).toString());
        }
    }
    
    
    
   
    
    
    /**
     * Elindítja a SzinreSzin játék UI megoldását
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        felsoLap = new javax.swing.JTextField();
        lapokBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        eredmenyField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        elozolapText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Színre szín");
        setAlwaysOnTop(true);

        jLabel1.setText("Felső lap");

        felsoLap.setEditable(false);

        lapokBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapokBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Kártyáid");

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        eredmenyField.setEditable(false);
        eredmenyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        eredmenyField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        eredmenyField.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        eredmenyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eredmenyFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Előző rakott lapod");

        elozolapText.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(lapokBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eredmenyField)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(felsoLap, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(elozolapText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eredmenyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(felsoLap, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lapokBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(elozolapText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * OK gomb megnyomásának működéséért felelős metódus
     * @param evt
     */
    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
    	felsoLap.setText(controller.getUtolsoLap());
        boolean correct = controller.isCorrect(lapokBox.getItemAt(choosed));
        
        if(correct){
        	System.out.println(lapokBox.getItemAt(choosed));
        	felsoLap.setText(lapokBox.getItemAt(choosed));
            elozolapText.setText(lapokBox.getItemAt(choosed));
            lapokBox.removeItemAt(choosed);
            //gép
            boolean gepTudERakni = controller.gepTudERakni();
            if(gepTudERakni) {
            	String gepLapja = controller.getGepLapja();
            	felsoLap.setText(gepLapja);
            } else {
            	eredmenyField.setText("A gépi játékos nem tud rakni! Nyertél!");
            	lapokBox.removeAllItems();
            }
            
        } else {
        	eredmenyField.setText("Ezt a lapot nem tudod letenni!");
        }
    }//GEN-LAST:event_okBtnActionPerformed

    private void lapokBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapokBoxActionPerformed
        choosed = lapokBox.getSelectedIndex();
    }//GEN-LAST:event_lapokBoxActionPerformed

    private void eredmenyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eredmenyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eredmenyFieldActionPerformed

    /**
     * Elindítja a Színre szín játékot
     * @param args console argumentumok 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SzinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzinPanel(new SzinreSzinController(new Deck(true), new Random())).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField elozolapText;
    private javax.swing.JTextField eredmenyField;
    private javax.swing.JTextField felsoLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> lapokBox;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
