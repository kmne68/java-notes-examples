/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

import java.awt.image.BufferedImage;

/**
 *
 * @author Keith
 */
public class Tile {
 
    private float x, y, width, height;
    private BufferedImage texture;
    private TerrainType type;
    
    public Tile(float x, float y, float width, float height, TerrainType type) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
     //   this.texture = ;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public TerrainType getType() {
        return type;
    }

    public void setType(TerrainType type) {
        this.type = type;
    }
    
    
}
