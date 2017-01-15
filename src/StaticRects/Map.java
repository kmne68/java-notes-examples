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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
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
    BufferedImage testOut;
    int imageWidth = 0, imageHeight = 0;
    int subImageWidth = 8;
    int subImageHeight = 12;
    TileSplitter splitter;
    Image filteredImage = null;

    public Map() {
        
        BufferedImage newBuff = null;
        
        this.splitter = new TileSplitter();
        splitter.LoadImage();
        testOut = splitter.getRandomImage(); 
        
        filteredImage = splitter.filterImage(testOut);
        
        
        splitter.ShowImage((BufferedImage)filteredImage);     // write image to file for testing
        /*/---------------
        filteredImage = splitter.MakeColorTransparent(testOut, Color.magenta); //new Color(0).blue);
        newBuff = splitter.toBufferedImage(filteredImage);

        splitter.ShowImage(newBuff);
        //------------------ */
        
        
       // testOut = splitter.SaveImage(); // Capture and save the SubImage

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        float thickness = 3;
        int currentX = 3;
        int currentY = 3;

        /*
         * Create a rescale filter op that makes the image
         * 50% opaque.
        
        float[] scales = {1f, 1f, 1f, 0.1f};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null); */

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                g2d.setColor(Color.black);
                g2d.drawRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                g2d.setStroke(new BasicStroke(thickness));
                g2d.setColor(Color.BLUE);
                System.out.println("currentX = " + currentX + ", CurrentY " + currentY);

 //               g2d.drawImage(testOut, rop, 7, 12);
                g2d.drawImage(filteredImage, 8, 12, null);  // draw image on map
                g2d.fillRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                currentX += 3;
                currentY += 3;
            }
        }
    }
}