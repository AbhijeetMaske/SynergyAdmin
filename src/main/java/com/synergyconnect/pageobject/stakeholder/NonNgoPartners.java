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
	
	public void clickOnNonNgoPartners() {
		NonNgoPartners.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Non-Ngo Partners Successfully  ");

	}
	
	public void clickOnNonNgoPartner() {
		NonNgoPartner.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Non-Ngo Partner Successfully  ");

	}
	
	public void enterOrganizationName(String orgName) {
		OrganizationName.sendKeys(orgName);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name entered  :"+orgName);

	}
	
	public void clickOnPartnerCategory(String partnerCategory) {
		Select pt=new Select(PartnerCategory);
		pt.selectByVisibleText(partnerCategory);
		ExtentReportListener.getExtent().log(Status.PASS, "Partner Category Successfully  :"+partnerCategory);

	}
	
	public void enterCinNo(String cinNo) {
		CinNo.sendKeys(cinNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Cin Registration Number Entered  :"+cinNo);

	}
	
	public void enterContactPerson(String contactPerson) {
		ContactPerson.sendKeys(contactPerson);
		ExtentReportListener.getExtent().log(Status.PASS, "Contact Person Name: "+contactPerson);

	}
	
	public void enterMobileNo(String mobNo) {
		MobileNo.sendKeys(mobNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number Entered  :"+mobNo);

	}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "Email ID Entered  :"+emailId);

	}
	
	public void enterDepartment(String department) {
		Department.sendKeys(department);
		ExtentReportListener.getExtent().log(Status.PASS, "Department Entered  :"+department);

	}
	
	public void enterAddress(String address) {
		Address.sendKeys(address);
		ExtentReportListener.getExtent().log(Status.PASS, "Address Entered  :"+address);

	}
	
	public void enterCity(String city) {
		City.sendKeys(city);
		ExtentReportListener.getExtent().log(Status.PASS, "City Entered  :"+city);

	}
	
	public void enterPincode(String pincode) {
		Pincode.sendKeys(pincode);
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Non-Ngo Partners Successfully  :"+pincode);

	}
	
	public void clickOnCountry(String country) {
		Select c=new Select(Country);
		c.selectByVisibleText(country);
		ExtentReportListener.getExtent().log(Status.PASS, "Country Selected  :"+country);

	}
	
	public void clickOnState(String state) {
		Select s=new Select(State);
		s.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State Selected  :"+state);

	}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Submit Successfully  ");

	}
	

	
}
