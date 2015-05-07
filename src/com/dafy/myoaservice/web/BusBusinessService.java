package com.dafy.myoaservice.web;
import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.base.Utility;
import com.cdoframework.cdolib.business.App;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servicebus.ServiceBus;

public class BusBusinessService extends App
{
	private Logger log=Logger.getLogger(BusBusinessService.class);

	private static BusBusinessService instance=new BusBusinessService();
	public static BusBusinessService getInstance()
	{
		return instance;
	}
	
	private ServiceBus serviceClient;
	
	@Override
	public String getParameter(String paramString)
	{
		
		return serviceClient.getParameter(paramString);
	}

	protected BusBusinessService()
	{
		this.serviceClient=null;
	}

	public boolean isRunning()
	{
		return true;
	}
	
	public Return start()
	{
		Return ret=this.loadConfigFromResource("config.properties", "utf-8",this.getClass().getClassLoader());
		if(ret.getCode()!=0)
		{
			return ret;
		}
		
		String strXML=Utility.readTextResource("servicebus.xml", "utf-8",this.getClass().getClassLoader());
		if(strXML==null)
		{
			return Return.valueOf(-1,"Read servicebus.xml failed");
		}
		
		this.serviceClient=new ServiceBus();
		ret=this.serviceClient.init(strXML,null);
		if(ret.getCode()!=0)
		{
			return ret;
		}
		ret=this.serviceClient.start();
		if(ret.getCode()!=0)
		{
			this.serviceClient.destroy();
			return ret;
		}
		
		return ret;
	}

	public void stop()
	{
		this.serviceClient.stop();
		this.serviceClient.destroy();
	}


	public Return checkToDo(CDO cdoRequest)
	{
		Return ret=this.serviceClient.checkToDo(cdoRequest);

		return ret;
	}

	public Return handleTrans(CDO cdoRequest,CDO cdoResponse)
	{
		Return ret=this.serviceClient.handleTrans(cdoRequest,cdoResponse);

		return ret;
	}

	public void handleEvent(CDO cdoEvent)
	{
		this.serviceClient.handleEvent(cdoEvent);
	}

	public void raiseEvent(CDO cdoRequest)
	{
		this.serviceClient.raiseEvent(cdoRequest,0);
	}
}
