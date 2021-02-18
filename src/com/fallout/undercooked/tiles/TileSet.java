package com.fallout.undercooked.tiles;

import java.util.ArrayList;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
 
 
@XmlAccessorType(XmlAccessType.FIELD)
public class TileSet {
	    @XmlAttribute(required = true)
	private String source;
	     @XmlAttribute(required = true)
	private int firstgid;     
	 
	public int getFirstgid() {
	        return firstgid;
	    }
	 
	    public void setFirstgid(int firstgid) {
	        this.firstgid = firstgid;
	    }
	 
	    public String getName() {
	        return source;
	    }
	 
	    public void setName(String source) {
	        this.source = source;
	    }    
}