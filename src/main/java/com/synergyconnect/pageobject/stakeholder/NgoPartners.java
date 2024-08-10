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
	
	public void enterNgoName(String ngoName) {
		NgoName.sendKeys(ngoName);
		ExtentReportListener.getExtent().log(Status.PASS, "NGO Name entered :"+ngoName);

	}
	
	public void clickOnNgoSearch() {
		NgoSearch.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on NGO Search Successfully");

	}
	
	public void clickOnNgoUpload() {
		NgoUpload.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Upload Logo Successfully ");

	}
	
	public void enterOrgName(String orgName) {
		OrgName.sendKeys(orgName);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name entered :"+orgName);

	}
	
	public void clickOnEntityType(String entityType) {
		Select et=new Select(EntityType);
		et.selectByVisibleText(entityType);
		ExtentReportListener.getExtent().log(Status.PASS, "Entity Type Selected :"+entityType);

	}
	
	public void enterCinRegNo(String cinRegNo) {
		CinRegNo.sendKeys(cinRegNo);
		ExtentReportListener.getExtent().log(Status.PASS, "CIN Registration Number entered :"+cinRegNo);

	}
	
	public void enterCsrRegNo(String csrRegNo) {
		CsrRegNo.sendKeys(csrRegNo);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR Registration Number entered :"+csrRegNo);

	}
	
	public void clickOnCategory(String category) {
		Select c=new Select(Category);
		c.selectByVisibleText(category);
		ExtentReportListener.getExtent().log(Status.PASS, "Category Selected :"+category);

	}
	
	public void enterLocation(String location) {
		Location.sendKeys(location);
		ExtentReportListener.getExtent().log(Status.PASS, "Location entered :"+location);

	}
	
	public void enterContactPerson(String contactPerson) {
		ContactPerson.sendKeys(contactPerson);
		ExtentReportListener.getExtent().log(Status.PASS, "Contact Person Name entered :"+contactPerson);

	}
	
	public void enterMobileNo(String mobileNo) {
		MobNo.sendKeys(mobileNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number entered :"+mobileNo);

	}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "EmailId  entered :"+emailId);

	}
	
	public void clickOnCountry(String country) {
		Select c=new Select(Country);
		c.selectByVisibleText(country);
		ExtentReportListener.getExtent().log(Status.PASS, "Country Selected :"+country);

	}
	
	public void clickOnState(String state) {
		Select s=new Select(State);
		s.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State Selected :"+state);

	}
	
	public void clickOnDistrict(String district) {
		Select d=new Select(District);
		d.selectByVisibleText(district);
		ExtentReportListener.getExtent().log(Status.PASS, "District Selected :"+district);

	}
	
	public void enterAddress(String address) {
		Address.sendKeys(address);
		ExtentReportListener.getExtent().log(Status.PASS, "Address is entered :"+address);

	}
	
	public void enterPincode(String pincode) {
		Pincode.sendKeys(pincode);
		ExtentReportListener.getExtent().log(Status.PASS, "Pincode entered :"+pincode);

	}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Submit clicked Successfully ");

	}
	
	

}
