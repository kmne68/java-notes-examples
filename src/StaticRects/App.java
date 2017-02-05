/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javanotesprojects.RandomStringsPanel;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Keith
 */
public class App {
    
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AnimationBase ab = new AnimationBase();
                ab.setVisible(true);
                ab.setContentPane(ab.outerPanel);
                ab.setLocation(100, 75);
                ab.setSize(900, 600);
                ab.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
    
}
    

