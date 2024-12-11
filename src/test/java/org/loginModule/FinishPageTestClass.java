package org.loginModule;

import org.LibraryFiles.BaseClass;
import org.LibraryFiles.UtilityClass;
import org.LoginModule.CheckOutOverViewPage;
import org.LoginModule.CheckOutPage;
import org.LoginModule.FinishPage;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.LoginModule.ShoppingCartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FinishPageTestClass extends BaseClass
{
	
	LoginPage login;
	Homepage home;
	ShoppingCartPage shopping;
	CheckOutPage checkOut;
	CheckOutOverViewPage CheckOutOverView;
	FinishPage finish;
	SoftAssert softassert;
	
	
	@BeforeClass
	public void tearUp() throws Exception
	{
		initializeBrowser("chrome");
		login=new LoginPage();
		home=new Homepage();
		shopping=new ShoppingCartPage();
		checkOut=new CheckOutPage();
		CheckOutOverView=new CheckOutOverViewPage();
		softassert=new SoftAssert();
		login.login("standard_user", "secret_sauce");
		Thread.sleep(1000);
		home.addTomultipleProductToCards(3);
		Thread.sleep(1000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shopping.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
        Thread.sleep(1000);
        CheckOutOverView.clickOnFineshBtn();
	}
	@Test
	public void  verifylogoFinishPage()
	{
		boolean actualStatuas = finish.logoIsdisplay();
		Assert.assertTrue(actualStatuas, "Logo is not displayed on finish page");
		Reporter.log("Logo is displayed on FinishPage",true);	
	}
	@Test
	public void  verifyPageTitle()
	{
		String actualPageTitle = finish.getPageTitle();
		String expectedPageTitle="Finish";
		Assert.assertEquals(actualPageTitle,expectedPageTitle,"Page title does not match to the expected Value");
		Reporter.log("Page title verification passed!",true);
	}
	@Test
	public void VerifyOrderConfirmationMsg()
	{
		String actualMsgConfirmationText = finish.getOrderConfirmationMsg();
		String expectedConfirmationMsgText="THANK YOU FOR YOUR ORDER";
		Assert.assertEquals(actualMsgConfirmationText, expectedConfirmationMsgText,"Order confirmation message is incorrect!");
		Reporter.log("Order confirmation message verified successfully.",true);
	}
	@Test
	public void verifypony_expressImgTest()
	{
		//verify img isDisplayed
		boolean actualValue = finish.validImgIsDisplayed();
		softassert.assertTrue(actualValue,"Image is not displayed!");
		Reporter.log("pony_expressImg is displayed",true);
		
		//verify img is loaded or not
		Boolean actualStatusImgLoaded = finish.ispony_expressImgLoaded();
		softassert.assertTrue(actualStatusImgLoaded,"Image is not loaded!");
		Reporter.log("Image is successfully loaded!",true);	
		
		//verify img attribute src
		String actualAttributeValuesrc = finish.getImgAttribut();
		String  expectedAttributeValue="img/pony-express.png";
		softassert.assertEquals(actualStatusImgLoaded,expectedAttributeValue,"Image src attribute  mismatch");
		Reporter.log("Image src attribute not mismatch",true);
		
		softassert.assertAll();
		
	}
	@Test
	public void VerifytheElementIsVisibleAfterScrollingpageTest()
	{
		Boolean actualValue = finish.scrollingByTargetElement();
		Assert.assertTrue(actualValue,"page is  not scrolling" );
		Reporter.log("Element is visible after scrolling page",true);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
