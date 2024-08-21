package com.synergyconnect.pageobject.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class SubOrganizationList {
	public SubOrganizationList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	WebElement Edit;
	
	@FindBy(id="subOrgBtn")
	WebElement Add;
	
	@FindBy(id="subOrganizationName")
	WebElement OrgName;
	
	@FindBy(id="subIncorporationDate")
	WebElement IncorporationDate;
	
	@FindBy(xpath="(//td[text()='1'])[3]")
	WebElement DatePick;
	
	@FindBy(id="subShortName")
	WebElement ShortName;
	
	@FindBy(id="typeofSubOrg")
	WebElement TypeOfOrganization;
	
	@FindBy(id="subOrgType")
	WebElement OrgType;
	
	@FindBy(id="subCinNumber")
	WebElement CinNo;
	
	@FindBy(id="subMcaNumber")
	WebElement CsrRegNo;
	
	@FindBy(id="subPanNumber")
	WebElement PanNo;
	
	@FindBy(id="aboutSubOrganization")
	WebElement BriefIntro;
	
	@FindBy(id="subOrgContactPerson")
	WebElement Name;
	
	@FindBy(id="subOrgMobileNumber")
	WebElement MobNo;
	
	@FindBy(id="subOrgEmail")
	WebElement EmailId;
	
	@FindBy(id="subOrgAddressLine1")
	WebElement AddressL1;
	
	@FindBy(id="subOrgAddressLine2")
	WebElement AddressL2;
	
	@FindBy(id="subOrgCountry")
	WebElement Country;
	
	@FindBy(id="subOrgState")
	WebElement State;
	
	@FindBy(id="subOrgCity")
	WebElement City;
	
	@FindBy(id="subOrgPincode")
	WebElement Pincode;
	
	@FindBy(id="addSuborgBtn")
	WebElement addSubOrg;
	
}


