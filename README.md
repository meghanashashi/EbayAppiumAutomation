# EbayAppiumAutomation

1. Project is developed with Java, Appium, TestNG and Maven.

2. To start with execution of this project, provide device details in testNG.xml

3. Appium Service will be started automatically and app will be installed on the device.
4. Testcases are created under /src/test/java/TestCases.
5. Framework related classes are present under /src/main/java/framework.
6. BasePage contains all common/util functions required for this project.
7. Test data is read from external source file. Path: /PropertyFiles/InputData.properties
8. Logging is incorporated, to a file. To change the file location, modify log4j properties under /src/test/resources/
9. Extent Reports are used for reporting. On completion of execution, report will be generated in /ExtentReports/ebaytest.html
10. Screen rotation testing is covered.
