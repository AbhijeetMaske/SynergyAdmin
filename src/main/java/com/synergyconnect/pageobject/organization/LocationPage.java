package com.synergyconnect.pageobject.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.common.Config;
import com.synergyconnect.utilities.AlertUtils;
import com.synergyconnect.utilities.ElementInteractionUtils;
import com.synergyconnect.utilities.ExtentReportListener;
import com.synergyconnect.utilities.ReadConfig;
import com.synergyconnect.utilities.WebElementLocators;

public class LocationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	WebElementLocators WL;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(LocationPage.class);
	ReadConfig readconfig = new ReadConfig();
	Config config = new Config();
	
	public LocationPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		WL = new WebElementLocators(driver);
		AU = new AlertUtils(driver);
	}
	
	@FindBy(xpath="//*[@id=\"addLocationBtn\"]")
	private WebElement btnLocation;
	
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
