/**
 * www.cdoframework.com 版权所有
 * 作者：邓勇
 * Jun 8, 2012
 */
package com.dafy.myoaservice.filter;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.DateTime;
import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.security.DES;
import com.cdoframework.cdolib.servlet.PostfixWebService;
import com.dafy.dflib.business.BusinessService;
import com.dafy.dflib.web.Constant;
import com.dafy.dflib.web.Utility;
import com.dafy.dflib.web.controller.UtilityController;


public class PostfixService extends PostfixWebService 
{
	private Logger logger = Logger.getLogger(PostfixService.class);

	public void onTransHandled(HttpServletRequest request, HttpServletResponse response, CDO cdoRequest, CDO cdoResponse, Return ret) 
	{
		Cookie cookie = new Cookie("name", "dafy");
		response.addCookie(cookie );
		logger.info("========="+cdoRequest.getStringValue("strServiceName")+"."+cdoRequest.getStringValue("strTransName"));
	}
}
