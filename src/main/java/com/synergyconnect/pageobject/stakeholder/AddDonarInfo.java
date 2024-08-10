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
						
		
	
	
	public void clickOnDonar() {
		Donar.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Donar Successfully ");

		}
	
	public void enterOrganizationName(String organizationName) {
		OrganizationName.sendKeys(organizationName);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name Entered :"+organizationName);

		}
	
	public void enterShortCode(String shortCode) {
		ShortCode.sendKeys(shortCode);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Code Entered :"+shortCode);

		}
	
	public void clickOnDonarCategory(String donarCategory) {
		Select dc=new Select(DonarCategory);
		dc.selectByVisibleText(donarCategory);
		ExtentReportListener.getExtent().log(Status.PASS, "Donar Category selected :"+donarCategory);

		}
	
	public void clickOnSource(String source) {
		Select s=new Select(Source);
		s.selectByVisibleText(source);
		ExtentReportListener.getExtent().log(Status.PASS, "Source is selected :"+source);

		}
	
	public void enterPanNo(String panNo) {
		Pan.sendKeys(panNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Pan Number Entered :"+panNo);

		}
	
	public void clickOnBoardDate() {
		OnboardDate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Clicked on Calender  :");

		}
	
	public void clickOnDatePicker() {
		DatePicker.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Date Picked Successfully ");

		}
	
	public void clickOnCsrActivity(String csrActivity) {
		Select ca=new Select(CsrActivity);
		ca.selectByVisibleText(csrActivity);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR Activity selected :"+csrActivity);

		}
	
	public void clickOnFundType(String fundType) {
		Select ft=new Select(FundType);
		ft.selectByVisibleText(fundType);
		ExtentReportListener.getExtent().log(Status.PASS, "Fund selected :"+fundType);

		}       
	
	public void enterCity(String city) {
		City.sendKeys(city);
		ExtentReportListener.getExtent().log(Status.PASS, "City Entered :"+city);

		}
	
	public void clickOnIndianCitizen() {
		IndianCitizen.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Indian Citizen Selected ");

		}
	
	public void enterAddress(String address) {
		Address.sendKeys(address);
		ExtentReportListener.getExtent().log(Status.PASS, "Address Entered :"+address);

		}
	
	public void clickOnCountry(String country) {
		Select c=new Select(Country);
		c.selectByVisibleText(country);
		ExtentReportListener.getExtent().log(Status.PASS, "Country selected :"+country);

		}
	
	public void clickOnState(String state) {
		Select st=new Select(State);
		st.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State selected :"+state);

		}
	
	public void enterPincode(String pincode) {
		Pincode.sendKeys(pincode);
		ExtentReportListener.getExtent().log(Status.PASS, "Pincode Entered :"+pincode);

		}
	
	public void enterMobileNo(String mobileNo) {
		MobileNo.sendKeys(mobileNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number entered :"+mobileNo);

		}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);		
		ExtentReportListener.getExtent().log(Status.PASS, "EmailId entered :"+emailId);

		}
	
	public void clickOnRelationshipManager(String relationshipManager) {
		Select rm=new Select(RelationshipManager);
		rm.selectByVisibleText(relationshipManager);
		ExtentReportListener.getExtent().log(Status.PASS, "Relationship Manager selected :"+relationshipManager);

		}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Submit Successfully ");

		}
	
	
	
	
}
