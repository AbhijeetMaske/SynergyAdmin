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
	WebElement organizationInfoEdit;
	
	@FindBy(id="organizationName")
	WebElement organizationName;
	
	@FindBy(id="establishedOn")
	WebElement incorporationDate;
	
	@FindBy(xpath="//td[text()='15']")
	WebElement DatePicker;
	
	@FindBy(xpath="//input[@placeholder='Enter Short Name']")
	WebElement shortName;
	
	@FindBy(id="registeredWith")
	WebElement entityType;
	
	@FindBy(id="cinRegistrationNo")
	WebElement cinNo;
	
	@FindBy(id="mcaNO")
	WebElement mcaCsrRegNo;	
	
	@FindBy(id="entitypanNo")
	WebElement EntityPanNo;	
	
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
	
	//Profile
	@FindBy(id="mcaNumber")
	WebElement mcaCsrRegNoText;
	
	@FindBy(id="cinNumber")
	WebElement cinRegistrationNoText;
	
	@FindBy(xpath="//label[text()='Email ID']")
	WebElement emailIdText;
	
	
	public void organizationInfoEdit() {
		organizationInfoEdit.click();
	}
	
	public void organizationName() {
		organizationName.clear();
		organizationName.sendKeys("SynergyConnect Foundation");
	}
	
	public void incorporationDate() {
		incorporationDate.click();
	}
	public void DatePicker() {
		DatePicker.click();
	}
	
	public void shortName() {
		shortName.clear();
		shortName.sendKeys("etyfhds");
	}
	
	public void entityType() {
		Select ET=new Select(entityType);
		ET.selectByVisibleText("Entity Established under and Act of Parliament of State Legislature");
	}
	
	public void cinNo() {
		cinNo.clear();
		cinNo.sendKeys("L12345AA1234PLC044444");
	}
	
	public void mcaCsrRegNo() {
		mcaCsrRegNo.clear();
		mcaCsrRegNo.sendKeys("ABD00081234");
	}
	
	public void entityPanNo() {
		EntityPanNo.clear();
		EntityPanNo.sendKeys("AFDHA1789A");
	}
	
	public void contactPerson() {
		ContactPerson.clear();
		ContactPerson.sendKeys("Kuldeep Hirde");
	}
	
	public void mobileNo() {
		MobileNo.clear();
		MobileNo.sendKeys("9175437343");
	}
	
	public void emailId() {
		EmailId.clear();
		EmailId.sendKeys("tanaya@synergyconnect.in");
	}
	
	public void address_I() {
		Address1.clear();
		Address1.sendKeys("Near RBL Bank, Gokhle Road");
	}
	
	public void address_II() {
		Address2.clear();
		Address2.sendKeys("Dadar West");
	}
	
	public void city() {
		City.clear();
		City.sendKeys("Mumbai");
	}
	
	public void pincode() {
		Pincode.clear();
		Pincode.sendKeys("400002");
	}
	
	public void country() {
		Select c=new Select(Country);
		c.selectByVisibleText("India");
	}
	
	public void state() {
		Select s=new Select(State);
		s.selectByVisibleText("Maharashtra");
	}
	
	public void uploadLogo() {
		//UploadLogo.click();
	}
	
	public void briefDiscription() {
		BriefDiscription.clear();
		BriefDiscription.sendKeys("Driving Excellence for NGOs, Corporate CSR, and Foundations.\r\n"
				+ "Embracing the evolving role of technology, we enable NGOs and corporate CSR and foundations to harness its power in driving operational excellence to maximize their social impact and create a sustainable future");
	}
	
	public void submit() {
		Submit.click();
	}

	//Validation
	public String mcaCsrRegNoText() {
		return mcaCsrRegNoText.getText();

	}
	public String cinNoText() {
		return cinRegistrationNoText.getText();
	}

	public String emailIdText() {
		return emailIdText.getText();
	}
	





}
