package org.LoginModule;

import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass
{
	
	 @FindBy(xpath="//div[@class=\\\"inventory_item_name\\\"]") private WebElement  cartProduct;
	 @FindBy(xpath="//a[text()=\"Continue Shopping\"]") private WebElement ContinueShopdingBtn;
	 @FindBy(xpath="//a[text()=\"CHECKOUT\"]")private WebElement checkOutBtn;
	 @FindBy(xpath="//div[text()=\"Your Cart\"]") private WebElement pageTitle;
	 @FindBy(xpath="//div[text()=\"Swag Labs\"]")private WebElement logo;
	 @FindBy(xpath="//span[@class=\"fa-layers-counter shopping_cart_badge\"]")private WebElement totalSelectItemCount;
	 @FindBy(xpath="//button[text()=\"REMOVE\"]") private List<WebElement >removeBtn;
	 @FindBy(xpath="//div[@class=\"inventory_item_name\"]")private List< WebElement> cartProductname;
	 @FindBy(xpath="//span[@class=\"fa-layers-counter shopping_cart_badge\"]")private List <WebElement> cardItemQuantity;
	 @FindBy(xpath="//div[@class=\"inventory_item_price\"]") private List<WebElement> productPrices;

	 
		
	 public ShoppingCartPage()
	 {
		 PageFactory.initElements(driver,this);
		 
	 }
	 public String getCurrentPageURL()
	 {
		 
		String ShoppingCartPageURL = driver.getCurrentUrl();
		return ShoppingCartPageURL;
	    
	 }
	 public boolean checktProductDisplayOnShoppingCartpage()
	 {
		 boolean status = cartProduct.isDisplayed();
		 return status;
	 }
	 public void clickOncheckOutBtnShoppingCartPage()
	 {
		 checkOutBtn.click();
	 }
	 public void clickonContinueShopdingBtn()
	 {
		 ContinueShopdingBtn.click();
	 }
	 public List<String> getProductNameShoppingCartPage()
	 {
		 List<String>productNames=new ArrayList<>();
		 for(WebElement products:cartProductname)
		 {
			 productNames.add(products.getText());
		 }
		 return productNames; 
	 }
	 public String getDisplayTitle()
	 {
		  String pagetitleText = pageTitle.getText();
		 return pagetitleText;
	 }
	 public void removeProduct(int numberOfProducts) throws InterruptedException
	 {
		 for(int i=0;i<numberOfProducts;i++)
		 {
			 removeBtn.get(i).click();
			 Thread.sleep(1000);
			
		 }
		 
		 
	 }
	 public int getProductCount()
	 {
		 int count = cardItemQuantity.size();
		  return count;
	 }
	 public String getProductName(int index)
	 {
		 String productname = cartProductname.get(index).getText();
		 return productname;
	 }
	 public String  getproductPrice(int index)
	 {
		 String price = productPrices.get(index).getText();
		 return price;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
