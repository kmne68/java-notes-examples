/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Keith
 */
public class StaticRects extends AnimationBase {
    
    /**
     *
     * @param g
     */
    @Override
    public void drawFrame(Graphics g) {
        
        // Draw nested black rectangles on a red background.
        // Separated rectangles by 15 px
        // Frame is 300 x 160.
        
        int inset;                      // gap between border and rectangles
        int rectWidth, rectHeight;      // rectangle dimensions
        
        System.out.println("From drawFrame()");
        
        AnimationBase frame = new AnimationBase();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new StaticRectPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        System.out.println("Frame size = " + frame.getSize());
        
        g.setColor(Color.red);
        g.fillRect(0, 0, 300, 160);
        
        g.setColor(Color.BLACK);
        
        inset = 0;
        
        rectWidth = 299;
        rectHeight = 159;
        
        while(rectWidth >= 0 && rectHeight >= 0) {
            
            g.drawRect(inset, inset, rectWidth, rectHeight);
            inset += 15;
            rectWidth -= 30;
            rectHeight -= 30;
        }
    } // end drawFrame()
} // end class StaticRects