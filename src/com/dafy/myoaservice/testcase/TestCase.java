package com.dafy.myoaservice.testcase;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.dafy.myoaservice.web.BusinessService;


/**
 * @author Frank
 */
public class TestCase
{

	//内部类,所有内部类在此声明----------------------------------------------------------------------------------

	//静态对象,所有static在此声明并初始化------------------------------------------------------------------------

	//内部对象,所有在本类中创建并使用的对象在此声明--------------------------------------------------------------
	protected Logger log = Logger.getLogger(this.getClass());
	BusinessService service = BusinessService.getInstance();	

	//属性对象,所有在本类中创建，并允许外部访问的对象在此声明并提供get/set方法-----------------------------------

	//引用对象,所有在外部创建并传入使用的对象在此声明并提供set方法-----------------------------------------------

	//内部方法,所有仅在本类或派生类中使用的函数在此定义为protected方法-------------------------------------------

	//公共方法,所有可提供外部使用的函数在此定义为public方法------------------------------------------------------

	//接口实现,所有实现接口函数的实现在此定义--------------------------------------------------------------------

	//事件处理,所有重载派生类的事件类方法(一般为on...ed)在此定义-------------------------------------------------

	//事件定义,所有在本类中定义并调用，由派生类实现或重载的事件类方法(一般为on...ed)在此定义---------------------

	//构造函数,所有构造函数在此定义------------------------------------------------------------------------------

	public TestCase()
	{
		 
		init();
	}

	/**
	 * @param args
	 */
	public Return init()
	{
		Return ret = Return.OK;
		try
		{
			ret = service.start();
		}
		catch(Error e)
		{
			ret	=Return.valueOf(-1,e.getLocalizedMessage());
			if (log.isDebugEnabled())
			{
				log.debug(e.getMessage(), e); 
			}
		}
		catch(Exception e)
		{
			ret	=Return.valueOf(-1,e.getLocalizedMessage());
			if (log.isDebugEnabled())
			{
				log.debug(e.getMessage(), e); 
			}
		}
		if(ret.getCode()!=0)
		{
			log.error("BusinessServiceTester  starts failed!!!!!"+ret.getText());
			return ret;
		}
		if(log.isInfoEnabled()){
			log.info("BusinessServiceTester started-------------------------------------------------------------------------------------");
		}
		
		return ret;
	}

}
