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
  

}
