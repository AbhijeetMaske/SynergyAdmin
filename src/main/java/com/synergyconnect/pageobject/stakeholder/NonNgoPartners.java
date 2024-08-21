package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class NonNgoPartners {
public NonNgoPartners(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="goalset02-tab")
	WebElement NonNgoPartners;
	
	@FindBy(id="btnPartner")
	WebElement NonNgoPartner;
	
	@FindBy(id="partnerName")
	WebElement OrganizationName;
	
	@FindBy(id="nonNgoPartnerCategory")
	WebElement PartnerCategory;
	
	@FindBy(id="nonNgoCinRegistrationNo")
	WebElement CinNo;
	
	@FindBy(id="nonNgoContactPerson")
	WebElement ContactPerson;
	
	@FindBy(id="nonNgoContactNumber")
	WebElement MobileNo;
	
	@FindBy(id="nonNgoEmail")
	WebElement EmailId;
	
	@FindBy(id="nonNgoDepartment")
	WebElement Department;
	
	@FindBy(id="nonNgoAddredd")
	WebElement Address;
	
	@FindBy(id="nonNgoCity")
	WebElement City;
	
	@FindBy(id="nonNgoZipcode")
	WebElement Pincode;
	
	@FindBy(id="nonNgoCountry")
	WebElement Country;
	
	@FindBy(id="nonNgoState")
	WebElement State;
	
	@FindBy(id="nonngoupdateBtn")
	WebElement Submit;

	
}
