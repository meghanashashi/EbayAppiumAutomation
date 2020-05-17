package framework;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumService {
	
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	private int port = 4723;
	protected static URL appiumServerURL;
	public static String primary,secondary;
	
	
	@BeforeSuite	
	public void startServer() {

		System.out.println("<------------------------Started Appium Service---------------------------------->");
		//Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", false);
		//cap.setCapability("relaxed-security", true);

		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		builder.withLogFile(new File (System.getProperty("user.home")+"\\AppiumServerLogs.txt"));
        builder.withIPAddress("127.0.0.1");
		builder.usingPort(port);


		builder.withArgument(GeneralServerFlag.RELAXED_SECURITY);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		//	if (!this.checkIfServerIsRunning(port)) {
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		appiumServerURL = service.getUrl();

		//	}
		//		else {
		//			System.out.println("Appium Server already running on Port - " + port);
		//		}
	}

	//	@AfterSuite
	//	public void stopServer() {
	//		service.stop();
	//	}


}
