package com.synergyconnect.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.utilities.ElementInteractionUtils;
import com.synergyconnect.utilities.ReadConfig;

public class LoginPage {
	ElementInteractionUtils EI;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	public static WebDriver driver;
	// constructor
	public LoginPage(WebDriver webdriver) {
		driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
	}

	ReadConfig config = new ReadConfig();
	String UserName = config.getUserId();
	String UserPassword = config.getPassword();
	public static ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	// identify WebElements
	@FindBy(id = "username")
	WebElement Userid;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//*[@id=\"socialIntegratedPlatform\"]")
	WebElement NavBar;

	@FindBy(xpath = "//*[@id=\"productAdmin\"]")
	WebElement synergyAdmin;

	// identify Action on WebElement
	public void portalLogin() {
		logger.info("Attempting to log in with username: {}", UserName);
		try {
			ElementInteractionUtils.sendKeys(Userid, UserName);
			logger.debug("Entered username");
			ElementInteractionUtils.sendKeys(Password, UserPassword);
			logger.debug("Entered password");
			ElementInteractionUtils.click(Login);
			logger.info("Clicked on the Login button");
			logger.info("Login action performed successfully.");
		} catch (Exception e) {
			logger.error("Error while attempting to log in: ", e);
			throw e;
		}
	}

	public String getHompageUrl() {
		logger.info("Attempting to retrieve current homepage URL");
		String currentURL = "";
		String expectedURL = config.getBaseUrl();
		try {
			currentURL = driver.getCurrentUrl();
			boolean loginStatus = currentURL.contains(expectedURL);
			Assert.assertTrue(loginStatus, "Current URL does not match the expected URL");
			logger.info("Successfully retrieved homepage URL: {}", currentURL);
		} catch (AssertionError ae) {
			logger.error("Assertion failed - expected URL {} but found {}: ", expectedURL, currentURL, ae);
			throw ae;
		} catch (Exception e) {
			logger.error("Error in verifying current URL: ", e);
			Assert.fail("Error in verifying current URL: " + e.getMessage());
		}
		return currentURL;
	}

	public void synergyAdmin() {
		logger.info("Navigating to Synergy Admin page");
		try {
			ElementInteractionUtils.click(NavBar);
			logger.debug("Clicked on NavBar");
			ElementInteractionUtils.click(synergyAdmin);
			logger.info("Clicked on Synergy Admin");
			logger.info("Successfully navigated to Synergy Admin page.");
		} catch (Exception e) {
			logger.error("Error while redirecting to Synergy Admin: ", e);
			throw e;
		}
	}
}
