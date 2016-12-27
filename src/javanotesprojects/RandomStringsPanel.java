/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javanotesprojects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Keith
 */
public class RandomStringsPanel extends JPanel {

    private String message; // the message that will be displayed
 
    private Font font1, font2, font3, font4, font5;
    
    // Default constructor
    public RandomStringsPanel() {
        
        this(null);
    }
    
    
    public RandomStringsPanel(String messageString) {
        
        message = messageString;
        if(message == null)
            message = "Thank you. Come again!";
        
        font1 = new Font("Serif", Font.BOLD, 14);
        font2 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 24);
        font3 = new Font("Monospaced", Font.PLAIN, 30);
        font4 = new Font("Dialog", Font.PLAIN, 36);
        font5 = new Font("Serif", Font.ITALIC, 48);
        
        setBackground(Color.BLACK);
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        int width = getWidth();
        int height = getHeight();
        
        for(int i = 0; i < 25; i++) {
            
            int fontNum = (int)(5 * Math.random()) + 1;
            switch(fontNum) {
                case 1:
                    g.setFont(font1);
                    break;
                case 2:
                    g.setFont(font2);
                    break;
                case 3:
                    g.setFont(font3);
                    break;
                case 4:
                    g.setFont(font4);
                    break;
                case 5:
                    g.setFont(font5);
                    break;
            } // end switch
            
            float hue = (float)Math.random();
            g.setColor(Color.getHSBColor(hue, 1.0F, 1.0F));            
            
            int x, y;
            x = -50 + (int)(Math.random() * (width + 40));
            y = (int)(Math.random() * (height + 20));
            
            g.drawString(message, x, y);
        } // end for
    } // end paintComponent();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Random Strings");
        RandomStringsPanel content = new RandomStringsPanel("String a-ling a-ling");
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 75);
        window.setSize(300, 240);
        window.setVisible(true);
    }
}
