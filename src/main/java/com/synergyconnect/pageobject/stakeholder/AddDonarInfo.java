package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class AddDonarInfo {
public AddDonarInfo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="btnDonor")
	WebElement Donar;
	
	@FindBy(id="donorOrgName")
	WebElement OrganizationName;

	@FindBy(id="donorShortCode")
	WebElement ShortCode;
	
	@FindBy(id="donorCategory")
	WebElement DonarCategory;
	
	@FindBy(id="donorSource")
	WebElement Source;
	
	@FindBy(id="donorPAN")
	WebElement Pan;
	
	@FindBy(id="donorOnboardDate")
	WebElement OnboardDate;
	
	@FindBy(xpath="(//td[text()='4'])[2]")
	WebElement DatePicker;
	
	@FindBy(id="donorCsrActivity")
	WebElement CsrActivity;
	
	@FindBy(id="donorFundType")
	WebElement FundType;
	
	@FindBy(id="donorOwner")
	WebElement RelationshipManager;
	
	@FindBy(xpath="(//input[@id='citizen'])[1]")
	WebElement IndianCitizen;
	
	@FindBy(id="donorAddress")
	WebElement Address;
	
	@FindBy(id="donorCountry")
	WebElement Country;
	
	@FindBy(id="donorState")
	WebElement State;
	
	@FindBy(id="donorCity")
	WebElement City;
	
	@FindBy(id="donorPincode")
	WebElement Pincode;
	
	@FindBy(id="primaryContact")
	WebElement MobileNo;
	
	@FindBy(id="primaryEmailId")
	WebElement EmailId;
	
	@FindBy(id="submitDonorBtn")
	WebElement Submit;	
	
	
}
