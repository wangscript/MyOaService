package com.dafy.myoaservice.web;


public class BusinessService extends BusBusinessService
{
	private static BusinessService instance=new BusinessService();
	public static BusinessService getInstance()
	{
		return instance;
	}
	
}
