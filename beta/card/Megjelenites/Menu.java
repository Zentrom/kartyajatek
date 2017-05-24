package card.Megjelenites;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Csaba
 */
public class Menu extends JFrame{
    
    public Menu() {
        initFrame();
        
        pack();
        setSize(200, 400);
        setLocationRelativeTo(null);
    }
    
    private JButton g1 = new JButton("Game1");
    private ActionListener a1;
    private JButton g2 = new JButton("Game2");
    private JButton g3 = new JButton("Game3");

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,1));
        
        a1 = e -> SwingUtilities.invokeLater(() -> {
            System.out.println("mehh");
            new Game1().setVisible(true);
        });

        g1.addActionListener(a1);        
        add(g1);
        
        
        
        add(g2);
        add(g3);
        

        setResizable(false);
    }
    
    
    
    
    
}
