package com.dafy.myoaservice.business;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servicebus.TransService;

public class UserService extends TransService{

	
	private Logger logger = Logger.getLogger(UserService.class);
	
	public Return handleTrans(CDO cdoRequest,CDO cdoResponse)
	{
		Return ret = null;
		String strTransName = cdoRequest.getStringValue("strTransName");
		if("register".equalsIgnoreCase(strTransName))
		{
			ret = this.register(cdoRequest,cdoResponse);
		}
		
		return ret;
	}

	private Return register(CDO cdoRequest, CDO cdoResponse) {
		
		String userAccount = cdoRequest.getStringValue("userAccount");
		String userPwd = cdoRequest.getStringValue("userPwd");
		cdoRequest.setStringValue("strLogin", userAccount);
		cdoRequest.setStringValue("strPassword", userPwd);
		cdoRequest.setStringValue("strTransName", "findOne");
		Return ret = this.service.handleDataTrans(cdoRequest, cdoResponse);
		if(ret.getCode()!=0)
		{
			return ret;
		}
		return Return.OK;
	}
}
