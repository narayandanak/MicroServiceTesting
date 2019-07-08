package com.ezdi.testRunner;

import com.ezdi.authentication.MyTokenGenerator;

public class TestRunner extends apiTestRunner.TestRunner
{
	static
	{
		try
		{
			MyTokenGenerator dummyObject = new MyTokenGenerator("", "");
			run("com.ezdi.testScripts");
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[])
	{
		//main(args);
	}

}
