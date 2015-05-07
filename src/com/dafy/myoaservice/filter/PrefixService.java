package com.dafy.myoaservice.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.cache.LocalCache;
import com.cdoframework.cdolib.cache.localcache.Trans;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servlet.PrefixWebService;

/**
 * @author Administrator
 *
 */
public class PrefixService extends PrefixWebService 
{
	private Logger logger = Logger.getLogger(PrefixService.class);
	@Override
	public Return handleTrans(HttpServletRequest request, HttpServletResponse response, CDO cdoRequest, CDO cdoResponse)
	{
		
		Cookie[] Cookies = request.getCookies();
		if(Cookies!=null)
		{
			for(Cookie c:Cookies)
			{
				String name = c.getName();
				if(name.equals("name"))
				{
					logger.info(c.getValue());
				}
			}
		}

		return super.handleTrans(request,response,cdoRequest,cdoResponse);

	}

	

}
