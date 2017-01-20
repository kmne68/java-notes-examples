/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticRects;

/**
 *
 * @author Keith
 * 
 * Terrain types that may be assigned to tiles are described by the
 * TerrainType enum.
 * 
 */
public enum TerrainType {
    
    Vegetation("vegetation", true), Earth("earth", false), Water("water", false);
    
    String terrainName;
    boolean buildable;
    
    TerrainType(String terrainName, boolean buildable) {
    
        this.terrainName = terrainName;
        this.buildable = buildable;        
    }
}
