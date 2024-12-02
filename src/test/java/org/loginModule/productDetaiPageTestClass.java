package org.loginModule;

import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.LibraryFiles.UtilityClass;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.LoginModule.MenuPage;
import org.LoginModule.ProductDetailPage;
import org.LoginModule.ShoppingCartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class productDetaiPageTestClass extends BaseClass 
{
	LoginPage login;
	Homepage home;
	ProductDetailPage productDetail ;
	ShoppingCartPage  ShoppingCart;
	MenuPage menu;
	
	@BeforeMethod
	public void  setup() throws Exception
	{
		initializeBrowser("chrome");
		login=new LoginPage();
		Thread.sleep(2000);
		home=new Homepage();
		Thread.sleep(2000);
		productDetail=new ProductDetailPage();
		ShoppingCart=new ShoppingCartPage();
	    login.login("standard_user", "secret_sauce");
	    home.clickOnBackPackImgSwagLabHomePage();
	    Thread.sleep(1000);
	    menu=new MenuPage();
	}
	@Test
	public void verifyProductImgPrecenceOnProductDPage()
	{
	  boolean status = productDetail.validateProductImgDPage();
	  Assert.assertTrue(status,"Image is not displayed on the product detail page");
	  Reporter.log("Image is displayed on the productDetail Page",true);
	}
	@Test
	public void verifyProductPriceproductDetailPage()
	{
		String expectedPrice="$29.99";
		String actualPrice = productDetail.getPriceProductDPage();
		Assert.assertEquals(actualPrice, expectedPrice,"Product price is not match the expected price");
		Reporter.log("Product price  match the expected value",true);
		
	}
	@Test
	public void VerifyProductNameproductDetailPage() throws InterruptedException
	{
		String expectedProductName="Sauce Labs Backpack";
		String actualProductName = productDetail.validateProductNameProductDPage();
		Assert.assertEquals(actualProductName,expectedProductName,"Product name does not match the expected value");
		Reporter.log("Product name  match the expected value ProductDetailPage",true);
		Thread.sleep(1000);
	}
	@Test
	public void verifyProductDescription() throws InterruptedException
	{
     String expectedDescription="carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
      ;
     String actualDescription=productDetail.getProductDetails();
     Assert.assertEquals(expectedDescription,actualDescription,"Product description does not match the expected value");
     Reporter.log("Product description is match the expected value ProductDetailPage",true);
     Thread.sleep(1000);
		
	}
	@Test
	public void verifyAfterClickingAddToCardBtnProductMoveTocard() throws InterruptedException
	{
		productDetail.clickOnAddToCardbtnProductDPage();
		Thread.sleep(1000);
		productDetail.clickonShopingCardIcon();
		boolean status = ShoppingCart.checktProductDisplayOnShoppingCartpage();
		Assert.assertTrue(status,"Product was not added to the cart" );
		Reporter.log("Product is added to the cart successfully ProductDetailPage",true);
	}
	@Test
	public void verifyAfterClikingRemvBtnProductRemoveTocard() throws InterruptedException
	{
		productDetail.clickOnAddToCardbtnProductDPage();
		Thread.sleep(1000);
		productDetail.clickOnRemoveBtnProductDPage();
		Thread.sleep(1000);
		productDetail.clickonShopingCardIcon();
		Thread.sleep(1000);
		boolean status = ShoppingCart.checktProductDisplayOnShoppingCartpage();
		Assert.assertTrue(status,"Product does not remove to the cart successfully" );
		Reporter.log("Product is remove to the cart successfully ProductDetailPage",true);
		Thread.sleep(1000);
	}
	@Test
	public void VerifyAfterClikingBackBtnUserMoveToHomePage() throws InterruptedException
	{
		productDetail.clickOnBackBtnProductDPage();
		Thread.sleep(1000);
		String expectedTitle="Swag Labs";
		String actualTitle = home.getTitleHomePage();
		Assert.assertEquals(actualTitle, expectedTitle,"User did not return to the home page");
		Reporter.log("User  return to the home page successfully ProductDetailPage",true);
		Thread.sleep(1000);
		
	}
	@Test
	public void VerifyLogo() throws InterruptedException
	{
		boolean status = productDetail.validateLogoProductDPage(); 
		Assert.assertTrue(status,"Logo is not present ProductDetail Page");
		Reporter.log("Logo is present ProductDetail Page",true);
		Thread.sleep(1000);
		
	}
	@Test
	public void verifyOpenMenuoption() throws InterruptedException
	{
		productDetail.clickMenuOptnOnProductDPg();
		Thread.sleep(1000);
	    List<String>expectedMenuOptions=new ArrayList<>(List.of("All Items", "About", "Logout","Reset App State"));
	     List<String> actualMenuOption = menu.getallmenuOptn();
	     System.out.println(actualMenuOption);
	     Assert.assertEquals(actualMenuOption,expectedMenuOptions,"Menu options do not match expected values" );
	     Reporter.log(" Get all Menu options successfully",true);
	     Thread.sleep(1000);
	}
	@Test
	public void verifyAfterClickingShopingCardIconUserRedirectToshpingCartPage() throws InterruptedException
	{
		productDetail.clickonShopingCardIcon();
		String expecteduRL="https://www.saucedemo.com/v1/cart.html";
		String actualShopingCardURL = ShoppingCart.getCurrentPageURL();
		Assert.assertEquals(actualShopingCardURL,expecteduRL ,"User is not redirected to the shopping cart page");
		Reporter.log("User is redirected to productDetaiPage to shopping cart page ",true);
		Thread.sleep(1000);
		
	}
	@Test
	public void verifyBackBtnSpecification() throws InterruptedException
	{
		//verify back btn  bBaground color
		String expectedBagroundColor="rgb(87, 193, 232)none repeat scroll 0% 0% / auto padding-box border-box";
		String actualBagroundColor = productDetail.validateBackBtnBgroundColorProductDetailPg();
		System.out.println(actualBagroundColor);
		Assert.assertEquals(actualBagroundColor, expectedBagroundColor,"Backbutton Baground color does not match the expected value");
		Reporter.log("Back button baground  color  match the expected color",true);
		Thread.sleep(1000);
		
		//verify backbtn textColor
		String expectedTextColor="rgba(255, 255, 255, 1)";
		String actualBtnTextColor = productDetail.checkBackBtnTextColorProductDPage();
		System.out.println(actualBtnTextColor);
		Assert.assertEquals(actualBtnTextColor, expectedTextColor,"Backbutton Text color does not match the expected value");
		Reporter.log("Backbutton Text color match the expected value",true);
		
	}
	@Test
	public void VerifyimgClikable()
	{
	boolean isenabled = productDetail.clickOnImgProductDetailPage();
		
		Assert.assertTrue(isenabled, "The image is not enabled.");
		Reporter.log("The image is not enabled.",true);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
