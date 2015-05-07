package com.dafy.myoaservice.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.cache.LocalCache;


public class ApplicationListener implements ServletContextListener,ServletRequestListener
{
	private Logger log=Logger.getLogger(ApplicationListener.class);
	
	public void contextInitialized(ServletContextEvent arg0)
	{//web start business
		Return ret = Return.OK;
		BusinessService app = BusinessService.getInstance();		
		try
		{
			ret = app.start();
		}
		catch(Exception e)
		{
			log.error("ExtOA  starts failed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",e);
			ret	=Return.valueOf(-1,e.getLocalizedMessage());
		}
		if(ret.getCode()!=0)
		{
			return;
		}
//		ret=LocalCache.getInstance().start();
//		if(ret.getCode()!=0)
//		{
//			app.stop();
//			log.error("LocalCache starts failed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			return;
//		}
		
		if(log.isInfoEnabled()){
			log.info("MyOaService started-------------------------------------------------------------------------------------");
		}
		
//		String mongoDBUri = BusinessService.getInstance().getParameter("mongoDBUri");
//		String mongoDBAccount = BusinessService.getInstance().getParameter("mongoDBAccount");
//		String mongoDBPasswd = BusinessService.getInstance().getParameter("mongoDBPasswd");
//		
//		Return retMongo = MongoDBEngine.getInstance().init(mongoDBUri,mongoDBAccount,mongoDBPasswd);
//		if(retMongo.getCode()!=0)
//		{
//			log.error("MongoDBEngine open failed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			app.stop();
//			log.error("ExtOA  starts failed because MongoDBEngine open failed");
//			return;
//		}
//		
//		CDO cdoRequest = CDO.newRequest("TaskRuleService", "loadTaskRule");
//		CDO cdoResponse = new CDO();
//		Return r = app.handleTrans(cdoRequest, cdoResponse);
//		if(r.getCode()!=0)
//		{
//			log.error("Load TaskRule failed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			app.stop();
//			log.error("ExtOA  starts failed because load taskRule failed");
//			return;
//		}
//		
//		int ThreadCount = app.getParameter("ThreadCount", 1);
//		ExtThreadTeam ett = new ExtThreadTeam();
//		ett.setThreadCount(ThreadCount);
//		Return er = ett.start();
//		if(er.getCode()!=0)
//		{
//			log.error("ExtThreadTeam start failed!!!!!!!!!!!!!!!!!!!!");
//			app.stop();
//			log.error("ExtOA  starts failed because ExtThreadTeam start failed");
//			return;
//		}
	}

	public void contextDestroyed(ServletContextEvent arg0)
	{
		log.info("Stopping......................................");				
		
		BusinessService app = BusinessService.getInstance();	
		if(app.isRunning()==false)
		{
			return;
		}		
		log.info("Stopping1......................................");				
		LocalCache.getInstance().stop();
		log.info("Stopping2......................................");	
		if(log.isInfoEnabled()){
			log.info("ExtOA stopped-------------------------------------------------------------------------------------");				
		}
	}

	public void requestInitialized(ServletRequestEvent arg0)
	{
		HttpServletRequest request=(HttpServletRequest)arg0.getServletRequest();		
		String strClientIP=request.getRemoteAddr();
		String strURL=request.getRequestURL().toString();
		if(strURL.endsWith(".htm")==false && strURL.endsWith(".cdo")==false && strURL.endsWith(".html")==false)
		{
			return;
		}
		
		if(request.getQueryString()!=null)
		{
			strURL+="?"+request.getQueryString();
		}
		if(log.isDebugEnabled())
		{
			log.debug(strClientIP+": "+strURL);
		}
	}

	
	public void requestDestroyed(ServletRequestEvent arg0)
	{
	}

}
