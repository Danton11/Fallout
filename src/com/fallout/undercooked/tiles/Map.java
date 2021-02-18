package com.fallout.undercooked.tiles;

import java.util.ArrayList;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "map")
public class Map {
    @XmlElement(name = "tileset")
    private List<TileSet> tilesetList = new ArrayList<TileSet>();
 
    public List<TileSet> getTilesetList() {
        return tilesetList;
    }
 
    public void setTilesetList(List<TileSet> tilesetList) {
        this.tilesetList = tilesetList;
    }
    
    @XmlElement(name = "layer")
    private List<Layer> layerList = new ArrayList<Layer>();
    
    public List<Layer> getLayerList() {
    	return layerList;
    }
    
    public void setLayerList(List<Layer> layerList) {
    	this.layerList = layerList;
    }
 
}
