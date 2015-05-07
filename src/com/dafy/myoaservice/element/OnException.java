package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OnException {

	private Return Return;

	public void setReturn(Return _return) {
		Return = _return;
	}

	public Return getReturn() {
		return Return;
	}
	
	public OnException(){}
	
	public OnException(String strServiceName,String strTransName)
	{
		String code = "-1";
		String info = strServiceName+"."+strTransName+ ".Error";
		String text = "数据库查询出错！";
		Return ret = new Return(code,info,text);
		this.Return = ret;
	}
}
