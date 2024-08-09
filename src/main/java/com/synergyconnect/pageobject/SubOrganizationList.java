package com.synergyconnect.pageobject;

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
	
	
	
	public void clickOnEdit() {
		Edit.click();
	}
	
	public void clickOnAdd() {
		Add.click();
	}
	
	public void enterOrgName(String orgName) {
		OrgName.clear();
		OrgName.sendKeys(orgName);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name entered :"+orgName);

	}

	public void clickOnIncorporationDate() {
		IncorporationDate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Incorporation date selected");

	}
	
	public void clickOnDatepick() {
		DatePick.click();
	}
	
	public void enterShortName(String shortName) {
		ShortName.sendKeys(shortName);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Name entered :"+shortName);

	}
	
	public void clickOnTypeOfOrganization(String typeofOrganization) {
		Select to=new Select(TypeOfOrganization);
		to.selectByVisibleText(typeofOrganization);
		ExtentReportListener.getExtent().log(Status.PASS, "Type of organization selected :"+typeofOrganization);

		
	}
	
	public void clickOnOrgType(String orgType) {
		Select ot=new Select(OrgType);
		ot.selectByVisibleText(orgType);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization type selected :"+orgType);
	}
	
	public void enterCinNo(String cinNo) {
		CinNo.sendKeys(cinNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Cin Number entered :"+cinNo);

	}
	
	public void enterCsrRegNo(String csrRegNo) {
		CsrRegNo.sendKeys(csrRegNo);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR registr number entered :"+csrRegNo);

	}
	
	public void enterPanNo(String panNo) {
		PanNo.sendKeys(panNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Organization Name entered :"+panNo);

	}
	
	public void enterBriefIntro(String briefIntro) {
		BriefIntro.sendKeys(briefIntro);
		ExtentReportListener.getExtent().log(Status.PASS, "Brief Introduction entered :"+briefIntro);

	}
	
	public void enterName(String name) {
		Name.sendKeys(name);
		ExtentReportListener.getExtent().log(Status.PASS, "Name entered :"+name);

	}
	
	public void enterMobNo(String mobNo) {
		MobNo.sendKeys(mobNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number entered :"+mobNo);

	}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "Email Id entered :"+emailId);

	}
	
	public void enterAddressL1(String addressL1) {
		AddressL1.sendKeys(addressL1);
		ExtentReportListener.getExtent().log(Status.PASS, "AddressL1 entered :"+addressL1);

	}
	
	public void enterAddressL2(String addressL2) {
		AddressL2.sendKeys(addressL2);
		ExtentReportListener.getExtent().log(Status.PASS, "AddressL2 Name entered :"+addressL2);

	}
	
	public void clickOnCountry(String country) {
	Select c=new Select(Country);
	c.selectByVisibleText(country);
	ExtentReportListener.getExtent().log(Status.PASS, "Country Name Selected :"+country);

	
	}
	
	public void clickOnState(String state) {
		Select s=new Select(State);
		s.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State Name Selected :"+state);
		
	}
	
	public void enterCity(String city) {
		City.sendKeys(city);
		ExtentReportListener.getExtent().log(Status.PASS, "City Name entered :"+city);

	}
	
	public void enterPincode(String pincode) {
		Pincode.sendKeys(pincode);
		ExtentReportListener.getExtent().log(Status.PASS, "Pincode entered :"+pincode);

	}
	
	public void clickOnAddSubOrg() {
		addSubOrg.click();
	}
	
	
}


