package org.LoginModule;

import org.LibraryFiles.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BaseClass 
{
	@FindBy(xpath="//div[text()=\"Swag Labs\"]")private WebElement logo;
	@FindBy(xpath="//img[@class=\"inventory_details_img\"]") private WebElement img;
	@FindBy(xpath="//div[text()=\"Sauce Labs Backpack\"]")private WebElement productName;
	@FindBy(xpath="//div[@class=\"inventory_details_price\"]") private WebElement productPrice;
	@FindBy(xpath="//div[@class=\"inventory_details_desc\"]")private WebElement productDetails;
	@FindBy(xpath="//button[text()=\"ADD TO CART\"]") private WebElement addToCardBtn;
	@FindBy(xpath="//button[text()=\"REMOVE\"]")private WebElement removeBtn;
	@FindBy(xpath="//button[text()=\"<- Back\"]")private WebElement backBtn;
	@FindBy(xpath="//div[@id=\"shopping_cart_container\"]")private WebElement shopingCardIcon;
	@FindBy(xpath="//button[text()=\"Open Menu\"]")private WebElement Openmenu;
	@FindBy(xpath="//nav[@class=\"bm-item-list\"]")private WebElement filterOption;
	 public ProductDetailPage()
	 {
		 PageFactory.initElements(driver,this);
		 
	 }
	 public String getCurrentUrlProductDetailpage()
	 {
		
		String url = driver.getCurrentUrl();
		
		return url;
	 }
	 public boolean validateLogoProductDPage()
	 {
		 boolean pdLogo = logo.isDisplayed();
		 return pdLogo;
		 
	 }
	 public boolean validateProductImgDPage()
	 {
		 boolean imges = img.isDisplayed();
		 return imges;
	 }
	 public String validateProductNameProductDPage()
	 {
		  String productText = productName.getText();
		   return productText;   
	 }
	 public String getPriceProductDPage()
	 {
		 String price = productPrice.getText();
		 return price;
	 }
	 public String getProductDetails()
	 {
		 String pdescriptiion = productDetails.getText();
		 return pdescriptiion;
	 }
	 public void clickOnAddToCardbtnProductDPage()
	 {
		 addToCardBtn.click();
	 }
	 public void clickOnRemoveBtnProductDPage()
	 {
		 removeBtn.click();
		 
	 }
	 public void clickOnBackBtnProductDPage()
	 {
		 backBtn.click();
		 
	 }
	 public boolean ValidateShopingCardIconProductDetailPage()
	 {
		 boolean shopCardIcon = shopingCardIcon.isDisplayed();
		 return shopCardIcon;
	 }
	 public void  clickonShopingCardIcon()
	 {
		 shopingCardIcon.click();
	 }
	 public String validateBackBtnBgroundColorProductDetailPg()
	 {
		 String backgroundBtncolor = backBtn.getCssValue("background");
		 return backgroundBtncolor;
	 }
	 public String checkBackBtnTextColorProductDPage()
	 {
		 String backBtnTextColor = backBtn.getCssValue("color");
		 return backBtnTextColor;
	 }
	 public String checkProductColorProductDetailPg()
	 {
		 String bagcolor = img.getCssValue("color");
		 return bagcolor;
		 
	 }
	 public void clickMenuOptnOnProductDPg()
	 {
		   Openmenu.click(); 
	 }
	 public String getFilterOption()
	 {
		 String filterOptn = filterOption.getText();
		 return filterOptn;
	 }
	 public boolean clickOnImgProductDetailPage()
	 {
		 boolean value = img.isEnabled();
		 return value;
	 }
	 
	 
	 
	 
	 
	 
	 
	 

}

