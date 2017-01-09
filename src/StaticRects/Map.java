/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Keith
 */
public class Map extends JComponent {
    
    public int tileWidth = 8;
    public int tileHeight = 12;
    public int mapLength = 10;
    public int mapWidth = 10;
    
    BufferedImage input, output, testImage;
    static BufferedImage testOut; 
    BufferedImage[] testArray;
    BufferedImage[][] tileArray = new BufferedImage[16][16];
    int imageWidth = 0, imageHeight = 0;
    int subImageWidth = 8;
    int subImageHeight = 12;
    
    TileSplitter splitter;

    public Map() {
        this.splitter = new TileSplitter();
        
        splitter.LoadImage();
        // testOut = splitter.SaveImage(); // Capture and save the SubImage
        testOut = splitter.getRandomImage();
        splitter.ShowImage(testOut);
    }    

//   public void paint(Graphics g) {
//      g.fillRect (15, 15, 50, 50);
//   }
    
    /*        g.drawImage(bi,
                    dx, dy, 
                    x+cellWidth, dy+cellHeight,
                    sx, sy,
                    sx+cellWidth, sy+cellHeight,
                    null);
    */
    
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        float thickness = 3;
        int currentX = 3;
        int currentY = 3;
  //      g2d.setStroke(new BasicStroke(thickness));
        
            for(int i = 0; i < 30; i++) {   
                for (int j = 0; j < 30; j++) {
                    g2d.setColor(Color.black);
                    g2d.drawRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                    g2d.setStroke(new BasicStroke(thickness));
                    g2d.setColor(Color.yellow);
                    System.out.println("currentX = " + currentX + ", CurrentY " + currentY);
                    g2d.drawImage(testOut, 7, 12, null);
                    g2d.fillRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);  
                    currentX += 3;
                    currentY += 3;
                }
            } 
    }        
        

}

/*Graphics2D g2;
double thickness = 2;
Stroke oldStroke = g2.getStroke();
g2.setStroke(new BasicStroke(thickness));
g2.drawRect(x, y, width, height);
g2.setStroke(oldStroke); */
