package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceConfig {
	@XmlAttribute(name="Name")
	private String Name;
	
	@XmlElement(name="TransService")
	private TransService TransService;
	@XmlElement(name="DataService")
	private DataServicePlugin DataService;
	
	public ServiceConfig(){}
	public ServiceConfig(String Name)
	{
		this.Name = Name;
	}
	
	public TransService getTransService() {
		return TransService;
	}
	public void setTransService(TransService transService) {
		TransService = transService;
	}
	public DataServicePlugin getDataService() {
		return DataService;
	}
	public void setDataService(DataServicePlugin dataService) {
		DataService = dataService;
	}
	
	
}
