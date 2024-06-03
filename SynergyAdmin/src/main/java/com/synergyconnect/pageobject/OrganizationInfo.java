package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInfo {
	
public OrganizationInfo(WebDriver driver) {
		
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
	
	@FindBy(id="cinRegistrationNo")
	WebElement CinNo;
	
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
	
	@FindBy(id="address.location")
	WebElement Address1;
	
	@FindBy(id="address.locationII")
	WebElement Address2;
	
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
	
	@FindBy(id="orgFormSubmitButton")
	WebElement Submit;
	
	
	public void clickOnEdit() {
		Edit.click();
	}
	
	public void enterOrganizationName() {
		OrganizationName.clear();
		OrganizationName.sendKeys("SynergyConnect Foundation");
	}
	
	public void clickOnIncorporationDate() {
		IncorporationDate.click();
	}
	public void DatePicker() {
		DatePicker.click();
	}
	
	public void enterShortName() {
		ShortName.clear();
		ShortName.sendKeys("etyfhds");
	}
	
	public void clickOnEntityType() {
		Select et=new Select(EntityType);
		et.selectByVisibleText("Entity Established under and Act of Parliament of State Legislature");
	}
	
	public void enterCinNo() {
		CinNo.clear();
		CinNo.sendKeys("L12345AA1234PLC044444");
	}
	
	public void enterCsrRegNo() {
		CsrRegNo.clear();
		CsrRegNo.sendKeys("ABD00081234");
	}
	public String getCSRText() {
		return ExCsrRegNo.getText();

	}
	public String getCINNotext() {
		return CinNo.getText();

	}
	public void enterEntityPanNo() {
		EntityPanNo.clear();
		EntityPanNo.sendKeys("AFDHA1789A");
	}
	public String getPanNo() {
		return ExPanNo.getText();
	}
	
	public void enterContactPerson() {
		ContactPerson.clear();
		ContactPerson.sendKeys("Kuldeep Hirde");
	}
	
	public void enterMobileNo() {
		MobileNo.clear();
		MobileNo.sendKeys("9175437343");
	}
	
	public void enterEmailId() {
		EmailId.clear();
		EmailId.sendKeys("tanaya@synergyconnect.in");
	}
	
	public void enterAddress1() {
		Address1.clear();
		Address1.sendKeys("Near RBL Bank, Gokhle Road");
	}
	
	public void enterAddress2() {
		Address2.clear();
		Address2.sendKeys("Dadar West");
	}
	
	public void enterCity() {
		City.clear();
		City.sendKeys("Mumbai");
	}
	
	public void enterPincode() {
		Pincode.clear();
		Pincode.sendKeys("400002");
	}
	
	public void clickOnCountry() {
		Select c=new Select(Country);
		c.selectByVisibleText("India");
	}
	
	public void clickOnState() {
		Select s=new Select(State);
		s.selectByVisibleText("Maharashtra");
	}
	
	public void clickOnUploadLogo() {
		UploadLogo.click();
	}
	
	public void enterBriefDiscription() {
		BriefDiscription.clear();
		BriefDiscription.sendKeys("Driving Excellence for NGOs, Corporate CSR, and Foundations.\r\n"
				+ "Embracing the evolving role of technology, we enable NGOs and corporate CSR and foundations to harness its power in driving operational excellence to maximize their social impact and create a sustainable future");
	}
	
	public void clickOnSubmit() {
		Submit.click();
	}









}
