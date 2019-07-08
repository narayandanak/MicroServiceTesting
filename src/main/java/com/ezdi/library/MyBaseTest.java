package com.ezdi.library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MyBaseTest extends library.MyBaseTest
{
	public static String NLPServiceURL	= null;
	public static String catAPIBaseURL = null;
	public static String seeraBaseURL = null;
	static
	{
		try
		{
			setTestProperties();
			NLPServiceURL = prop.getProperty("NLPServiceURL");
			catAPIBaseURL = prop.getProperty("catAPIBaseURL");
			seeraBaseURL = prop.getProperty("seeraBaseURL");
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void setTestProperties() throws Throwable { try { File propFile
	 * = new File("src/main/resources/properties/" + "main.properties");
	 * FileInputStream is = new FileInputStream(propFile); prop = new Properties();
	 * prop.load(is); } catch (Exception e) { throw (new Throwable(e));
	 * 
	 * } }
	 */
	/*public static UserType getUserType(String user) throws Throwable
	{
		try
		{
	
			return UserType.getUserType(user.toUpperCase());
	
		}
		catch (Exception e)
		{
			throw (new Throwable(e));
	
		}
	}*/

}
