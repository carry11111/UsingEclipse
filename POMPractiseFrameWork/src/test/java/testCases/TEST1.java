package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import listeners.Log;
import pageObjects.BaseClass;

public class TEST1 extends BaseClass {
	
	
		
	
	  //@BeforeMethod public void setup() { loadConfig(); }
	 
	@Test
	public void a1()
	{
		System.out.println(" I am rajeev");
	
		Log.info("hello");
		
		//Assert.assertTrue(false);
	}
	@Test
	public void a2()
	{
		System.out.println(" I am ranjan");
	}
	@Test
	public void a3()
	{
		System.out.println(" I am Singh");
	}

}
