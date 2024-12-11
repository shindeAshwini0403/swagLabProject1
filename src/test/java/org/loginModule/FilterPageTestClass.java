package org.loginModule;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.LoginModule.FilterPage;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.testng.Assert;
import org.testng.Reporter;
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
		Thread.sleep(1000);
		pageLogin=new LoginPage();
		pageLogin.login("standard_user", "secret_sauce");
		Thread.sleep(1000);
		filter=new FilterPage();
		home=new Homepage();
		home.clickOnFiltertOption();
	}
	@Test(priority=1)
	public void  VerifyFilterDropDownOption() throws InterruptedException
	{
		List<String>expectedOption=Arrays.asList("Name (A to Z)", 
	            "Name (Z to A)","Price (low to high)", 
	            "Price (high to low)" );
		List<String> actualOptions = filter.getFiterOption();
		//Verify both actual and expected fiter option are match
		// Compare the expected and actual lists
        Assert.assertEquals(actualOptions, expectedOption, "FilterDropdown options do not match the expected values.");
        Reporter.log(" Filterdropdown contains the correct value",true );
        
        //Verify  all options in the Filterdropdown are displayed
        Assert.assertTrue(filter.isDisplayFilterOption(), "Filter options are not displayed.");
        Reporter.log("Filter option are display",true);
        Thread.sleep(1000);        
	}
	
	@Test(priority=2)
	public void VerifyApplyingAlphabeticalFilterNameAtoZ() throws InterruptedException
	{
		filter.selectSortByNameAtoZ(); //applay filter
		List<String> actualProductname = filter.getproductName();
		System.out.println("ActualProductNameAToZ"+" "+actualProductname);
		Thread.sleep(1000);
		//sorting product name
		List<String> sortingProductnames = filter.getproductName();
		Collections.sort(sortingProductnames);
		Thread.sleep(1000);
		System.out.println("AfterSortingProductNameAToZ"+" "+sortingProductnames);
		Assert.assertEquals(actualProductname,sortingProductnames,"products are not sorted alphabetically(A to Z)" );
		Reporter.log("products are sorted alphabetically(A to Z)",true);
		Thread.sleep(1000);
	}
	@Test(priority=3)
	public void VerifyApplyingAlphabeticalFilterNameZtoA() throws InterruptedException
	{
		filter.selectSortByNameZtoA();
		List<String> actualproductNames = filter.getproductName();
		System.out.println("ActualProductName(Z to A):"+" "+actualproductNames);
		Thread.sleep(2000);
		//sortingproduct Names
		List<String> sortingProductNames = filter.getproductName();
		Collections.sort(sortingProductNames,Collections.reverseOrder());
		System.out.println("AfterSortingProductNameZToA"+" "+sortingProductNames);
		Thread.sleep(1000);
		Assert.assertEquals(actualproductNames,sortingProductNames,"products are not sorted alphabeticallyName(Z to A" );
		Reporter.log("Product are sorted alphabetically Z TO A");
		Thread.sleep(1000);
		
	}
	@Test (priority=4)
	public void verifySortingLowtoHighPrice() throws InterruptedException
	{
		filter.selectSortByPriceLowToHigh();;
		List<String> actualProductPrice = filter.getPriductPrice();//actual product price
	     System.out.println("ActualProductPrice:HightoLow="+" "+actualProductPrice);
		Thread.sleep(1000);
		//sorting product price
		List<String> sortingProductPrice= filter.getPriductPrice();
		Collections.sort(sortingProductPrice);//sort in assending formate
		System.out.println("aftersortingProductPrice:Low to High"+" "+sortingProductPrice);
	    Assert.assertNotEquals(actualProductPrice, sortingProductPrice,"Products are not sorted by price (Low to High)");
	    Reporter.log("Products are sorted by price (Low to High)",true);
	    Thread.sleep(1000);
	}
	@Test(priority=5)
	public void verifySortingHighToLowPrice() throws InterruptedException
	{
		filter.selectBysortPriceHighToLowPrice();
		Thread.sleep(1000);
		List<String> actualProductPrice = filter.getPriductPrice();
		System.out.println("ActualProductPriceHighToLow");
		//sorting product price
		List<String> sortingProductPrice = filter.getPriductPrice();
		Collections.sort(sortingProductPrice,Collections.reverseOrder());// Sort in descending order
		System.out.println("AfterSortingProductPrice"+" "+sortingProductPrice);
		Assert.assertNotEquals(actualProductPrice,sortingProductPrice,"product are not sorted by price(High to Low)");
		Reporter.log("product are sorted by price(High to Low)",true);	
		Thread.sleep(1000);
	}
	
	@AfterClass
	
	public void tearDown()
	{	
		driver.quit();
	}
	
	



}


