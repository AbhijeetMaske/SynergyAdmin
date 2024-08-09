package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class Organization {
	
public Organization(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	WebElement Edit;
	
	@FindBy(id="organizationName")
	WebElement OrganizationName;
	
	@FindBy(id="establishedOn")
	WebElement IncorporationDate;
	
	@FindBy(xpath="//td[text()='15']")
	WebElement DatePicker;
	
	@FindBy(xpath="//input[@placeholder='Enter Short Name']")
	WebElement ShortName;
	
	@FindBy(id="registeredWith")
	WebElement EntityType;
	
	@FindBy(id="orgType")
	WebElement ExEntityType;
	
	@FindBy(id="cinRegistrationNo")
	WebElement CinNo;
	
	@FindBy(id="crn")
	WebElement CRN;
	
	@FindBy(id="mcaNO")
	WebElement CsrRegNo;
	
	@FindBy(id="mcaNumber")
	WebElement ExCsrRegNo;
	
	@FindBy(id="entitypanNo")
	WebElement EntityPanNo;
	
	@FindBy(xpath="//label[text()='Email ID']")
	WebElement ExPanNo;
	
	@FindBy(id="organizationContactPerson")
	WebElement ContactPerson;
	
	@FindBy(id="organizationContactPersonContact")
	WebElement MobileNo;
	
	@FindBy(id="contactEmailId")
	WebElement EmailId;
	
	@FindBy(id="emailID")
	WebElement ExEmailId;
	
	@FindBy(id="address.location")
	WebElement AddressL1;
	
	@FindBy(id="address.locationII")
	WebElement AddressL2;
	
	@FindBy(id="address.village")
	WebElement City;
	
	@FindBy(id="address.pinCode")
	WebElement Pincode;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(id="state")
	WebElement State;
	
	@FindBy(xpath="//label[@for='organizationLogo']")
	WebElement UploadLogo;
	
	@FindBy(id="aboutOrganization")
	WebElement BriefDiscription;
	
	@FindBy(xpath="//button[@id='orgFormSubmitButton']")
	WebElement Submit;
	
	
	public void clickOnEdit() {
		Edit.click();
	}
	
	public void enterOrganizationName(String OrgName) {
		OrganizationName.clear();
		OrganizationName.sendKeys(OrgName);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name entered :"+OrgName);

	}
	
	public void clickOnIncorporationDate() {
		IncorporationDate.click();
	}
	public void DatePicker() {
		DatePicker.click();
	}
	
	public void enterShortName(String ShrtName) {
		ShortName.clear();
		ShortName.sendKeys(ShrtName);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Name entered :"+ShrtName);

	}
	
	public void clickOnEntityType(String entityType) {
		Select et=new Select(EntityType);
		et.selectByVisibleText(entityType);
		ExtentReportListener.getExtent().log(Status.PASS, "Entity type selected :"+entityType);

	}
	public String getEntityTypeText() {
		return ExEntityType.getText();

	}
	
	
	public void enterCinNo(String cinNo) {
		CinNo.clear();
		CinNo.sendKeys(cinNo);
		ExtentReportListener.getExtent().log(Status.PASS, "CinNo entered :"+cinNo);

	}
	
	public void enterCRN(String crn) {
		CRN.clear();
		CRN.sendKeys(crn);
		ExtentReportListener.getExtent().log(Status.PASS, "CRN entered :"+crn);

	}
	
	public void enterCsrRegNo(String csrRegNo) {
		CsrRegNo.clear();
		CsrRegNo.sendKeys(csrRegNo);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR registration Number entered :"+csrRegNo);

	}
	public String getCSRText() {
		return ExCsrRegNo.getText();

	}
	public String getCINNotext() {
		return CinNo.getText();

	}
	public void enterEntityPanNo(String panNo) {
		EntityPanNo.clear();
		EntityPanNo.sendKeys(panNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Entity Pan Number entered :"+panNo);

	}
	public String getPanNo() {
		return ExPanNo.getText();
	}
	
	public void enterContactPerson(String contactPerson) {
		ContactPerson.clear();
		ContactPerson.sendKeys(contactPerson);
		ExtentReportListener.getExtent().log(Status.PASS, "Contact Person name entered :"+contactPerson);

	}
	
	public void enterMobileNo(String mobileNo) {
		MobileNo.clear();
		MobileNo.sendKeys(mobileNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number entered :"+mobileNo);
		
		
	}
	
	public void enterEmailId(String emailId) {
		EmailId.clear();
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "Email Id entered :"+emailId);
		

	}
	public String getEmailIdText() {
		return ExEmailId.getText();

	}
	
	
	
	public void enterAddressL1(String addressL1) {
		AddressL1.clear();
		AddressL1.sendKeys(addressL1);
		ExtentReportListener.getExtent().log(Status.PASS, "Address L1 is entered :"+addressL1);

	}
	
	public void enterAddressL2(String addressL2) {
		AddressL2.clear();
		AddressL2.sendKeys(addressL2);
		ExtentReportListener.getExtent().log(Status.PASS, "Address L2 is entered :"+addressL2);

	}
	
	public void enterCity(String city) {
		City.clear();
		City.sendKeys(city);
		ExtentReportListener.getExtent().log(Status.PASS, "City Name entered :"+city);

	}
	
	public void enterPincode(String pinCode) {
		Pincode.clear();
		Pincode.sendKeys(pinCode);
		ExtentReportListener.getExtent().log(Status.PASS, "Pin Code entered :"+pinCode);

	}
	
	public void clickOnCountry(String country) {
		Select c=new Select(Country);
		c.selectByVisibleText(country);
		ExtentReportListener.getExtent().log(Status.PASS, "Country selected :"+country);

	}
	
	public void clickOnState(String state) {
		Select s=new Select(State);
		s.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State selected :"+state);

	}
	
	public void clickOnUploadLogo() {
		UploadLogo.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Upload logo successfully ");

	}
	
	public void enterBriefDiscription(String briefDiscrp) {
		BriefDiscription.clear();
		BriefDiscription.sendKeys(briefDiscrp);
		ExtentReportListener.getExtent().log(Status.PASS, "Brief discription Entered :"+briefDiscrp);

	}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Submit clicked successfully ");

	}









}
