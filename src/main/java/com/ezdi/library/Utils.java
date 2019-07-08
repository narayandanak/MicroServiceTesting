package com.ezdi.library;

import enums.RequestType;
import enums.UserType;
import library.XLOps;

public class Utils extends library.Utils
{

	public Utils(RequestType arg0, String arg1, UserType arg2, XLOps... xlops) throws Throwable
	{
		super(arg0, arg1, arg2, xlops);
		// TODO Auto-generated constructor stub

		try
		{
			//httpRequest = new MyHttpRequest(requestType, requestURL, userType);
			if (xlops.length > 0)
			{
				this.xlops = xlops[0];
			}
			else
			{
				this.xlops = new XLOps();
			}
		}
		catch (Exception e)
		{
			throw (new Throwable(e));
		}
	}

	public Utils(RequestType arg0, String arg1, String arg2, XLOps... xlops) throws Throwable
	{
		super(arg0, arg1, arg2, xlops);
		// TODO Auto-generated constructor stub

		try
		{
			//httpRequest = new MyHttpRequest(requestType, requestURL, userType);
			if (xlops.length > 0)
			{
				this.xlops = xlops[0];
			}
			else
			{
				this.xlops = new XLOps();
			}
		}
		catch (Exception e)
		{
			throw (new Throwable(e));
		}
	}

}
