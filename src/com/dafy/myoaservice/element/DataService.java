package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="DataService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"add","delete","update","findOne","findList","findListByPage"})
public class DataService {
	@XmlElement(name="SQLTrans")
	private SQLTrans findOne;
	@XmlElement(name="SQLTrans")
	private SQLTrans findList;
	@XmlElement(name="SQLTrans")
	private SQLTrans findListByPage;
	@XmlElement(name="SQLTrans")
	private SQLTrans add;
	@XmlElement(name="SQLTrans")
	private SQLTrans delete;
	@XmlElement(name="SQLTrans")
	private SQLTrans update;
	@XmlAttribute(name="xmlns:xsi")
	private String xmlns = "http://www.w3.org/2001/XMLSchema-instance";
	@XmlAttribute(name="xsi:noNamespaceSchemaLocation")
	private String xmlLocation = "D://XML/DataService.xsd";
	
	public SQLTrans getFindOne() {
		return findOne;
	}
	public void setFindOne(SQLTrans findOne) {
		this.findOne = findOne;
	}
	public SQLTrans getDelete() {
		return delete;
	}
	public void setDelete(SQLTrans delete) {
		this.delete = delete;
	}
	public SQLTrans getUpdate() {
		return update;
	}
	public void setUpdate(SQLTrans update) {
		this.update = update;
	}
	public SQLTrans getFindListByPage() {
		return findListByPage;
	}
	public void setFindListByPage(SQLTrans findListByPage) {
		this.findListByPage = findListByPage;
	}
	public SQLTrans getFindList() {
		return findList;
	}
	public void setFindList(SQLTrans findList) {
		this.findList = findList;
	}
	public SQLTrans getAdd() {
		return add;
	}
	public void setAdd(SQLTrans add) {
		this.add = add;
	}
	
	
	
	

	
	
}
