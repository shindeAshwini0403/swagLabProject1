package org.loginModule;

import java.util.Arrays;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.LoginModule.FilterPage;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterPageTestClass extends BaseClass
{
	LoginPage pageLogin;
	FilterPage filter;
	Homepage home;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		
		initializeBrowser("chrome");
		pageLogin.login("standard_user", "secret_sauce");
		filter=new FilterPage();
		pageLogin=new LoginPage();
	}
	@Test
	public void  VerifyFilterDropDownOption()
	{
		
		List<String>expectedOption=Arrays.asList("Name (A to Z)", 
	            "Name (Z to A)","Price (low to high)", 
	            "Price (high to low)" );
		List<String> actualOptions = filter.getFiterOption();
		// Compare the expected and actual lists
        Assert.assertEquals(actualOptions, expectedOption, "Dropdown options do not match the expected values.");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	



}


