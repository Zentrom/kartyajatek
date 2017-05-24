
package card;


import card.Megjelenites.Menu;
import javax.swing.SwingUtilities;

/**
 *
 * @author Csaba
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
        
        
        
    }
}
