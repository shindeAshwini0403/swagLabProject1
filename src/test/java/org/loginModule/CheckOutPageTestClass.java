
package org.loginModule;

import java.io.IOException;

import org.LibraryFiles.BaseClass;
import org.LibraryFiles.UtilityClass;
import org.LoginModule.CheckOutOverViewPage;
import org.LoginModule.CheckOutPage;
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
import org.testng.asserts.SoftAssert;

public class CheckOutPageTestClass extends BaseClass
 {
	Homepage home;
	LoginPage login;
	MenuPage menu;
	ShoppingCartPage shoppingCard;
	CheckOutPage checkOut;
	CheckOutOverViewPage CheckOutOverView;
	 SoftAssert softAssert;
 @BeforeMethod
 public void setup() throws Exception
 {
	initializeBrowser("chrome");
	login=new LoginPage();
	home=new Homepage();
	menu= new MenuPage();
	softAssert = new SoftAssert();
	shoppingCard=new ShoppingCartPage();
	checkOut=new CheckOutPage();
	CheckOutOverView=new CheckOutOverViewPage();
	login.login("standard_user", "secret_sauce");
	Thread.sleep(1000);
	home.clickonShoppingCartIconHomePage();
	Thread.sleep(1000);
	shoppingCard.clickOncheckOutBtnShoppingCartPage();
	Thread.sleep(1000);

 }
 @Test(priority=1)
 public void verifyUserAbleToContinueWithValidCredentialsCheckOutPage() throws IOException, InterruptedException
 {
	 checkOut.enterFnameCheckOutPage(UtilityClass.getPFData("FristName"));
	 Thread.sleep(1000);
	 checkOut.enterLnameCheckOutPage(UtilityClass.getPFData("LastName"));
	 Thread.sleep(1000);
	 checkOut.enterZipCodeCheckOutPage(UtilityClass.getPFData("ZipCode"));
	 Thread.sleep(1000);
	 checkOut.clickOnContinueCheckOutPage();
	 Thread.sleep(1000);
	 String expected="https://www.saucedemo.com/v1/checkout-step-two.html";
	 String actualValue = CheckOutOverView.getCurrentUrl();
	 Assert.assertEquals(actualValue,expected,"User is redirected to the CheckOutOverViewPage");
	 Reporter.log("User is redirected to the CheckOutOverViewPage",true);
 } 
	 
 @Test(priority=3)
 public void verifyCheckOutFunctionalityWithoutEnteringFnameLnameAndZCode() throws InterruptedException, IOException
 {
	 checkOut.enterFnameCheckOutPage(UtilityClass.getPFData("fName"));
	 Thread.sleep(2000);
	 checkOut.enterLnameCheckOutPage(UtilityClass.getPFData("lName"));
	 Thread.sleep(2000);
	 checkOut.enterZipCodeCheckOutPage(UtilityClass.getPFData("zcode"));
	 Thread.sleep(2000);
	 checkOut.clickOnContinueCheckOutPage();
	 //Verify errormsg  display
	 boolean status = checkOut.validateErrorMsgCheckOutPage();
	 softAssert.assertTrue(status,"Error mesg is not display");
	 Reporter.log("Error mesg is display",true);
	 Thread.sleep(2000);
	 
	 //Verify errormesg text
	 String actualErrorMsg="Error: First Name is required";
	 String expectedErrorMsg = checkOut.geterrorMsgCheckOutPage();
	 softAssert.assertEquals(actualErrorMsg,expectedErrorMsg,"Both actualErrorMsg and expectedErrorMsg  is not match ");
	 softAssert.assertAll();
	 Reporter.log("Both actualErrorMsg and expectedErrorMsg  is match",true);
	
 }
 
 @Test(priority=2)
 public void verifyCheckOutFunctionalityWithBlankLname () throws IOException, InterruptedException

 {
	 checkOut.enterFnameCheckOutPage(UtilityClass.getPFData("FristName"));
	 Thread.sleep(2000);
	 checkOut.enterLnameCheckOutPage(UtilityClass.getPFData("lName"));
	 Thread.sleep(2000);
	 checkOut.enterZipCodeCheckOutPage(UtilityClass.getPFData("ZipCode"));
	 Thread.sleep(2000);
	 checkOut.clickOnContinueCheckOutPage();
	 Thread.sleep(2000);
	 //Verify erroe msg display or not
	 boolean status = checkOut.validateErrorMsgCheckOutPage();
	 softAssert.assertTrue(status,"Error mesg is not display");
	 Reporter.log("Error msg is display",true);
	 Thread.sleep(1000);
	 
	 //Verify errormesg text
	 String actualErrorMsg="Error: Last Name is required";
	 String expectedErrorMsg = checkOut.geterrorMsgCheckOutPage();
	 System.out.println(expectedErrorMsg);
	 softAssert.assertEquals(actualErrorMsg,expectedErrorMsg,"Both actualErrorMsg and expectedErrorMsg  is not match ");
	 softAssert.assertAll();
	 Reporter.log("Both actualErrorMsg and expectedErrorMsg  is match",true);
	 
 }
 @Test (priority=4)
 public void VerifyAfterClikingCancelBtnUserMoveToShoppingCartPage() throws InterruptedException
 {
	 checkOut.clickOnCancelBtnCheckOutPage();
	 Thread.sleep(2000);
	 String expectedURL="https://www.saucedemo.com/v1/cart.html";
	 String actualURL = shoppingCard.getCurrentPageURL();
	 System.out.println(actualURL);
	  Assert.assertEquals(expectedURL,actualURL,"User is redirected to the ShoppingCardPage");
	  Reporter.log("User is redirected checkOutPage to ShoppingCardPage",true);
 }
 @Test(priority=7)
 public void  verifyPageTitleCheckOutPage() throws InterruptedException
 {
	//verify pagetitle Display
	 boolean actualStatus = checkOut.validatePageTitle();
	 Assert.assertTrue(actualStatus,"Page title is not display ");
	 Reporter.log("page title is display",true);
	 Thread.sleep(100);
	 
	 
	 //Verify page Title text
	  String expectedPageTitle="Checkout: Your Information";
	  String actualPageTitle = checkOut.getPageTitleCheckOutPage();
	  Assert.assertEquals(expectedPageTitle,actualPageTitle,"Both actual and expected title is not match");
	  Reporter.log("Both actual and expected title is not match",true);
	 
 }
 @Test(priority=6)
 public void verifyLogoCheckOutPage()
 {
	 boolean islogoVisible = checkOut.validateLogoCheckOutPage();
	 Assert.assertTrue(islogoVisible, "Logo is not displayed on the checkout page!");
	 Reporter.log("Logo is  displayed on the checkout page!",true);
 }
 @Test(priority=5)
 public void verifyAfterClickingShopingCardIconUserRedirectToshpingCartPage() throws InterruptedException
 {
	   checkOut.clickOnshopingCardIcon();
	   Thread.sleep(1000);
	    String expecteduRL="https://www.saucedemo.com/v1/cart.html";
		String actualShopingCardURL = shoppingCard.getCurrentPageURL();
		Assert.assertEquals(actualShopingCardURL,expecteduRL ,"User is not redirected to the shopping cart page");
		Reporter.log("User is redirected to checkOutPage to shopping cart page ",true);
		Thread.sleep(1000);
	  
 }
@AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
 
 
 
 
 


	

 }
