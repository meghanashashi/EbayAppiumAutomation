# EbayAppiumAutomation

This project has been developed to automate Ebay application testing on Android platform using Java, Appium, TestNG and Maven.

# Steps to run the application:

1. Install Appium Server (CLI). Follow instructions on [Appium Installation Help](http://appium.io/docs/en/about-appium/getting-started/). Appium Server need not be started externally, it is handled in the code itself.

2. Install Android SDK (Command line tools). Follow instructions on [Android Installation Help](https://developer.android.com/studio/?gclid=CjwKCAjwwYP2BRBGEiwAkoBpAohuHRSwpwUk11WkmX7U1dBifIror9wPrmD_xfqMJVCdfkNqB-nSbhoCFyMQAvD_BwE&gclsrc=aw.ds)

3. Connect your android device and verify connectivity.

4. Update testng.xml with android device details (Device Name, UDID and Platform version).

5. Run the below command on Command Prompt.

```sh
mvn clean install
```
6. On completion of execution, test report will be generated in [ebaytest.html file](https://github.com/meghanashashi/EbayAppiumAutomation/blob/master/ExtentReports/ebaytest.html)

 ![image](https://github.com/meghanashashi/EbayAppiumAutomation/blob/master/images/Report.png)

7. Log files 

# App Design

1. Testcases can be [found here](https://github.com/meghanashashi/EbayAppiumAutomation/tree/master/src/test/java/TestCases)

2. Code for application framework can be [found here](https://github.com/meghanashashi/EbayAppiumAutomation/tree/master/src/main/java/framework)

3. [BasePage](https://github.com/meghanashashi/EbayAppiumAutomation/tree/master/src/main/java/framework/BasePage.java) contains all common/util functions used across this project.

4. Test data is read from [external source file](https://github.com/meghanashashi/EbayAppiumAutomation/blob/master/PropertyFiles/InputData.properties)

5. Logging is implemented using slf4j/log4j. Logs are written into a local file. Hence,t o change the file location, modify [log4j.properties](https://github.com/meghanashashi/EbayAppiumAutomation/blob/master/src/test/resources/log4j.properties)

6. Extent Reports is used for reporting functionality.


# Scenarios covered

  - # Login Validation
      This testcase skips the sign in and logs in to the application, verifies whether user is able to navigate to home page.
      
  - # Item Details Validation
      1. An item is searched and details (brand name, price, description) are read from Search results page.
      2. After navigating to product details page, again brand name, price and description are read.
      3. Both the set of values are compared and verified if they are equal.
      4. Scrolling action is incorporated in this testcase for demonstration.
      
  - # Screen Rotation Validation
      This testcase checks the present screen orientation, rotates it and verifies if screen orientation is changed.
