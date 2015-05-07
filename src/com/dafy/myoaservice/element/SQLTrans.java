package com.dafy.myoaservice.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "SelectRecordSet","SelectRecord", "Insert", "Update","Delete","SelectField","OnException", "Return" })  
public class SQLTrans {

	@XmlAttribute(name="TransFlag")
	public String TransFlag;
	@XmlAttribute(name="TransName")
	public String TransName;
	@XmlAttribute(name="DataGroupId")
	public String DataGroupId;
	
	private SelectRecordSet SelectRecordSet;
	
	private OnException OnException;
	
	private Return Return;
	
	private Insert Insert;
	
	private Update Update;
	
	private Delete Delete;
	
	private SelectRecord SelectRecord;
	
	public SelectRecord getSelectRecord() {
		return SelectRecord;
	}

	public void setSelectRecord(SelectRecord selectRecord) {
		SelectRecord = selectRecord;
	}

	private SelectField SelectField;
	
	public SQLTrans(){}
	
	public SQLTrans(String TransFlag,String TransName,String DataGroupId)
	{
		this.TransFlag = TransFlag;
		this.TransName = TransName;
		this.DataGroupId = DataGroupId;
	}
	
	
	public Update getUpdate() {
		return Update;
	}

	public void setUpdate(Update update) {
		Update = update;
	}

	public Delete getDelete() {
		return Delete;
	}

	public void setDelete(Delete delete) {
		Delete = delete;
	}

	public SelectField getSelectField() {
		return SelectField;
	}

	public void setSelectField(SelectField selectField) {
		SelectField = selectField;
	}

	public Insert getInsert() {
		return Insert;
	}

	public void setInsert(Insert insert) {
		Insert = insert;
	}

	public SelectRecordSet getSelectRecordSet() {
		return SelectRecordSet;
	}

	public void setSelectRecordSet(SelectRecordSet selectRecordSet) {
		SelectRecordSet = selectRecordSet;
	}

	public OnException getOnException() {
		return OnException;
	}

	public void setOnException(OnException onException) {
		OnException = onException;
	}

	public Return getReturn() {
		return Return;
	}

	public void setReturn(Return return1) {
		Return = return1;
	}
}
