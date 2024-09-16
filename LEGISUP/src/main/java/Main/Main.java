/**
 *
 * @author marcio.moda
 * 
 */
package Main;

import javax.swing.SwingUtilities;
import views.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LegisUpLogin().setVisible(true);
            }
        });
    }
}
