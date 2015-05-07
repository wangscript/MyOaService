package com.dafy.myoaservice.element;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ServicePlugin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"xmlns","xmlLocation","ServiceConfigs"})
public class ServicePlugin {
	@XmlAttribute(name="xmlns:xsi")
	private String xmlns = "http://www.w3.org/2001/XMLSchema-instance";
	@XmlAttribute(name="xsi:noNamespaceSchemaLocation")
	private String xmlLocation = "D://XML/ServiceBus.xsd";
	@XmlElement(name="ServiceConfig")
	private List<ServiceConfig> ServiceConfigs;
	public List<ServiceConfig> getServiceConfigs() {
		return ServiceConfigs;
	}
	public void setServiceConfigs(List<ServiceConfig> serviceConfigs) {
		ServiceConfigs = serviceConfigs;
	}
}
