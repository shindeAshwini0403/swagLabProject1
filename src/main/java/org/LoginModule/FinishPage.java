package org.LoginModule;

import org.LibraryFiles.BaseClass;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BaseClass
{
	@FindBy(xpath="//div[text()=\"Finish\"]")private WebElement pageTitle;
	@FindBy(xpath="//h2[text()=\"THANK YOU FOR YOUR ORDER\"]")private WebElement orderMsg;
	@FindBy(xpath="//div[@class=\"app_logo\"]")private WebElement logo;
	@FindBy(xpath="//img[@class=\"pony_express\"]")private WebElement img;
	@FindBy(xpath="//button[text()=\"Open Menu\"]")private WebElement menuBtn;
	@FindBy(xpath="//a[@class=\"shopping_cart_link fa-layers fa-fw\"]")private WebElement shoppingCardIvon;
	@FindBy(xpath="//div[@class=\"footer_copy\"]")private WebElement policyPrivacyTerms;
	
	
	public String getCurrentURLFinishPage()
	{
		
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
 public String getPageTitle()
 {
	 return pageTitle.getText();
	 
 }
 public boolean logoIsdisplay()
 {
	 return logo.isDisplayed();
 }
 
 public void clickOnMenuBtn()
 {
	 menuBtn.click();
	 
 }
 public void  clickOnShoppingCardIcon()
 {
	 shoppingCardIvon.click();
 }
 public String getOrderConfirmationMsg()
 {
	 return orderMsg.getText();
 }
 public boolean validImgIsDisplayed()
 {
	  return img.isDisplayed();
 }
 public Boolean ispony_expressImgLoaded()
 {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      return (Boolean) js.executeScript(
              "return arguments[0].complete && arguments[0].naturalWidth > 0;", img);
 }
 public  String  getImgAttribut()
 {
	  return img.getAttribute("src");
 }
//Scrolling till visibility of element 
 public Boolean  scrollingByTargetElement()
 {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
    
	  return (Boolean)js.executeScript("arguments[0].scrollIntoView(true);", scrollingByTargetElement());
	
 }

}
 
 
 
	


