package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnItem {
	@XmlAttribute(name="ValueId")
	public String ValueId;
	@XmlAttribute(name="FieldId")
	public String FieldId;
	public ReturnItem(){}
	public ReturnItem(String ValueId,String FieldId)
	{
		this.ValueId = ValueId;
		this.FieldId = FieldId;
	}
}
