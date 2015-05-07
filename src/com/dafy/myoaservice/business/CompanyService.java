package com.dafy.myoaservice.business;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servicebus.TransService;

public class CompanyService extends TransService {
	private Logger logger = Logger.getLogger(CompanyService.class);
	
	public Return handleTrans(CDO cdoRequest,CDO cdoResponse)
	{
		Return ret = null;
		
		String strTransName = cdoRequest.getStringValue("strTransName");
		if("addOrUpdate".equalsIgnoreCase(strTransName))
		{
			ret = this.addOrUpdate(cdoRequest,cdoResponse);
		}
		return ret;
	}

	private Return addOrUpdate(CDO cdoRequest, CDO cdoResponse) {
		if(cdoRequest.exists("lId"))
		{
			cdoRequest.setStringValue("strTransName", "update");
		}else
		{
			cdoRequest.setStringValue("strTransName","add");
		}
		return this.service.handleDataTrans(cdoRequest, cdoResponse);
	}
}
