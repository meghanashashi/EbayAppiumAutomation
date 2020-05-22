package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductPage extends BasePage {
	
	Logger logger = LoggerFactory.getLogger(ProductPage.class);

	static List<AndroidElement> descList = new ArrayList<>();
	static List<AndroidElement> priceList = new ArrayList<>();

	public ProductPage(AndroidDriver<AndroidElement> aDriver) {
		super(aDriver);
	}

	public List<String> get_Name_Price_Description() throws InterruptedException {
		
		logger.debug("Inside get_Name_Price_Description function ");
		
		TimeUnit.SECONDS.sleep(5);
		
		String brandName = getText(By.xpath("//*[@resource-id=\"title_feature_div\"]//*[@class=\"android.view.View\"]"),0).split("[0-9]")[0];
		String description =getText(By.xpath("//*[@resource-id=\"title_feature_div\"]//*[@class=\"android.view.View\"]"),0) .split(brandName)[1];
		String price = getText(By.xpath("//*[@resource-id=\"atfRedesign_priceblock_priceToPay\"]//*[@class=\"android.widget.EditText\"]"),0).split(" ")[1];
		
		System.out.println("brandName----"+brandName+"description-----"+description+"price-----"+price);
		
		logger.debug("brandName---"+brandName);
		logger.debug("description---"+description);
		logger.debug("price---"+price);
		
		
		List<String> itemValues = new ArrayList<String>();
		itemValues.add(brandName);
		itemValues.add(description);
		itemValues.add(price);
		
		scrollTo();
		
		return itemValues;

	}

	public void addToCart() {
		scrolltoElement("Add to Cart");
		clickUsingTextContains("Add to Cart");
		Assert.assertTrue(getText(By.xpath("//*[@text=\"Added to cart\"]"), 0).equals("Added to cart"));
		
	}

}
