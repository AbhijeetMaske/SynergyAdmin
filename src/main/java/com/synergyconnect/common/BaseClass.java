package com.synergyconnect.common;

import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.synergyconnect.utilities.ReadConfig;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    protected String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);
    public static ThreadLocal<WebDriver> driverObject = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return driverObject.get();
    }

    @BeforeMethod
    public void setup(Method method) {
        System.out.println("@Before Method : " + method.getName());
        logger.info("Setting up browser for test method: " + method.getName());

        switch (browser.toLowerCase()) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set the path to your ChromeDriver
                ChromeOptions options = new ChromeOptions();
                options.setBrowserVersion("125");
                driver = new ChromeDriver(options);
                break;
            default:
                logger.error("Unsupported browser: " + browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driverObject.set(driver);

        // Set implicit wait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Maximize the browser window
        getDriver().manage().window().maximize();
        
        logger.info("Browser setup completed for test method: " + method.getName());
    }

    @AfterMethod
    public void tearDown(Method method) {
        System.out.println("@After Method : " + method.getName());
        logger.info("Tearing down browser for test method: " + method.getName());
        
        if (getDriver() != null) {
            getDriver().quit();
        }
        
        driverObject.remove();
        logger.info("Browser teardown completed for test method: " + method.getName());
    }
}
