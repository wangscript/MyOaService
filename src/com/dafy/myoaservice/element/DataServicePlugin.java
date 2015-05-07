package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAttribute;

public class DataServicePlugin {

	@XmlAttribute(name="Resource")
	public String Resource;
	public DataServicePlugin(){
		
	}
	public DataServicePlugin(String Resource){
		this.Resource = Resource;
	}
}
