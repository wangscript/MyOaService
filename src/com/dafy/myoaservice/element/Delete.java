package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Delete {
	@XmlAttribute(name="RecordCountId")
	public String RecordCountId;
	@XmlElement(name="OutputSQL")
	private String OutputSQL;
	
	@XmlElement(name="SQLIf")
	private List<SQLIf> SQLIf;

	public List<SQLIf> getSQLIf() {
		return SQLIf;
	}

	public void setSQLIf(List<SQLIf> sQLIf) {
		SQLIf = sQLIf;
	}

	public Delete(){}
	
	public Delete(String RecordCountId)
	{
		this.RecordCountId = RecordCountId;
	}

	public String getRecordCountId() {
		return RecordCountId;
	}

	public void setRecordCountId(String recordCountId) {
		RecordCountId = recordCountId;
	}

	public String getOutputSQL() {
		return OutputSQL;
	}

	public void setOutputSQL(String outputSQL) {
		OutputSQL = outputSQL;
	}
}
