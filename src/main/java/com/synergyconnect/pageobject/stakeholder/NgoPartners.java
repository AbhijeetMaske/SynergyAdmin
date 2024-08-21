package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class NgoPartners {
public NgoPartners(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="ngoname")
	WebElement NgoName;
	
	@FindBy(id="ngosrch")
	WebElement NgoSearch;
	
	@FindBy(xpath="//label[@for='ngologoUpload']")
	WebElement NgoUpload;
	
	@FindBy(id="organizationName")
	WebElement OrgName;
	
	@FindBy(id="registeredWith")
	WebElement EntityType;
	
	@FindBy(id="cinRegistrationNo")
	WebElement CinRegNo;
	
	@FindBy(id="mcaCsrRegistrationNo")
	WebElement CsrRegNo;
	
	@FindBy(id="category")
	WebElement Category;
	
	@FindBy(id="addngoLocation")
	WebElement Location;
	
	@FindBy(id="contactPerson")
	WebElement ContactPerson;
	
	@FindBy(id="contactNumber")
	WebElement MobNo;
	
	@FindBy(id="contactEmailId")
	WebElement EmailId;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(id="state")
	WebElement State;
	
	@FindBy(id="district")
	WebElement District;
	
	@FindBy(id="address")
	WebElement Address;
	
	@FindBy(id="pinCode")
	WebElement Pincode;
	
	@FindBy(id="ngoupdateBtn")
	WebElement Submit;

}
