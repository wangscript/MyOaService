package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"OutputSQL","SQLIf","OutputSQL2"})
public class SelectRecord {
	@XmlAttribute(name="OutputId")
	private String OutputId;
	@XmlAttribute(name="RecordCountId")
	private String RecordCountId="nRecordCount";
	
	@XmlElement(name="OutputSQL")
	private String OutputSQL;
	@XmlElement(name="OutputSQL")
	private String OutputSQL2;
	public String getOutputSQL() {
		return OutputSQL;
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}

	public String getOutputSQL2() {
		return OutputSQL2;
	}

	public void setOutputSQL2(String outputSQL2) {
		OutputSQL2 = outputSQL2;
	}

	public List<SQLIf> getSQLIf() {
		return SQLIf;
	}

	public void setSQLIf(List<SQLIf> sQLIf) {
		SQLIf = sQLIf;
	}
	@XmlElement(name="SQLIf")
	private List<SQLIf> SQLIf;
	
	public SelectRecord(){}
	
	public SelectRecord(String OutputId,String RecordCountId)
	{
		this.OutputId = OutputId;
		this.RecordCountId = RecordCountId;
	}
	
	
	public String getOutputId() {
		return OutputId;
	}
	public void setOutputId(String outputId) {
		OutputId = outputId;
	}
	public String getRecordCountId() {
		return RecordCountId;
	}
	public void setRecordCountId(String recordCountId) {
		RecordCountId = recordCountId;
	}
}
