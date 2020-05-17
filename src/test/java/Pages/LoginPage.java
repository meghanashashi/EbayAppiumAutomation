package Pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TestCases.TestSuite1;
import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage extends BasePage {

	Logger logger = LoggerFactory.getLogger(TestSuite1.class);

	public LoginPage(AndroidDriver<AndroidElement> driver) {

		super(driver);
	}

	// Mobile Elements
	String skipSignInBtnName = "com.amazon.mShop.android.shopping:id/skip_sign_in_button";

	/*
	 * This method will click on skipSginBtn
	 */
	public void skipSignIn() {
		logger.debug("Inside skipSignIn function");

		clickUsingTextContains("Skip");

	}

}
