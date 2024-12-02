package org.loginModule;

import java.util.Arrays;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.LoginModule.CheckOutPage;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.LoginModule.ProductDetailPage;
import org.LoginModule.ShoppingCartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCardPageTestClass extends BaseClass
{
	LoginPage login;
	Homepage  home;
	ShoppingCartPage shoppingCard;
	ProductDetailPage ProductDetail;
	CheckOutPage CheckOut;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initializeBrowser("chrome");
		login=new LoginPage();
		home=new Homepage ();
		ProductDetail= new ProductDetailPage();
		shoppingCard =new ShoppingCartPage();
		CheckOut=new CheckOutPage();
		login.login("standard_user", "secret_sauce");
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
	}
	@Test(priority=2)
	public void VerifyUseraddmultipleProductToShoppingCard() throws InterruptedException
	{
		Thread.sleep(2000);
		shoppingCard.clickonContinueShopdingBtn();
		Thread.sleep(1000);
		home.addTomultipleProductToCards(3);
		Thread.sleep(3000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(2000);
		List<String> actualProductName = shoppingCard.getProductNameShoppingCartPage();
		Assert.assertEquals(actualProductName.size(),3 ,"Total selected items count is not displayed");
		Reporter.log("The user is able to select multiple products successfully",true);
	}
	@Test(priority=5)
	public void VerifyAfterClickingContinueShopingBtnUserRedirctToHomePage() throws InterruptedException
	{
		shoppingCard.clickonContinueShopdingBtn();
		Thread.sleep(1000);
		String actualVlue =home.getCrrentURLHomepage();
		String expectedValue="https://www.saucedemo.com/v1/inventory.html";
		Assert.assertEquals(actualVlue, expectedValue,"User is not redirected to the home page");
		Reporter.log("User is redirected to the home page");
	}
	@Test(priority=6)
	public void VerifyAfterClickingCheckoutBtnUserRedirctToCheckOutPage() throws InterruptedException
	{
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		String actualURL = CheckOut.getCurrentURLCheckOutPage();
		String ExpectedURL="https://www.saucedemo.com/v1/checkout-step-one.html";
		Assert.assertEquals(actualURL, ExpectedURL, "User is not redirected to the CheckOutPage ");
		Reporter.log("User is redirected to the CheckOutPage",true);
		
		
	}
	@Test(priority=1)
	public void VerifyPageTitle()
	{
		String actualPagetitle = shoppingCard.getDisplayTitle();
		String ExpectedPageTitleText="Your Cart";
		Assert.assertEquals(actualPagetitle, ExpectedPageTitleText, "Displayed page title mismatch");		
		Reporter.log("displayed Page Title",true);
	}
    @Test(priority=4)
	public void VerifyUsersUpdateProductQuantitiesAfterRemoveProductsFromcart() throws InterruptedException
	{
		Thread.sleep(2000);
		shoppingCard.clickonContinueShopdingBtn();
		Thread.sleep(1000);
		home.addTomultipleProductToCards(3);
		Thread.sleep(3000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(2000);
		int actualProductName = shoppingCard.getProductNameShoppingCartPage().size();
		System.out.println(actualProductName);
		Thread.sleep(1000);
		shoppingCard.removeProduct(2);
		Thread.sleep(1000);
		int updatedProductCount = shoppingCard.getProductCount();
		Assert.assertNotEquals(actualProductName,updatedProductCount,"Product was not removed successfully" );
	    Reporter.log("Product was  removed successfully",true);
	}
	@Test(priority=3)
	public void verifyMultipleProductSpecification() throws InterruptedException
	{
		Thread.sleep(2000);
		shoppingCard.clickonContinueShopdingBtn();
		Thread.sleep(1000);
		home.addTomultipleProductToCards(3);
		Thread.sleep(3000);
		home.clickonShoppingCartIconHomePage();
		
		List<String>expectedName= Arrays.asList("Sauce Labs Backpack","Sauce Labs Bolt T-Shirtt","Sauce Labs Onesie");
		List<String>expectedprice= Arrays.asList("29.99","15.99","7.99");	
		int produCtount = shoppingCard.getProductCount();
		for(int i=0;i<produCtount;i++)
		{
			Assert.assertEquals(shoppingCard.getProductName(i),expectedName.get(i),"Name mismatch at index "+i);
			Reporter.log(" Both Actrual and Expected Product name is match!",true);
			Thread.sleep(1000);
			Assert.assertEquals(shoppingCard.getproductPrice(i),expectedprice.get(i),"Price mismatch at index "+ i);
			Reporter.log(" Both Actrual and Expected Product price is match!",true);
			Thread.sleep(1000);
			
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	
}
