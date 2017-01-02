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
                new AnimationBase().setVisible(true);
            }
        });
    }
    
  /*  public static void main(String[] args) {
        
        * 
        System.out.println("From App.main");

        AnimationBase frame = new AnimationBase();
        
   //     JFrame frame = new JFrame("Static Rectangles");
  /*      frame.getPreferredSize();
        StaticRectPanel content = new StaticRectPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 75);
        frame.setSize(300, 240);
        frame.setBackground(Color.yellow);
        frame.setVisible(true);
            frame.pack();  // Set size of frame to preferred size of its contents. When commented out, 
        frame.setResizable(true);  // User can change the frame's size.
         */
    }
    

