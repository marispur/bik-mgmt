/*
 * Main.java
 *
 * Created on sestdiena, 2007, 14 aprîlis, 11:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bikdesigner;

import data.*;
import java.util.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.*;
import ui.MainWindow;

/**
 *
 * @author mpurins
 */
public class Main {
    public static MainWindow mw;
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (java.lang.InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        BikCatalog c = new BikCatalog();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mw = new MainWindow();
                mw.setVisible(true);
            }
        });
        
    }
    
}
