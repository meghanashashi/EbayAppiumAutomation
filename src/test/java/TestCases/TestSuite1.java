package TestCases;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;
import Pages.SearchPage;
import framework.BasePage;
import framework.Driver;

public class TestSuite1 extends Driver {
	
	Logger logger = LoggerFactory.getLogger(TestSuite1.class);

	Properties prop = BasePage.readInputData("PropertyFiles/InputData.properties");

	@Test
	//Test case to validate login is working
	public void validateLoginPage() throws InterruptedException {
		logger.info("Testcase started");
		logger.info("Inside validateLoginPage test case");
		LoginPage login = new LoginPage(aDriver);
		
		//Step 1 : Login to the application
		login.skipSignIn();

		Assert.assertTrue(login.isElementPresentOnScreen("amazon"));
		logger.info("Testcase successful");
	}

	@Test
	/* Test case to compare and validate item details in product search and product detail 
	screens */
	public void validateSearchResultInSearchPage() throws InterruptedException {
		logger.info("Testcase started");
		logger.info("Inside validateSearchResultInSearchPage test case");
		
		SearchPage searchPage = new SearchPage(aDriver);
		
		//Step 2: Search the item
		searchPage.searchItemInSearchBox(prop.getProperty("ItemName1"));
		
		//Step 3: Fetch the item details from product search screen for comparison
		List<String> itemValues_SearchPage = searchPage.get_brandName_Price_Description(Integer.valueOf(prop.getProperty("randomItemIndex")));
		
		//Step 4: Select random item from the list and navigate to product detail screen
		searchPage.selectAnItemFromSearchList();
		
		ProductPage productPage = new ProductPage(aDriver);
		
		//Step 5: Fetch item details from product details screen and compare/validate with that of product search screen
		Assert.assertTrue(productPage.get_Name_Price_Description().equals(itemValues_SearchPage));
		
		logger.info("Testcase successful");
		
	}
	
	
	@AfterSuite
	public void exit()
	{
		logger.debug("Inside exit function");
		quit();
	}

}
