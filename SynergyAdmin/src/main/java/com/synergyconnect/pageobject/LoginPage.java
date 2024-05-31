package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.utilities.ExtentReportListener;

public class LoginPage {
	//create object of WebDriver
//	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);

	}
	
	//identify WebElements
	@FindBy(id="username")
	WebElement Userid;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement Login;
	
	//identify Action on WebElement
	public void enterUserid(String UserId) {
		Userid.sendKeys(UserId);
		ExtentReportListener.getExtent().log(Status.PASS, "User id entered :"+UserId);
	}
	
	public void enterPassword(String password) {
		Password.sendKeys(password);
		ExtentReportListener.getExtent().log(Status.PASS, "Pasword entered :"+password);
	}
	
	public void clickOnLogin() {
		Login.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Login Clicked Successfully");
	}
	
	public String getHompageUrl() {
		String urFetched =BaseClass.getDriver().getCurrentUrl();
		ExtentReportListener.getExtent().log(Status.PASS, "URL fetched "+urFetched);
		return urFetched;
	}

	

}
