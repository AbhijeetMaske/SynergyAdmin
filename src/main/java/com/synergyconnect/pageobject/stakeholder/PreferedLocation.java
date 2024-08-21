package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class PreferedLocation {
public PreferedLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="preferred-location-tab")
	WebElement  PreferedLocation;
	
	@FindBy(id="preferredCountry")
	WebElement PreferedCountry;
	
	@FindBy(id="preferredState")
	WebElement  State;
	
	@FindBy(id="donorPreferredLocationButton")
	WebElement  Submit;

}
