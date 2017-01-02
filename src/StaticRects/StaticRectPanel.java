/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Keith
 */
public class StaticRectPanel extends JPanel {
   
   
   /**
    * The constructor lays out the panel.  A CardPanel occupies the CENTER 
    * position of the panel (where CardPanel is a subclass of JPanel that is 
    * defined below).  On the bottom is a panel that holds three buttons.  
    * The CardPanel listens for ActionEvents from the buttons and does all 
    * the real work of the program.
    */
   public StaticRectPanel() {
      

      setBackground( new Color(130, 0, 130) );

      
      
 //     setLayout( new BorderLayout(3,3) );
      
   //   StaticRects board = new StaticRects();
   //   this.add(board, BorderLayout.CENTER);
      
 //     JPanel buttonPanel = new JPanel();
//      buttonPanel.setBackground( new Color(220,200,180) );
 //     add(buttonPanel, BorderLayout.SOUTH);
      
 //     setBorder(BorderFactory.createLineBorder( new Color(130,50,40), 3) );
      
   }  // end constructor
   
   
} // end class HighLowGUI    
