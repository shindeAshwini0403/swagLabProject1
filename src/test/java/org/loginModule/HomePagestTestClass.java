package org.loginModule;


import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.LoginModule.ProductDetailPage;
import org.LoginModule.ShoppingCartPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePagestTestClass<HttpUrlConnection> extends BaseClass			
{ 
	public HomePagestTestClass()
	{
		super();
	}
	//WebDriver driver;
	ProductDetailPage productdetail;
	Homepage home;
	LoginPage login;
	ShoppingCartPage  ShoppingCart;
	@BeforeMethod()
	public void setup() throws Exception
	{
		initializeBrowser("chrome");
		login=new LoginPage();
		home=new Homepage();
		productdetail=new ProductDetailPage();
		ShoppingCart=new ShoppingCartPage();
		login.enterUserName("standard_user");
		Thread.sleep(1000);
		login.enterpassword("secret_sauce");
		Thread.sleep(1000);
		login.clickonloginBtn();
		Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void verifyAllImagesDisplayedonHomepage () throws InterruptedException
	{
			List<WebElement> images = home.validateAllimagesOnSwagLabHomePage();
			Thread.sleep(1000);
		{
			
		 for (WebElement img :images) 
		 {
	            String imgUrl = img.getAttribute("src");
	            System.out.println("Checking image: " + imgUrl);
	          
	            Thread.sleep(1000);
	            Assert.assertTrue(imgUrl != null && !imgUrl.isEmpty(),"Image src attribute is empty for an image element!");
	            Reporter.log("Image src attribute is  not empty for an image element!");
	            // Assert that the image is displayed
	            Thread.sleep(1000);
	            
	            
	            Assert.assertTrue(img.isDisplayed(), "Image is not displayed!");
	            Reporter.log("Images are  displayed ",true);
	            Thread.sleep(1000);
	            
	            //Get the count of images
	            int actualImgCount = home.getImgCountHomepage();
	             int expectedImgCount=7;
	             Thread.sleep(1000);
	             Assert.assertEquals(actualImgCount, expectedImgCount,"Image count does not match the expected value");
	             Reporter.log("Image count match the expected value in Homepahe");
	             Thread.sleep(1000);  
	        }
		}
		
	}
	
	@Test(priority=10)
	public void  verifyHomePageLogo() throws InterruptedException
	{
		boolean status = home.validateLogoSwagLabHomePage();
		Assert.assertTrue(status,"Homepage logo is not present");
		Reporter.log("HomePage logo is present",true);
		Thread.sleep(1000);
		
	}
	@Test(priority=2)
	public void VerifyAfterClickingImgUserRdirectToProductDetailPage()
	{
		home.clickOnBackPackImgSwagLabHomePage();
		String actualUrl = productdetail.getCurrentUrlProductDetailpage();
		String expectedUrl="https://www.saucedemo.com/v1/inventory-item.html?id=4";
		Assert.assertEquals(actualUrl, expectedUrl, " actual and expected  both url is not match ");
		Reporter.log("User successfully redirects to the Product Detail page",true);
		
	} 
	@Test (priority=3)
	public void verifyAfterClickingShopCartIconUserRedirectToYourCartPage() throws InterruptedException
	{
	  home.clickonShoppingCartIconHomePage();
	  String actualURL= ShoppingCart.getCurrentPageURL();
	  String expectedURL="https://www.saucedemo.com/v1/cart.html";
	  Thread.sleep(1000);
	  Assert.assertEquals(actualURL, expectedURL,"actual and expected  both url is not match");
	  Reporter.log("User successfully redirects to the ShoppingCartPage",true);
	  Thread.sleep(1000);
	}
	@Test(priority=5)
	public void VerifyUserableToaddproductToShoopingcartOnHomepage () throws InterruptedException
	{
		home.clickAddToCartBtnSwagLabHomePage();
		Thread.sleep(2000);
		boolean status = ShoppingCart.checktProductDisplayOnShoppingCartpage();
		Thread.sleep(1000);
		Assert.assertTrue(status,"The user is not added products to the shopping cart. ");
        Reporter.log("The user successfully added products to the shopping cart. ",true);
        Thread.sleep(1000);
	}
	@Test(priority=4)
	public void verifyShopingCarticonDisplayedOnHomePage() throws InterruptedException
	{
		boolean status = home.checkShoppingCartIconDisplayHomePage();
		Thread.sleep(1000);
		Assert.assertTrue(status,"Shopping cart icon is NOT displayed on the home page.");
		Reporter.log("Shopping cart icon present on homePage",true);
		Thread.sleep(1000);
	}
	@Test(priority=6)
	public  void  verifyBrokenImagesLink() throws IOException, InterruptedException
	{
		List<WebElement> imges = home.validateAllimagesOnSwagLabHomePage();
		Thread.sleep(1000);
		for(WebElement imge:imges)
		{
			
			String imgessrcURL = imge.getAttribute("src");
			Thread.sleep(1000);
		try
		{
			URL url=new URL(imgessrcURL);
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpURLconnection=(HttpURLConnection) urlConnection;
			httpURLconnection.setConnectTimeout(5000);
			httpURLconnection.connect();
			int responseCode = httpURLconnection.getResponseCode();
			Thread.sleep(1000);
			  Assert.assertEquals(responseCode, 200, "Broken image found at URL: " + imgessrcURL);
			  System.out.println(imgessrcURL);

        } catch (Exception e) {
            Assert.fail("Failed to check image at URL: " + imgessrcURL);
            System.out.println(imgessrcURL);
            
        }
		}
	}
	@Test(priority=7)
	public void VerifyAddtocardbtnTextAndBoarderColor() throws InterruptedException
	{
		String actualColor = home.getAddToCartBtnTextColorHomePage();
		System.out.println(actualColor);
		String ExpectedColor="rgba(226, 35, 26, 1)";
		Assert.assertEquals(actualColor, ExpectedColor,"AddToCartButton textcolor does not match the expected textcolor" );
		Reporter.log(" AddToCartButton text color  match the expected value",true);
		Thread.sleep(1000);
	}
	@Test(priority=8)
	public void verifyBagroundColorForAddToCardBtn() throws InterruptedException 
	{
		String bagroundColor = home.getBagroundColorAddToCartBtnHomePage();
		System.out.println("AddToCartbtm bagrounfd  Color"+bagroundColor);
		String expectedBorderColor="rgba(255, 255, 255, 1)";
		Assert.assertEquals(bagroundColor, expectedBorderColor, " AddtoCard Button Bagroundcolor does not match the expected value");
        Reporter.log("AddToCartButton Baground color  match the expected value ",true);
        Thread.sleep(1000);
	}
	@Test(priority=9)
	public void verifyOpenMenuGetallFilterOption() throws InterruptedException
	{
		 List<String> expectedValue = new ArrayList<>(List.of("Name (A to Z)", "Name (Z to A)", "Price (low to high)","Price (high to low)"));
		 System.out.println(expectedValue);
		 List<String> actualValue = home.ValidateallFilterOtpnHomePage();
		 System.out.println(actualValue);
		 Assert.assertEquals(actualValue, expectedValue, "Get filter Dropdown options do not match expected values!");
		 Reporter.log("Display all filterOption successfully",true);
		 Thread.sleep(1000);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
