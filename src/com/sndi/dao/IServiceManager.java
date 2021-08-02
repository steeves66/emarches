package com.sndi.dao;

import com.sndi.service.Iservice;
import com.sndi.service.Service;

public class IServiceManager 
{
	private static Iservice iservice;
	public static Iservice getInstanceOfIservice()
	{
		if(iservice == null)
		{
			iservice = new Service();
			return iservice;
		}
		return iservice;
	}

}
