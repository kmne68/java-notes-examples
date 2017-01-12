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
    BufferedImage testOut = new BufferedImage(tileWidth, tileHeight, BufferedImage.TYPE_INT_ARGB);
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

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        float thickness = 3;
        int currentX = 3;
        int currentY = 3;

        /*
         * Create a rescale filter op that makes the image
         * 50% opaque.
         */
        float[] scales = {1f, 1f, 1f, 1f};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                g2d.setColor(Color.black);
                g2d.drawRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                g2d.setStroke(new BasicStroke(thickness));
                g2d.setColor(Color.yellow);
                System.out.println("currentX = " + currentX + ", CurrentY " + currentY);

                g2d.drawImage(testOut, rop, 7, 12);
//                g2d.drawImage(testOut, 7, 12, null);
                g2d.fillRect(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
                currentX += 3;
                currentY += 3;
            }
        }
    }
}