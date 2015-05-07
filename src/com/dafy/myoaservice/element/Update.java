package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"OutputSQL","SQLIf","OutputSQL2","SQLIf2"})
public class Update {
	@XmlAttribute(name="RecordCountId")
	private String RecordCountId = "nRecordCount";
	@XmlElement(name="OutputSQL")
	private String OutputSQL;
	@XmlElement(name="OutputSQL")
	private String OutputSQL2;
	
	
	@XmlElement(name="SQLIf")
	private List<SQLIf> SQLIf;
	@XmlElement(name="SQLIf")
	private List<SQLIf> SQLIf2;
	
	public Update(){}
	
	public Update(String RecordCountId)
	{
		this.RecordCountId = RecordCountId;
	}
	
	
	
	public String getOutputSQL2() {
		return OutputSQL2;
	}

	public void setOutputSQL2(String outputSQL2) {
		OutputSQL2 = outputSQL2;
	}

	public List<SQLIf> getSQLIf2() {
		return SQLIf2;
	}

	public void setSQLIf2(List<SQLIf> sQLIf2) {
		SQLIf2 = sQLIf2;
	}

	public List<SQLIf> getSQLIf() {
		return SQLIf;
	}

	public void setSQLIf(List<SQLIf> sQLIf) {
		SQLIf = sQLIf;
	}

	

	public String getOutputSQL() {
		return OutputSQL;
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}

	public String getRecordCountId() {
		return RecordCountId;
	}

	public void setRecordCountId(String recordCountId) {
		RecordCountId = recordCountId;
	}
}
