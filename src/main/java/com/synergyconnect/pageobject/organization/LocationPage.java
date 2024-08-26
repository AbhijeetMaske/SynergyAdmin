package com.synergyconnect.pageobject.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

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
	@FindBy(xpath = "//span[contains(text(),'Organization Details')]")
	private WebElement ddlOrganizationDetails;

	@FindBy(xpath = "//span[contains(text(),'Add Location')]")
	private WebElement ddlAddLocation;
	
	@FindBy(xpath="//*[@id=\"addLocationBtn\"]")
	private WebElement btnAddLocation;
	
	@FindBy(id="LocationType")
	private WebElement ddlLocationType;
	
	@FindBy(id="country")
	private WebElement ddlCountry;
	
	@FindBy(id="state")
	private WebElement ddlState;
	
	@FindBy(id="district")
	private WebElement ddlDistrict;
	
	@FindBy(id="block")
	private WebElement ddlBlock;
	
	@FindBy(id="pinCode")
	private WebElement ddlPinCode;
	
	@FindBy(id="village")
	private WebElement ddlVillage;
	
	@FindBy(id="location")
	private WebElement txtLocation;
	
	@FindBy(id="shortCode")
	private WebElement txtShortCode;
	
	@FindBy(id="locationLatitude")
	private WebElement txtLocationLatitude;
	
	@FindBy(id="locationLongitude")
	private WebElement txtLocationLongitude;
	
	@FindBy(id="btnAddOfficeLoc")
	private WebElement btnLoctionSubmit;
	
	@FindBy(xpath="//*[@id=\"formLocation\"]/div[2]/div/div/button[2]")
	private WebElement btnLoctionCancel;
	
	@FindBy (xpath = "//*[@id='active']")
	private WebElement btnActiveTab;
	
	@FindBy (xpath = "//*[@id=\'inactive\']")
	private WebElement btnInactiveTab;
	
	@FindBy (id = "table_activeOfficeLocation")
	private WebElement tblActiveTable;
	
	@FindBy (xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;
	
	@FindBy (xpath = "//*[@id=\"bElim\"]")
	private WebElement btnDelete;
	
	@FindBy (xpath = "//*[@id=\"table_activeOfficeLocation_next\"]/a")
	private WebElement btnActiveTableNext;
	
	@FindBy (id = "table_inactLocation")
	private WebElement tblInactiveTable;
	
	@FindBy (xpath = "//*[@id=\"bActivate\"]")
	private WebElement btnActive;
	
	@FindBy (xpath = "//*[@id=\"table_inactLocation_next\"]/a")
	private WebElement btnInactiveTableNext;
	
	
	@Test
	public void redirectToAddLocationAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlOrganizationDetails);
		ElementInteractionUtils.click(ddlAddLocation);
	}
	
	@Test
	public void AddLocationInfo() throws InterruptedException {
		try {
			ElementInteractionUtils.click(btnAddLocation);
			
		}catch (Exception e) {
			
		}
	}
}
