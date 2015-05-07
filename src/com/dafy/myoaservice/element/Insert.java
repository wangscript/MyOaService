package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Insert {
	private String OutputSQL;
	
	public Insert(){}
	
	public Insert(String OutputSQL)
	{
		this.OutputSQL = OutputSQL;
		
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}

	public String getOutputSQL() {
		return OutputSQL;
	}
	
}
