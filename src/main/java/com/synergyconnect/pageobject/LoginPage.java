package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.utilities.ElementInteractionUtils;
import com.synergyconnect.utilities.ExtentReportListener;
import com.synergyconnect.utilities.ReadConfig;

public class LoginPage {
	ElementInteractionUtils EI;

	// constructor
	public LoginPage(WebDriver driver) {
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
	public void enterUserid() {
		ElementInteractionUtils.sendKeys(Userid, UserName);
		// ExtentReportListener.getExtent().log(Status.PASS, "User ID successfully
		// entered: " +config.getUserId());
	}

	public void enterPassword() {
		ElementInteractionUtils.sendKeys(Password, UserPassword);
	}

	public void clickOnLogin() {
		ElementInteractionUtils.click(Login);
		// ExtentReportListener.getExtent().log(Status.PASS, "Login button clicked
		// successfully.");
	}

	public String getHompageUrl() {
		String currentURL = BaseClass.getDriver().getCurrentUrl();
		boolean loginStatus = currentURL.contains("https://test30.synergyapps.in/");
		return currentURL;
	}

	public void synergyAdmin() {
		ElementInteractionUtils.click(NavBar);
		ElementInteractionUtils.click(synergyAdmin);
	}
}
