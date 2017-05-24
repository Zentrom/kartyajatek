/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card.Megjelenites;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Csaba
 */
public class Game1 extends JFrame{
    
    public Game1(){
        initFrame();
        
        pack();
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private JButton pl = new JButton("Bruhhh");
    
    private void initFrame() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,1));
        add(pl);
    }

}
