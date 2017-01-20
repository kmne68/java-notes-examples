/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects.ArtUtilities;

import static StaticRects.TileSplitter.hasAlpha;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Keith
 */
public class TileUtilities {

    private BufferedImage tileSet;
    private int textureWidth;
    private int textureHeight;
    BufferedImage[][] tileArray = new BufferedImage[16][16];

    public BufferedImage loadTileSet() throws IOException {
        int imageHeight = 0;
        int imageWidth = 0;

        try {
            tileSet = ImageIO.read(new File("c:\\java\\images\\curses.png"));
            imageHeight = tileSet.getHeight();
            System.out.println("imageWidth = " + imageWidth);
            System.out.println("imageHeight = " + imageHeight);
            //       output = ImageIO.write(input, "c:\\java\\images\\out.bmp", null)
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return tileSet;
    }

    // Initial method to capture and save a Sub-Image of "input"
    public BufferedImage saveSubImage() {
        int x = 0, y = 0, w = textureWidth, h = textureHeight;     // width is 8, height is 12
        BufferedImage testImage = null;

        try {
            for (int row = 0; row <= 15; row++) {
                System.out.println("row = " + row);
                for (int column = 0; column <= 15; column++) // was column <= 15
                {
                    System.out.println("column = " + column + ", x = " + x + ", y = " + y);
                    tileArray[row][column] = tileSet.getSubimage(x, y, w, h);
                    x = x + 8;

                }
                x = 0;
                y = y + 12;
            }
            return testImage = tileArray[7][7];
        } finally {
        }
    }

    // Returns a random 8 x 12 sub-image from our Buffered Image input
    public BufferedImage getRandomImage() {

        BufferedImage bi = new BufferedImage(textureWidth, textureHeight, BufferedImage.TYPE_INT_ARGB);

        Random randomRow = new Random();
        int rowIndex = (randomRow.nextInt(16)) * 8;

        Random randomColumn = new Random();
        int columnIndex = (randomColumn.nextInt(16)) * 12;

        System.out.println("rowIndex = " + rowIndex + ", columnIndex = " + columnIndex);

        bi = tileSet.getSubimage(rowIndex, columnIndex, textureWidth, textureHeight);
        return bi;
    }

    // Remove background color from tiles
    public Image makeColorTransparent(BufferedImage im, final Color color) // Accepts a BI object and a color to filter to transparent, returns an Image object
    {
        ImageFilter filter = new RGBImageFilter() // Initialize the filter object
        {
            // the color we want to replace... Alpha bits are set to opaque
            // the first two digits after the "x" are the alpha bits, the second two are red, the next two are green and the last two are blue
            // getRGB gets the rgb code for the target color in integer form, this is the color we will make transparent
            public int markerRGB = color.getRGB() | 0xFF000000;		// changed from 0xFF000000. FF00FF00 turns magenta to clear
            // int transparentColor = 0xFF00FF;

            public int filterRGB(int x, int y, int rgb) // use the filterRGB method to apply the rgb filter to the image
            {
                if ((rgb | 0xFF000000) == markerRGB) // go through the image pixel by pixel to determine if the pixel needs to be made transparent
                {
                    return 0x00FFFFFF & rgb;					// Mark the alpha bits as zero - transparent, leave other bits alone
                } else {
                    return rgb;									// if the target color is not found, do nothing to that pixel
                }
            }
        };
        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);

        return Toolkit.getDefaultToolkit().createImage(ip);				// need to learn more about this, part of Swing I believe
    }

    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(
                    image.getWidth(null), image.getHeight(null), transparency);
            System.out.println("image height is " + image.getHeight(null) + " and width is " + image.getWidth(null));
            System.out.println("image has alpha true or false: " + hasAlpha(image));
        } catch (HeadlessException e) {
            // The system does not have a screen
        }

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;

            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }
}
