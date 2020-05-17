package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchPage extends BasePage {

	Logger logger = LoggerFactory.getLogger(SearchPage.class);

	static List<AndroidElement> descList = new ArrayList<>();
	static List<AndroidElement> priceList = new ArrayList<>();

	public SearchPage(AndroidDriver<AndroidElement> aDriver) {
		super(aDriver);
	}

	public void searchItemInSearchBox(String itemName) {
		logger.debug("Inside searchItemInSearchBox function ");
		clickUsingTextContains("Search");
		sendText("Search", itemName);
		pressKey("Enter");

	}

	public void selectAnItemFromSearchList() throws InterruptedException {
		logger.debug("Inside selectAnItemFromSearchList function ");
		TimeUnit.SECONDS.sleep(7);
		clickOnRandomItem("com.amazon.mShop.android.shopping:id/item_title", 1);

	}

	public void clickOnRandomItem(String locator, int index) {
		logger.debug("Inside clickOnRandomItem function");
		descList = driver.findElements(By.id(locator));
		descList.get(index).click();
	}

	public List<String> get_brandName_Price_Description(int index) {
		logger.debug("Inside get_brandName_Price_Description function");
		descList = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/item_title"));
		priceList = driver.findElements(By.xpath(
				"//*[@resource-id=\"com.amazon.mShop.android.shopping:id/rs_results_styled_price_v2\"]//*[@class=\"android.widget.TextView\"]"));

		String brandName = descList.get(index).getText().split("[0-9]")[0];
		String description = descList.get(index).getText().split(brandName)[1];
		String price = priceList.get(index).getText().replaceAll(" .*", "").substring(1);
		
		logger.debug("brandName---"+brandName);
		logger.debug("description---"+description);
		logger.debug("price---"+price);
		
		List<String> itemValues = new ArrayList<String>();
		itemValues.add(brandName);
		itemValues.add(description);
		itemValues.add(price);

		return itemValues;
	}

}
