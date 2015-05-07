package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class SQLIf {
	@XmlAttribute(name="Type")
	public String Type;
	@XmlAttribute(name="Operator")
	public String Operator;
	@XmlAttribute(name="Value1")
	public String Value1;
	@XmlAttribute(name="Value2")
	public String Value2;
	
	
	
	private SQLThen SQLThen;
	
	private SQLElse SQLElse;

	public SQLThen getSQLThen() {
		return SQLThen;
	}

	public void setSQLThen(SQLThen sQLThen) {
		SQLThen = sQLThen;
	}

	public SQLElse getSQLElse() {
		return SQLElse;
	}

	public void setSQLElse(SQLElse sQLElse) {
		SQLElse = sQLElse;
	}
}
