package org.loginModule;

import java.io.IOException;
import org.LibraryFiles.BaseClass;
import org.LibraryFiles.UtilityClass;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestClass extends BaseClass
{
	Homepage home;
	LoginPage login;
   
	//MenuPage menu;
	@BeforeMethod
	public void lunchurl() throws Exception
	{
		initializeBrowser("chrome");
		login=new LoginPage();
		home=new Homepage();
		//menu=new MenuPage(driver);
	}
	
	@Test(priority=1)
	public void  verifyloginfunctionality( ) throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.enterUserName(UtilityClass.getTestData(1, 0));
		Thread.sleep(1000);
		login.enterpassword(UtilityClass.getTestData(1, 1));
		Thread.sleep(1000);
		login.clickonloginBtn();
		
		 String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
	        if(driver.getCurrentUrl().equals(expectedUrl)) {
	        	 Reporter.log("Login successful for user: ",true );
	        } else {
	        	 Reporter.log("Login failed for user: ",true);
	        }
	        Thread.sleep(1000);
		
	}
	@Test(priority=2)
	public void verifyLoginPagepassInvalidData() throws InterruptedException, IOException
	{
		 login.enterUserName("Ashwini");
		 Thread.sleep(1000);
	     login.enterpassword("secret_sauce");
	     Thread.sleep(1000);
	     login.clickonloginBtn();
	     String actualValue = login.getErrorMsg();
	     String expectedUrl =" not match any user in this service";
	     Assert.assertEquals(actualValue,expectedUrl,"Not get successfully error Msg");
	     Reporter.log("get successfully error Msg",true);	       
	       Thread.sleep(1000);
	}
	@Test
	public void  verifyLoginBtnColourLoginPage()
	{
		String expected="rgba(226, 35, 26, 1)";//rgba(226, 35, 44, 1)
		String rgbaactualvalue = login.validateLoginBtnColor();
//		Color color = Color.fromString(rgbaactualvalue);
//		String hexActualColor = color.asHex();
		System.out.println(rgbaactualvalue);
		
		Assert.assertEquals(expected , rgbaactualvalue,"The login button color does not match the expected value");
		Reporter.log("The login button color is match the expected value",true);
		
	}
	
	@Test(priority=3)
	public void VerifythatLogoLoginPage() throws InterruptedException
	{
		boolean value = login.validateLogoLoginPage();
		Assert.assertTrue(value,"Logo is  not pressent");
		Reporter.log("Logo is present LoginPage",true);

		Thread.sleep(1000);
	}
	@Test(priority=4)
	public void VerifyImageDisplayLoginPage() 
	{
       boolean status = login.validateImageLoginPage();
       Assert.assertTrue(status, "Image is not  displayed");
       Reporter.log("LoginPage image is diaplay LoginPage ",true);
       
    }
	@Test 
	public void verifyLoginFunctionalityWithoutEnteringCredintial() throws InterruptedException
	{
		login.enterUserName("");
		Thread.sleep(1000);
		login.enterpassword("");
		Thread.sleep(1000);
		login.clickonloginBtn();
		Thread.sleep(1000);
		String actualerrormsg = login.geterrorMsgloginpage();
		System.out.println(actualerrormsg);
		String errorMsg="https://reqres.in/api/users/2";
		Assert.assertEquals("actualerrormsg","expectedErrorMsg","The login error mesg does not match the expected value");
		Reporter.log("The login error mesg match the expected  error mesage value",true);
	}
	
	@AfterMethod
	public void  logoutApp() throws InterruptedException
	{
		driver.quit();
		
	}
	

	

}

