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

    private int[] xPoints; // = {40, 48, 48, 40};
    private int[] yPoints; // = {60, 60, 72, 72};
    private int numberOfPoints; // = 4;

    public Entity(int[] xpoints, int[] ypoints, int points) {

        this.xPoints = xpoints;
        this.yPoints = ypoints;
        this.numberOfPoints = points;
        this.shape = new Polygon(xPoints, yPoints, numberOfPoints);
    }

    public Polygon getShape() {
        return shape;
    }

    public int[] moveEntityRight(int x) {
        if (xPoints[0] - x < 0) {
            // do nothing
        } else {
            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] = xPoints[i] + x;
            }
        }
        return xPoints;
    }

    public int[] moveEntityLeft(int x) {
        if (xPoints[0] - x < 0) {
            // do nothing
        } else {
            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] = xPoints[i] - x;
            }
        }
        return xPoints;
    }
    
    
    public int[] moveEntityUp(int y) {
        if(yPoints[0] - y < 0) {
            // do nothing
        } else {
            for (int i = 0; i < yPoints.length; i++) {
                yPoints[i] = yPoints[i] - y;
            }
        } return yPoints;
    }
    
    
    public int[] moveEntityDown(int y) {
        if(yPoints[0] - y < 0) {
            // do nothing
        } else {
            for (int i = 0; i < yPoints.length; i++) {
                yPoints[i] = yPoints[i] + y;
            }
        } return yPoints;
    }

    public static int getXINCREMENT() {
        return XINCREMENT;
    }

    public static int getYINCREMENT() {
        return YINCREMENT;
    }

}
