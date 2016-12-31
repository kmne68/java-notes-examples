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
    
    private JLabel labelUsername = new JLabel("Enter username: ");
    
    public AnimationBase()
    {
        System.out.println("From AnimationBase.");
        
        StaticRectPanel srp = new StaticRectPanel();
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        srp.add(labelUsername, constraints);
    }
    public void drawFrame(Graphics g) {
        
        

        
        
   //      AnimationBase frame = new AnimationBase();
        
  //      JFrame frame = new JFrame("Static Rectangles");
        
  /*      
        frame.getPreferredSize();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 75);
        frame.setSize(300, 240);
        frame.setBackground(Color.yellow);
        frame.setVisible(true);  
        */
        g.setColor(Color.BLUE);
    //    g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.yellow);
        g.drawString("Frame Number " + getFrameNumber(), 10, 15);
        g.drawString("Elapsed Time " + getElapsedTime()/1000 + " seconds", 10, 30);
    }
    
    public int getFrameNumber() {
        return frameNumber;
    }
    
    public void setFrameNumber(int frameNumber) {
        if(frameNumber < 0)
            this.frameNumber = 0;
        else
            this.frameNumber = frameNumber;
    }
    
    
    public int getWidth() {
        
        return this.getSize().width;
    }
    
    public int getHeight() {
        return this.getSize().height;
    }
    
    public long getElapsedTime() {
        
        return elapsedTime;
    }
    
    public void setFrameCount(int max) {
        
        if(max <= 0)
            this.frameCount = -1;
        else
            frameCount = max;
    }
    
    public void setMillisecondsPerFrame(int time) {
        if(time < 10)
            time = 10;
        timer.setDelay(time);
    }
    
    private int frameNumber;
    private int frameCount = -1;
    
    private long startTime;
    private long oldElapsedTime;
    private long elapsedTime;
    
    private Timer timer = new Timer(100, this);
    private boolean firstTime = true;
    
    private JPanel display;
    
    private StaticRectPanel content;
    
  /*  public AnimationBase() {
        
        content = new StaticRectPanel() {
            public void paintComponenet(Graphics g) {
                drawFrame(g);
            } */
  //      }; 
  /*      display = new JPanel() {
            public void paintComponent(Graphics g) {
                drawFrame(g);
            }
        };*/
    //    getContentPane().add(display);
  //  }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        frameNumber++;
        if(frameCount >= 0 && frameNumber >= frameCount)
            frameNumber = 0;
        elapsedTime = oldElapsedTime + System.currentTimeMillis() - startTime;
        display.repaint();
    }    
    
}
