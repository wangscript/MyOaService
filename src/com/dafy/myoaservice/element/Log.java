package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class Log {
	@XmlAttribute(name="Text")
	private String Text;
	
	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Log(String Text)
	{
		this.Text = Text;
	}
}
