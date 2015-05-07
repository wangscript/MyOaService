package com.dafy.myoaservice.schema;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.cdoframework.cdolib.servicebus.TransService;

public class SchemaService extends TransService 
{
	
	private Logger logger = Logger.getLogger(SchemaService.class);
	
	public Return handleTrans(CDO cdoRequest,CDO cdoResponse)
	{
		Return ret = null;
		
		
		return ret;
	}

}
