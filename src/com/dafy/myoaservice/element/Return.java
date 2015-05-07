package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Return {

	@XmlAttribute(name = "Code")
	public String Code;
	@XmlAttribute(name = "Info")
	public String Info;
	@XmlAttribute(name = "Text")
	public String Text;
	@XmlElement(name = "ReturnItem")
	public List<ReturnItem> ReturnItems;
	public Return() {}
	public Return(String code, String info, String text) {
		this.Code = code;
		this.Info = info;
		this.Text = text;
	}

	public List<ReturnItem> getReturnItems() {
		return ReturnItems;
	}

	public void setReturnItems(List<ReturnItem> returnItems) {
		ReturnItems = returnItems;
	}

}
