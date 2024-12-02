package org.LoginModule;

import java.util.ArrayList;
import java.util.List;

import org.LibraryFiles.BaseClass;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Homepage extends BaseClass
{
	@FindBy(xpath="(//button[@class=\"btn_primary btn_inventory\"])[1]") private WebElement addToCard;
	@FindBy(xpath="//button[text()=\"REMOVE\"]")private WebElement remove;
	@FindBy(xpath="//div[@class=\"app_logo\"]") private WebElement logo;
	@FindBy(xpath="//button[text()=\"Open Menu\"]")private WebElement openMenu;
	@FindBy(tagName="img") private List<WebElement> images;
	@FindBy(xpath="(//img[@class=\"inventory_item_img\"])[1]") private WebElement backPackImg;
	@FindBy(xpath="//div[@id=\"shopping_cart_container\"]") private WebElement shoppingCarticon;
	@FindBy(xpath="//select[@class=\"product_sort_container\"]") private WebElement filterOptn;
	@FindBy(xpath="//button[@class=\"btn_primary btn_inventory\"]")private List<WebElement> addToCartButtons;

	// Constructor to initialize elements
	
	public Homepage()
	{
		
		PageFactory.initElements( driver,this);
		
	}
	//Click on add to card
	public void clickAddToCartBtnSwagLabHomePage() throws InterruptedException
	{
		
	     addToCard.click();
	}
	//verify logo
	public boolean validateLogoSwagLabHomePage()
	{
		boolean result = logo.isDisplayed();
		return result;	
	}
	//click on menu btn
	public void clickOpenMenuButtonSwagLabHomePage()
	{
		
		openMenu.click();		
	}
	//getting for the images
	public List<WebElement>validateAllimagesOnSwagLabHomePage()
	{
		return images;
		
	}
	//click on img
	public void clickOnBackPackImgSwagLabHomePage()
	{
		backPackImg.click();
	}
	//shopping card icon
	public boolean checkShoppingCartIconDisplayHomePage()
	{
		boolean result = shoppingCarticon.isDisplayed();
		return result;
	}
	public void  clickonShoppingCartIconHomePage()
	{
		shoppingCarticon.click();
	}
	
	public String getAddToCartBtnTextColorHomePage()
	{
	   String actualValue = addToCard.getCssValue("color");
	  
		return actualValue;	
	}
	public String getBagroundColorAddToCartBtnHomePage()
	{
		String actualBagroundColor = addToCard.getCssValue("background-color");
		return actualBagroundColor;
	}
	//find imgs
	public int getImgCountHomepage()
	{
		int imgCount = images.size();
		return imgCount;
		
	}
	public List<String> ValidateallFilterOtpnHomePage()
	{
		Select sclectOption=new Select(filterOptn);
		List<WebElement> getAllOption = sclectOption.getOptions();
		
		List<String> actualOption = new ArrayList<String>();
		for(WebElement option:getAllOption)
		{
		System.out.println(option);
		actualOption.add(option.getText());
		
		}
		
		
	  return actualOption ;
	   
	}
	public String getTitleHomePage()
	{
		
		String title = driver.getTitle();
		return title ;
	}
	public void addTomultipleProductToCards(int numberOfProducts)
	{
		for(int i=0;i<numberOfProducts;i++)
		{
			addToCartButtons.get(i).click();
			
		}
	}
	public String getCrrentURLHomepage()
	{
	   
		String URL = driver.getCurrentUrl();
		return URL;
	}
	
	
	
}
	
	
	
	
	
	
	
	



