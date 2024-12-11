package org.LoginModule;

import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterPage extends BaseClass
{
  @FindBy(xpath="//select[@class=\"product_sort_container\"]")private WebElement  filterOption;
  @FindBy(xpath="//div[@class=\"inventory_item_name\"]")private  List<WebElement> productNames;
  @FindBy(xpath="//div[@class=\"inventory_item_price\"]")private List <WebElement>productPrices;
  
  
  public FilterPage()
  {
	  PageFactory.initElements(driver,this);
	  
  }
  public void clickOnFilterOption()
  {
	  filterOption.click();
  }
  public List<String> getFiterOption()
  {
	  Select select=new Select(filterOption);
	 List<WebElement> options = select.getOptions();
	 List<String>optionText=new ArrayList<>();
	 for(WebElement allValue:options)
	 {
		 optionText.add(allValue.getText().trim());
	 }
	return optionText;		  
  }
  public boolean isDisplayFilterOption()
  {
	  Select select=new Select(filterOption);
		 List<WebElement> options = select.getOptions();
		 List<String>optionText=new ArrayList<>();
		 // Get all dropdown options
		 for(WebElement allValue:options)
		 {
			 if(!allValue.isDisplayed())
			 {
				 return false;  // Return false if any option is not displayed
			 }
		 }
		  return true; // Return true if all options are visible	
  }
  
  public void selectSortByNameAtoZ()
  {
	  Select select=new Select(filterOption);
	  select.selectByVisibleText("Name (A to Z)");
		
  }
  public List<String> getproductName()
  {
	 List<String>products=new ArrayList<>();
	 for(WebElement product:productNames)
	 {
		 products.add( product.getText().trim());
	 }
	 return products;
  }
  public void selectSortByNameZtoA()
  {
	  Select select=new Select(filterOption);
	  select.selectByVisibleText("Name (Z to A)");  
  }
  public void selectSortByPriceLowToHigh()
  {
	  Select select=new  Select(filterOption);
	  select.selectByVisibleText("Price (low to high)");
	  
  }
  public void selectBysortPriceHighToLowPrice()
  {
	  Select select= new Select(filterOption);
	  select.selectByVisibleText("Price (high to low)");
 }
  public List<String> getPriductPrice()
  {
	  List<String>allProductPrice=new ArrayList();
	  for(WebElement productPriceValue:productPrices)
	  {
		  allProductPrice.add(productPriceValue.getText().trim());
	  }
	  return allProductPrice;
  }
  

}
