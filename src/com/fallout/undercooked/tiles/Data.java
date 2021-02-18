package com.fallout.undercooked.tiles;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Data
{
			@XmlAttribute(required = true)
		private String encoding;
			
			@XmlValue
		private String data;
			
		public String getEncoding() {
		    return encoding;
		}
		public void setEncoding(String encoding) {
		    this.encoding = encoding;
		}
		
		public String[] getDataArray() {
			return data.split(",");
		}
		public void setData(String data) {
			this.data = data;
		}
}
