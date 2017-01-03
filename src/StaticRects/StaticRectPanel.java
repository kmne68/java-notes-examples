/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Keith
 */
public class StaticRectPanel extends JPanel {
   
   
   /**
    * The constructor lays out the panel.
    */
   public StaticRectPanel() {
      

        setBackground( new Color(130, 0, 130) );
        setLayout( new BorderLayout(3, 3) );  // BorderLayout with 3-pixel gaps.

        JPanel innerPanelTop = new JPanel();
        innerPanelTop.setBackground(Color.YELLOW);
        add(innerPanelTop, BorderLayout.CENTER);
        
        JPanel innerPanelBottom = new JPanel();
        innerPanelBottom.setBackground(Color.BLUE);
        add(innerPanelBottom, BorderLayout.SOUTH);
        innerPanelBottom.setPreferredSize(new Dimension(100, 200));
        
        JPanel innerInnerPanel = new JPanel();
        JPanel rightInnerPanel = new JPanel();
        innerPanelBottom.setLayout(new BorderLayout());
        innerPanelBottom.add(innerInnerPanel, BorderLayout.WEST);
        innerInnerPanel.setPreferredSize(new Dimension(400, 100));
        
        innerPanelBottom.add(rightInnerPanel, BorderLayout.EAST);
        rightInnerPanel.setPreferredSize(new Dimension(400, 100));
        
        
        
        
        
        
    //    setContentPane(innerPanelTop);
   //     add(innerPanelTop);
   //     add(innerPanelBottom);
    //    innerInnerPanel.setBackground(Color.RED);
    //    innerPanelTop.add(innerInnerPanel);
        
   //     innerPanelTop.setBackground(Color.yellow);
      
      
 //     setLayout( new BorderLayout(3,3) );
      
   //   StaticRects board = new StaticRects();
   //   this.add(board, BorderLayout.CENTER);
      
 //     JPanel buttonPanel = new JPanel();
//      buttonPanel.setBackground( new Color(220,200,180) );
 //     add(buttonPanel, BorderLayout.SOUTH);
      
 //     setBorder(BorderFactory.createLineBorder( new Color(130,50,40), 3) );
      
   }  // end constructor
   
   
} // end class HighLowGUI    
