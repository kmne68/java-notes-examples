/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Keith
 * 
 * Foundation class for all in game movable objects (i.e. players and NPCs
 * 
 * Use an enum for age/size
 * 
 */


public class Entity {
    
    private static final int XINCREMENT = 8;
    private static final int YINCREMENT = 12;
    
    private int size;
    private int movementRate;
    private int xDirection;
    private int yDirection;
    private BufferedImage skin;
    private boolean checkIntersection; 
    private Polygon shape;
    
    
    public Entity(int[] xpoints, int[] ypoints, int points) {
        
        this.shape = new Polygon(xpoints, ypoints, points);
    }
    
    
    public Polygon getShape() {
        return shape;
    }
    

    public static int getXINCREMENT() {
        return XINCREMENT;
    }

    public static int getYINCREMENT() {
        return YINCREMENT;
    }
    
    
    
}
