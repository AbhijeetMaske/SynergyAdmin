package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppDriver {
	
	public AppDriver(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	//Locator
	@FindBy (xpath="//body/div[@id='app']/div[1]/div[1]/nav[1]/div[1]/div[1]/a[1]")
	WebElement appdriver;
	
	@FindBy (xpath = "//*[@id=\"adminproduct\"]/a/span")
	WebElement adminModule;
	
	//Method
	public void appDriverMenu() {
		appdriver.click();
	}
	
	public void adminModule() {
		adminModule.click();
	}
}
