package com.synergyconnect.pageobject.organization;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

	@FindBy(xpath = "//*[@id=\"addLocationBtn\"]")
	private WebElement btnAddLocation;
		
	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement btnFilter;
	
	@FindBy (xpath ="//*[@id=\"Office\"]")
	private WebElement chkOfficeFilter;
	
	@FindBy (xpath ="//*[@id=\"Factory\"]")
	private WebElement chkFactoryFilter;
	
	@FindBy (xpath ="//*[@id=\"project\"]")
	private WebElement chkProjectFilter;
	
	@FindBy(id = "LocationType")
	private WebElement ddlLocationType;

	@FindBy(id = "country")
	private WebElement ddlCountry;

	@FindBy(id = "state")
	private WebElement ddlState;

	@FindBy(id = "district")
	private WebElement ddlDistrict;

	@FindBy(xpath = "//*[@id=\"block\"]")
	private WebElement ddlBlock;

	@FindBy(id = "pinCode")
	private WebElement ddlPinCode;

	@FindBy(id = "village")
	private WebElement ddlVillage;

	@FindBy(id = "location")
	private WebElement txtLocation;

	@FindBy(id = "shortCode")
	private WebElement txtShortCode;

	@FindBy(id = "locationLatitude")
	private WebElement txtLocationLatitude;

	@FindBy(id = "locationLongitude")
	private WebElement txtLocationLongitude;

	@FindBy(id = "btnAddOfficeLoc")
	private WebElement btnLoctionSubmit;

	@FindBy(xpath = "//*[@id=\"formLocation\"]/div[2]/div/div/button[2]")
	private WebElement btnLoctionCancel;

	@FindBy(xpath = "//*[@id='active']")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\'inactive\']")
	private WebElement btnInactiveTab;

	@FindBy(id = "table_activeOfficeLocation")
	private WebElement tblActiveTable;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"table_activeOfficeLocation_next\"]/a")
	private WebElement btnActiveTableNext;

	@FindBy(id = "table_inactLocation")
	private WebElement tblInactiveTable;

	@FindBy(xpath = "//*[@id=\"bActivate\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"table_inactLocation_next\"]/a")
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
			ElementInteractionUtils.selectByVisibleText(ddlLocationType, "Office");
			ElementInteractionUtils.selectByVisibleText(ddlCountry, "India");
			ElementInteractionUtils.selectByVisibleText(ddlState, "Maharashtra");
			ElementInteractionUtils.selectByVisibleText(ddlDistrict, "Beed");
			ElementInteractionUtils.selectByVisibleText(ddlBlock, "Bid");
			ElementInteractionUtils.selectByVisibleText(ddlPinCode, "431122");
			ElementInteractionUtils.selectByVisibleText(ddlVillage, "Court road");
			ElementInteractionUtils.sendKeys(txtLocation, "Dist Beed");
			ElementInteractionUtils.sendKeys(txtShortCode, "MHBEED");
			ElementInteractionUtils.sendKeys(txtLocationLatitude, "19.0000");
			ElementInteractionUtils.sendKeys(txtLocationLongitude, "27.0000");
			ElementInteractionUtils.click(btnLoctionSubmit);
			String SubmitToasterMessage = AU.getToasterText();
			Assert.assertEquals(SubmitToasterMessage, "Record already exists");
			ElementInteractionUtils.click(btnLoctionCancel);
		} catch (Exception e) {
			logger.error("failed to add location details in form: " + e);
		}
	}

	@Test
	public void verifyAddedLocation() {
		try {
			Map<Integer, String> lookupValues = new HashMap<>();
			lookupValues.put(2, "Office");
			lookupValues.put(3, "Maharashtra");
			lookupValues.put(4, "Beed");
			lookupValues.put(5, "Bid");
			lookupValues.put(6, "431122");
			lookupValues.put(7, "Court road");
			lookupValues.put(8, "DistBeed");
			lookupValues.put(10, "19.0000");
			lookupValues.put(11, "27.0000");
			boolean result = ElementInteractionUtils.verifyTableData("table_activeOfficeLocation", 9, "MHBEED",
					btnActiveTableNext, lookupValues);
			Assert.assertTrue(result, "Added location data NOT found in the table.");
		} catch (AssertionError ae) {
			logger.error("Assertion failed while verifying added location: ", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("Error while verifying added location: ", e);
			Assert.fail("Error while verifying added location: " + e.getMessage());
		}
	}
	
	@Test
	public void verifyLocationFilters() {
		try {
			ElementInteractionUtils.click(btnFilter);
			ElementInteractionUtils.click(chkOfficeFilter);
			boolean officeFilterResult =ElementInteractionUtils.verifyTextInTable("table_activeOfficeLocation", 2, "Project", btnActiveTableNext);
			Assert.assertFalse(officeFilterResult, "Location type = project data found in the table for office filter.");
			ElementInteractionUtils.pause(500);
			ElementInteractionUtils.scrollToElement(btnFilter);
			ElementInteractionUtils.click(chkOfficeFilter);
			
			ElementInteractionUtils.click(chkProjectFilter);
			boolean projectFilterResult =ElementInteractionUtils.verifyTextInTable("table_activeOfficeLocation", 2, "office", btnActiveTableNext);
			Assert.assertFalse(projectFilterResult, "Location type = office data found in the table for project filter.");
			
		} catch (Exception e) {
			logger.error("Error while verifying added location: ", e);
			Assert.fail("Error while verifying added location: " + e.getMessage());
		}
	}
}
