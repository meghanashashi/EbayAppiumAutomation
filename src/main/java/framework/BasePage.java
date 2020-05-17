
package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	static Logger logger = LoggerFactory.getLogger(BasePage.class);

	protected AndroidDriver<AndroidElement> driver;
	protected WebDriverWait wait;

	public BasePage(AndroidDriver<AndroidElement> aDriver) {
		this.driver = aDriver;
		wait = new WebDriverWait(aDriver, 15);
	}

	protected void clickUsingTextContains(String txt) {
		logger.debug("Inside clickUsingTextContains function ");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + txt + "\")")).click();

	}

	public boolean isElementPresentOnScreen(String elementText) {

		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + elementText + "\")")))
				.isDisplayed();
	}

	protected void sendText(String text, String searchItemName) {
		logger.debug("Inside sendText function");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")")))
				.sendKeys(searchItemName);

	}

	public void pressKey(String keyEvent) {
		logger.debug("Inside pressKey function");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

	protected String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void scrollTo() {

		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int startx = (int) (height * 0.5);
		int endy = (int) (height * 0.2);
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(x, startx)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(x, endy)).release().perform();

	}

	public static Properties readInputData(String inputFilePath) {
		File file = new File(inputFilePath);
		System.out.println(file.getAbsolutePath());

		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		Properties properties = new Properties();

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());		}
		return properties;

	}

}
