package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SelectField {

	@XmlAttribute(name="OutputId")
	private String OutputId;
	
	private String OutputSQL;
	
	@XmlElement(name="SQLIf")
	private List<SQLIf> SQLIf;
	
	public List<SQLIf> getSQLIf() {
		return SQLIf;
	}

	public void setSQLIf(List<SQLIf> sQLIf) {
		SQLIf = sQLIf;
	}

	public SelectField(){}
	
	public SelectField(String OutputId)
	{
		this.OutputId = OutputId;
	}
	
	

	public String getOutputId() {
		return OutputId;
	}

	public void setOutputId(String outputId) {
		OutputId = outputId;
	}

	public String getOutputSQL() {
		return OutputSQL;
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}
	
}
