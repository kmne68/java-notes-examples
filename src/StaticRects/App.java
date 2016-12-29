/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javanotesprojects.RandomStringsPanel;
import javax.swing.JFrame;

/**
 *
 * @author Keith
 */
public class App {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Static Rectangles");

        StaticRectPanel content = new StaticRectPanel();
        window.setContentPane(content);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 75);
        window.setSize(300, 240);
        window.setVisible(true);      
        window.pack();  // Set size of window to preferred size of its contents.
        window.setResizable(false);  // User can't change the window's size.
    }
}
