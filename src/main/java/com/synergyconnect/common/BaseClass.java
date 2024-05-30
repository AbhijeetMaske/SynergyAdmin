package com.synergyconnect.common;

import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.synergyconnect.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	protected String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger Logger;
	public static ThreadLocal<WebDriver> driverObjcet = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driverObjcet.get();
	}

	@BeforeMethod
	public void setup(Method method) {
System.out.println("@Before Method : "+method.getName());
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			option.setBrowserVersion("125");
			driver = new ChromeDriver(option);
			break;
		default:
			driver = null;
			break;
		}
		driverObjcet.set(driver);
		// implicit wait of 10 second
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging
		Logger = LogManager.getLogger("SynergyConnect");
	}

	@AfterMethod
	public void tearDown(Method method) {
		System.out.println("@After Method : "+method.getName());
		getDriver().close();
		getDriver().quit();
	}


}
