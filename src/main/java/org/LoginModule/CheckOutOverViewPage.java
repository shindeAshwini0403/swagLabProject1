package org.LoginModule;

import java.text.DecimalFormat;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage extends BaseClass
{
	@FindBy(xpath="//div[@class=\"subheader\"]")private WebElement pageTitle;
	@FindBy(xpath="//a[text()=\"CANCEL\"]")private WebElement cancelBtn;
	@FindBy(xpath="//a[text()=\"FINISH\"]")private WebElement finishBtn;
	@FindBy(xpath="//a[@class=\"shopping_cart_link fa-layers fa-fw\"]")private WebElement shoppingCardIcon;
	@FindBy(xpath="//div[@class=\"app_logo\"]")private WebElement logo;
	@FindBy(xpath="//div[@class=\"summary_subtotal_label\"]")private WebElement itemTotalPrice;
	@FindBy(xpath="//div[@class=\"summary_tax_label\"]") private WebElement tax;
	@FindBy(xpath="//div[@class=\"summary_total_label\"]")private WebElement finaltotalPrice;
	@FindBy(xpath="//div[text()=\"FREE PONY EXPRESS DELIVERY!\"]")private WebElement deliveryCharges;
	@FindBy(xpath="//div[@class=\"inventory_item_name\"]")private List <WebElement>productname;
	@FindBy(xpath="//div[@class=\"inventory_item_price\"]")private List <WebElement> productPrice;
	
	public CheckOutOverViewPage()
	{
		PageFactory.initElements(driver, this);
	}
	//get current page title
	public String getCurrentUrl()
	{
		
		String URL = driver.getCurrentUrl();
		return URL;
	}
	//check if the logo is displayed 
	public boolean ValidateLogo()
	{
		boolean CheckOutOverViewPagelogo = logo.isDisplayed();
		return CheckOutOverViewPagelogo;
	}
	public String getItemTotalPrice()
	{
		String itomTotalPrice = itemTotalPrice.getText();
		return itomTotalPrice;
	}
	public double getTaxValue()
	{
		
		String taxValue = tax.getText().replace("$", "");
		 String cleanedString = taxValue.replaceAll("[^0-9.]", "").trim();
	        // Convert the cleaned string to double
	        double number = Double.parseDouble(cleanedString);
		     return number;
	}
	//click on cancel button
	public void clickOnCancelBtn()
	{
		cancelBtn.click();
	}
	// method to clickFinish Button
	public void clickOnFineshBtn()
	{
		finishBtn.click();
	}
	public String getdeliveryCharges()
	{
		String deliverytextValue = deliveryCharges.getText();
		return deliverytextValue;
		
	}
	//
	public void clickOnShoppingCardIcon()
	{
		shoppingCardIcon.click();
	}
	//get calculate final total price
	public String getFinalTotalPrice()
	{
		String totalValue = finaltotalPrice.getText();
		return totalValue;
	}
	
	//calculate ItemTotal Price
	public double getCalculateProductTotalPrice()
	{
		 double totalPrice = 0;
	        for (WebElement priceElement : productPrice) {
	            String priceText = priceElement.getText().replace("$", "").trim();
	            totalPrice += Double.parseDouble(priceText);
	        }
	        return totalPrice;
	}
	//get title of CheckOutOverViewPage
	public String getPageTitle()
	{
	 String pagetitle = pageTitle.getText();
	 return pagetitle;
		
	}
	//Get  Finish btn text
	public String getFinishBtnText()
	{
		return finishBtn.getText();
	}
	//check if FinishBtn isEnable
	public boolean isFinishBtnEnabled()
	{
		return finishBtn.isEnabled();
	}
	//check if finishBtn isDisplay
	public boolean isFinishBtnDisplay()
	{
	return finishBtn.isDisplayed();
	}
	//get the finalBtn background
	public String getFinishBtnbagroundColore()
	{
		return finishBtn.getCssValue("background-color") ;
	}
	
	
		
	}
	
	
	   

	

