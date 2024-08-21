package com.synergyconnect.pageobject.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class AddLocation {
//WebDriver ldriver;
	
	public AddLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@id='addLocationBtn']")
	WebElement Location;
	
	@FindBy(id="LocationType")
	WebElement LocationType;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="district")
	WebElement district;
	
	@FindBy(id="block")
	WebElement block;
	
	@FindBy(id="pinCode")
	WebElement pinCode;
	
	@FindBy(id="village")
	WebElement village;
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(id="shortCode")
	WebElement shortCode;
	
	@FindBy(id="locationLatitude")
	WebElement locationLatitude;
	
	@FindBy(id="locationLongitude")
	WebElement locationLongitude;
	
	@FindBy(id="btnAddOfficeLoc")
	WebElement submit;
	
}
