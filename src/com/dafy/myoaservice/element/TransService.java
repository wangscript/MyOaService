package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.FIELD)
public class TransService {
	@XmlAttribute(name="ClassPath")
	public String ClassPath;
	
	public TransService(){}
	public TransService(String ClassPath)
	{
		this.ClassPath = ClassPath;
	}
}
