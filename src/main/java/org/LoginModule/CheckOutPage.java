package org.LoginModule;

import org.LibraryFiles.BaseClass;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseClass 
{
	@FindBy(xpath="//input[@id=\"first-name\"]") private WebElement FName;
	@FindBy(xpath="//input[@id=\"last-name\"]") private WebElement LName;
	@FindBy(xpath="//input[@id=\"postal-code\"]")private WebElement ZipCode;
	@FindBy(xpath="//a[text()=\"CANCEL\"]")private WebElement cancelBtn;
	@FindBy(xpath="//input[@class=\"btn_primary cart_button\"]") private WebElement Continue;
	//ErrorMsg
	@FindBy(xpath="//h3[@data-test=\"error\"]")private WebElement erorrMsg;
	@FindBy(xpath="//div[text()=\"Checkout: Your Information\"]")private WebElement pageTitle;
	@FindBy(xpath="//div[@class=\"app_logo\"]")private WebElement logo;
	@FindBy(xpath="//a[@class=\"shopping_cart_link fa-layers fa-fw\"]")private WebElement shopingCardIcon; 
	
	
	public CheckOutPage()
	{
		PageFactory.initElements( driver,this);
	}
    public String  getCurrentURLCheckOutPage()
    {
    	
		String CheckOutpageURL = driver.getCurrentUrl();
    	 return CheckOutpageURL;
    }
    public void enterFnameCheckOutPage(String FristName)
    {
    	FName.sendKeys(FristName);
    }
    public void enterLnameCheckOutPage(String LastName)
    {
    	LName.sendKeys(LastName);
    }
    public void enterZipCodeCheckOutPage(String ZCode)
    {
    	ZipCode.sendKeys(ZCode);
    }
    public void clickOnCancelBtnCheckOutPage()
    {
    	cancelBtn.click();
    }
    public void clickOnContinueCheckOutPage()
    {
    	Continue.click();
    }
    public String geterrorMsgCheckOutPage()
    {
    	String errorMessage = erorrMsg.getText();
    	return errorMessage;
    }
    public String getPageTitleCheckOutPage()
    {
    	String titlePage = pageTitle.getText();
    	return titlePage;
    }
    public boolean validateLogoCheckOutPage()
    {
    	boolean status = logo.isDisplayed();
    	return status;
    }
    public void clickOnshopingCardIcon()
    {
    	shopingCardIcon.click();
    	
    }
    public boolean validateErrorMsgCheckOutPage()
    {
    	boolean errorMessage = erorrMsg.isDisplayed();
    	return errorMessage;
    }
    public boolean validatePageTitle()
    {
        boolean status = pageTitle.isDisplayed();
        return status;
    }
    public void validateUserAbletoContinueWithValidCredintial(String fname,String lname,String zcode)
    {
    	FName.sendKeys("fname");
    	LName.sendKeys("lname");
    	ZipCode.sendKeys("zcode");
    	Continue.click();
    	
    }
 

}
