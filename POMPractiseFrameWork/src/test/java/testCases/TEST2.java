package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import listeners.Log;
import pageObjects.BaseClass;

public class TEST2 extends BaseClass {
	
	//@BeforeMethod public void setup() { loadConfig(); }
	@Test
	public void a4()
	{
		System.out.println(" I am rajeev1");
		Log.info("iside method");
		
		Log.info("INside method 2 fo test 2");
	}
	@Test
	public void a5()
	{
		System.out.println(" I am ranjan1");
	}
	@Test
	public void a6()
	{
		System.out.println(" I am Singh1");
	}

}
