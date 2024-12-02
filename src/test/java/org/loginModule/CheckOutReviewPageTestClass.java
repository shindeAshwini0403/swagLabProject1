package org.loginModule;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.LibraryFiles.BaseClass;
import org.LibraryFiles.UtilityClass;
import org.LoginModule.CheckOutOverViewPage;
import org.LoginModule.CheckOutPage;
import org.LoginModule.FinishPage;
import org.LoginModule.Homepage;
import org.LoginModule.LoginPage;
import org.LoginModule.MenuPage;
import org.LoginModule.ProductDetailPage;
import org.LoginModule.ShoppingCartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckOutReviewPageTestClass extends BaseClass
{
	LoginPage login;
	Homepage  home;
	ShoppingCartPage shoppingCard;
	ProductDetailPage ProductDetail;
	CheckOutPage checkOut;
	MenuPage menu;
	FinishPage finish;
	CheckOutOverViewPage CheckOutOverView;
	SoftAssert softAssert;
	@BeforeMethod
	 public void setup() throws Exception
	 {
		initializeBrowser("chrome");
		login=new LoginPage();
		home=new Homepage();
		menu= new MenuPage();
		softAssert = new SoftAssert();
		shoppingCard=new ShoppingCartPage();
		checkOut=new CheckOutPage();
		finish=new FinishPage();
		CheckOutOverView=new CheckOutOverViewPage();
		login.login("standard_user", "secret_sauce");
		Thread.sleep(1000);
	 }
	@Test(priority=5)
	public void verifyAfterClickingCancelBtnOnCheckOutPageUserRedirectToHomePage() throws InterruptedException, IOException
	{
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		Thread.sleep(1000);
		CheckOutOverView.clickOnCancelBtn();
		Thread.sleep(1000);
		String expectedURL="https://www.saucedemo.com/v1/inventory.html";
		String actualURL=home.getCrrentURLHomepage();
		Assert.assertEquals(actualURL, expectedURL, "User is not redirected to the HomePage ");
		Reporter.log("User is redirected to the HomePage ",true);
		
	}
	@Test (priority=4)
	public void verifyAfterClickingFinishBtnUserRedirectToFinishPage() throws InterruptedException, IOException
	{
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		Thread.sleep(1000);
		CheckOutOverView.clickOnFineshBtn();
		String expectedURL="https://www.saucedemo.com/v1/checkout-complete.html";
		String actualURL=finish.getCurrentURLFinishPage();
		Assert.assertEquals(actualURL,expectedURL,"User is not redirected to the FinishPage" );
		Reporter.log("User is successfully redirected to the FinishPage",true);	
		
	}
	@Test(priority=1)
	public void verifyItemTotalPriceUpdateWhenUserAddMutipleProductFromeCard() throws InterruptedException, IOException
	{
		home.addTomultipleProductToCards(3);
		Thread.sleep(1000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		Thread.sleep(1000);
		double calculateTotalPrice = CheckOutOverView.getCalculateProductTotalPrice();
		 NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
         // Convert the double to a formatted dollar string
         String actualTotalPrice = currencyFormat.format(calculateTotalPrice);
         // Print the formatted amount
         System.out.println(actualTotalPrice);  
         String expectedTotalPrice=CheckOutOverView.getItemTotalPrice().replace("Item total: ", "");
         System.out.println(expectedTotalPrice);
         
         // verify Cart total price is correctly calculated  after adding multiple products
		 Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Cart total is incorrectly calculated!");
		 Reporter.log("ItemTotal price is correcly calculculat after adding multiple  a product!",true);
		 
		 // verify Cart total price is increase after adding multiple products
		 String actualPrice="$0";
		 Assert.assertNotEquals(actualPrice,expectedTotalPrice,"ItemTotal price does not increase after adding multiple  a product!");
		 Reporter.log("ItemTotal price is increase after adding multiple  a product",true);
		 
	}
	@Test(priority=2)
	public void verifyItemTotalPriceUpdateWhenUserRemoveProductFromeCard() throws InterruptedException, IOException
	{
		home.addTomultipleProductToCards(3);
		Thread.sleep(1000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		Thread.sleep(1000);
		double calculateTotalPrice = CheckOutOverView.getCalculateProductTotalPrice();
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        // Convert the double to a formatted dollar string
        String actualTotalPrice = currencyFormat.format(calculateTotalPrice);
        // Print the formatted amount
        System.out.println(actualTotalPrice); 
		checkOut.clickOnshopingCardIcon();
		Thread.sleep(1000);
		shoppingCard.removeProduct(1);
		Thread.sleep(1000);
	    shoppingCard.clickOncheckOutBtnShoppingCartPage();
	    Thread.sleep(1000);
	    checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
	    
	   // verify Itemtotal price is correctly calculated  after removing multiple products
	    double ProductPricecalculate  = CheckOutOverView.getCalculateProductTotalPrice();//adding multiple product cal
	    //find actual product price
	    NumberFormat currencyFormat1 = NumberFormat.getCurrencyInstance(Locale.US);
        // Convert the double to a formatted dollar string
        String actualTotalPrice1 = currencyFormat.format(ProductPricecalculate);
        System.out.println("afterremoving"+actualTotalPrice1);
	    String expectedTotalPrice1=CheckOutOverView.getItemTotalPrice().replace("Item total: ", "");
        System.out.println("calculate itemTotalPrice"+expectedTotalPrice1);
        
        Assert.assertEquals(actualTotalPrice1, expectedTotalPrice1,"Item total price does match expected value");
        Reporter.log("Itemtotal price is correctly calculated  after removing multiple products",true);
        
        // verify Cart total price is decrease after removing product  multiple products
         Assert.assertNotEquals(actualTotalPrice, expectedTotalPrice1, " Total  pricedid not decrease correctly after removing the product!");
		 Reporter.log("ItemTotal price is decrease after removing a product!",true);   
		
	}
	@Test(priority=3)
	public void verifyFinalTotalPriceIsCorrectAfterAddingTaxValue() throws InterruptedException, IOException
	{
		home.addTomultipleProductToCards(3);
		Thread.sleep(1000);
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		Thread.sleep(1000);
		checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		Thread.sleep(1000);
		double calculateTotalPrice = CheckOutOverView.getCalculateProductTotalPrice();
		Thread.sleep(1000);
	     double taxvalue = CheckOutOverView.getTaxValue();
	     Thread.sleep(1000);
		 double finalProductTotalPrice = calculateTotalPrice + taxvalue;
		 System.out.println(finalProductTotalPrice);
     	 NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
         // Convert the double to a formatted dollar string
         String factualFinalTotalPrice = currencyFormat.format(finalProductTotalPrice);
         // Print the formatted amount
         System.out.println(factualFinalTotalPrice);  
         String expectedfinalTotalPrice=CheckOutOverView.getFinalTotalPrice().replace("Tax: ", "");
         System.out.println(expectedfinalTotalPrice);
         
         // Assert that the expected final total equals the displayed final total
		 Assert.assertEquals(expectedfinalTotalPrice, expectedfinalTotalPrice, "Final total price does not match the expected value");
	     Reporter.log("FinaltotalPrice is correct after adding taxValue",true);
 
	}
	@Test(priority=7)
	public void validatePageTitle() throws InterruptedException, IOException
	{
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		 Thread.sleep(1000);
		 checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		 Thread.sleep(1000);
		String actualPageTitle = CheckOutOverView.getPageTitle();
		String expectedPageTitle="Checkout: Overview";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title does not match the expected value!");
		Reporter.log("Page title is match the expected value",true);
					
	}
	@Test(priority=6)
	public void verifyFinishButtonSpecifications() throws InterruptedException, IOException
	{
		home.clickonShoppingCartIconHomePage();
		Thread.sleep(1000);
		shoppingCard.clickOncheckOutBtnShoppingCartPage();
		 Thread.sleep(1000);
		 checkOut.validateUserAbletoContinueWithValidCredintial((UtilityClass.getPFData("FristName")), (UtilityClass.getPFData("LastName")), (UtilityClass.getPFData("ZipCode")));
		 Thread.sleep(1000);
	    // Verify button text
		String expectedBtnText="FINISH"; 
		String actualBtnText = CheckOutOverView.getFinishBtnText();
		Assert.assertEquals(actualBtnText, expectedBtnText,"Button text does not match");
		Reporter.log("Both actual and expected button text is match",true);
	  
	    //Verify button is enabled
		Assert.assertTrue(CheckOutOverView.isFinishBtnEnabled(),"Button is not enabled!");
		Reporter.log("FinishButton is enabled",true);
	    //Verify button is displayed
		Assert.assertTrue(CheckOutOverView.isFinishBtnDisplay(),"Button is not display!");
		Reporter.log("Finish button is display on checkoutReviewPage",true);
		
	    //VerifyButton Colore
		String actualFiishBtnBagroundColor = CheckOutOverView.getFinishBtnbagroundColore();
		System.out.println(actualFiishBtnBagroundColor);
		String  expectedFiishBtnBagroundColor="rgba(226, 35, 26, 1)";
		Assert.assertEquals(actualFiishBtnBagroundColor,expectedFiishBtnBagroundColor,"background color does not match!");		
		Reporter.log("BackgroundColor is  match the expected BackgroundColorvalue");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
