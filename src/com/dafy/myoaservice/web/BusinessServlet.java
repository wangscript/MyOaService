package com.dafy.myoaservice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.dafy.dflib.web.BaseCDOServlet;
import com.dafy.dflib.web.Utility;

public class BusinessServlet extends BaseCDOServlet
{

	private static final long serialVersionUID=1209629026562492309L;


	@Override
	public Return handleTrans(HttpServletRequest request,HttpServletResponse response,CDO cdoRequest,CDO cdoResponse)
	{
		Return ret=null;
		if(cdoRequest.exists("strServiceName")==false||cdoRequest.exists("strTransName")==false)
		{
	   		return ret;
		}
		Utility.setLoginer(request,cdoRequest);
		String strIp=Utility.getIpAddr(request);
		cdoRequest.setStringValue("strClientIp",strIp);

		ret=BusinessService.getInstance().handleTrans(cdoRequest,cdoResponse);
		if(ret==null||ret.getCode()!=0)
		{
			return ret;
		}
		return ret;

	}

	public BusinessServlet()
	{

	}

}
