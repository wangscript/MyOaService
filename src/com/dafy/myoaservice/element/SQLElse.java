package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SQLElse {
	private String OutputSQL;
	
	public SQLElse(){}
	
	public SQLElse(String OutputSQL)
	{
		this.OutputSQL = OutputSQL;
	}
	

	public String getOutputSQL() {
		return OutputSQL;
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}
	
}
