/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Keith
 */
public class StaticRects extends AnimationBase {
    
    public void drawFrame(Graphics g) {
        
        // Draw nested black rectangles on a red background.
        // Separated rectangles by 15 px
        // Frame is 300 x 160.
        
        int inset;                      // gap between border and rectangles
        int rectWidth, rectHeight;      // rectangle dimensions
        
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
    } // end paint()
} // end class StaticRects