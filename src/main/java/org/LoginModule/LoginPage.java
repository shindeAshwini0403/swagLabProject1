package org.LoginModule;

import org.LibraryFiles.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass
{
	@FindBy(id="user-name")private WebElement UName;
	@FindBy(id="password")private WebElement PWD;
	@FindBy(id="login-button")private WebElement login;
	@FindBy(linkText="Username and password do not match any user in this service")private WebElement errorMsg;
	@FindBy(xpath="//div[@class=\"login_logo\"]")private WebElement logo;
	@FindBy(xpath="//img[@class=\"bot_column\"]")private WebElement img;
	@FindBy(xpath="//h3[@data-test=\"error\"]")private WebElement loginerrormsg;

	
	
	 public LoginPage()
	 {
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	 public void enterUserName(String Username) throws InterruptedException
	 {
		 UName.clear();
		 UName.sendKeys(Username); 
	 }
	 
	 public void enterpassword(String Password) throws InterruptedException
	 {
		 UName.clear();
		 PWD.sendKeys(Password);
	 }
	 
	 public  void clickonloginBtn()
	 {
		 login.click();
	 }
	 public void login(String Username,String Password) throws InterruptedException
	 {
		 UName.sendKeys(Username); 
		 Thread.sleep(1000);
		 PWD.sendKeys(Password);
		 Thread.sleep(1000);
		 login.click();
		 
	 }
	 
	 public String getErrorMsg()
	 {
		 String actualValue = errorMsg.getText();
		 return actualValue;
	 }
	 public String geterrorMsgloginpage()
	 {
		 String textValue = loginerrormsg.getText();
		 return textValue;
		 
	 }
	 
	 public String validateLoginBtnColor()
	 {
		 String actualColoreValue = login.getCssValue("background-color");
		 return actualColoreValue;
	 }
	 public boolean validateLogoLoginPage()
	 {
		 boolean status = logo.isDisplayed();
		 return status;
	 }
	 
	 public boolean validateImageLoginPage() 
	 {
		boolean imgdisplay = img.isDisplayed();
		int width = img.getSize().getWidth();
		int height = img.getSize().getHeight();
		//System.out.println(width);
		//System.out.println(height);
		return imgdisplay;
	 }

}
