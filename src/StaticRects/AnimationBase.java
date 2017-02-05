/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Keith
 */
public class AnimationBase extends JFrame implements ActionListener {
        
    StaticRectPanel outerPanel = new StaticRectPanel();
    
    public AnimationBase()
    {
        
        System.out.println("From AnimationBase.");        
    }
    
    public void drawFrame(Graphics g) {        

    }
    
    
    @Override
    public int getWidth() {
        
        return this.getSize().width;
    }
    
    @Override
    public int getHeight() {
        return this.getSize().height;
    }
    
    final private Timer timer = new Timer(100, this);
    private JPanel display;
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        display.repaint();
    }    
    
}
