package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
//WebDriver ldriver;
	
	public AdminHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}	
	@FindBy(xpath="//span[text()='Organization Details']")
	WebElement OrganizationDetails;
	
	
	@FindBy(xpath="//span[text()='Add Organization Info']")
	WebElement AddOrganizationInfo;
	
	@FindBy(xpath="//span[text()='Add Location']")
	WebElement AddLocation;
	
	public void clickOnOrganizationDetails() {
		OrganizationDetails.click();
		}
	
	public void clickOnAddOrganizationInfo() {
		AddOrganizationInfo.click();
	}
	
	public void clickOnAddLocation() {
		AddLocation.click();
	}
	
	
}
