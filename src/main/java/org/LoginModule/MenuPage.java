package org.LoginModule;

import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BaseClass
{
	 @FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logout;
	 @FindBy(xpath="//nav[@class=\"bm-item-list\"]")private List<WebElement>menuOptions;
	 
	 
	 public MenuPage()
	 {
		 PageFactory.initElements(driver,this);
	
	 }
	public List<String> getallmenuOptn()
	{
	   List<String>menuTexts=new ArrayList<>();
	   for(WebElement menuoption:menuOptions)
	   {
		   menuTexts.add(menuoption.getText());
	   }
	   return menuTexts;
		
	}
	 //click onMenu btn
	 public void clickOnlogoutButtonSwagLabMenuPage()
	 {
		 logout.click();

}
}
