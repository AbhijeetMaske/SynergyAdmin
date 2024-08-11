package com.synergyconnect.pageobject.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInfo {

	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// identify WebElements

	// Organization Info
	@FindBy(xpath = "//i[@class='fa fa-edit']")
	private WebElement btnOrganizationInfoEdit;

	@FindBy(xpath = "//*[@id='organizationName']")
	private WebElement txtOrganizationName;

	@FindBy(xpath = "//*[@id=\"establishedOn\"]")
	private WebElement dtpIncorporationDate;

	@FindBy(xpath = "//*[@id=\"organisationAbbreviation\"]")
	private WebElement txtShortName;

	@FindBy(xpath = "//*[@id=\"registeredWith\"]")
	private WebElement ddlEntityType;

	@FindBy(xpath = "//*[@id=\"cinRegistrationNo\"]")
	private WebElement txtCinNo;

	@FindBy(xpath = "//*[@id=\"crn\"]")
	private WebElement txtCrnNo;

	@FindBy(xpath = "//*[@id=\"mcaNO\"]")
	private WebElement txtMcaCsrRegNo;

	@FindBy(xpath = "//*[@id=\"entitypanNo\"]")
	private WebElement txtEntityPanNo;

	@FindBy(xpath = "//*[@id=\"organizationContactPerson\"]")
	private WebElement txtContactPerson;

	@FindBy(xpath = "//*[@id=\"organizationContactPersonContact\"]")
	private WebElement txtMobileNo;

	@FindBy(xpath = "//*[@id=\"contactEmailId\"]")
	private WebElement txtEmailId;

	@FindBy(xpath = "//*[@id=\"address.location\"]")
	private WebElement txtAddressLineI;

	@FindBy(xpath = "//*[@id=\"address.locationII\"]")
	private WebElement txtAddressLineII;

	@FindBy(xpath = "//*[@id=\"address.village\"]")
	private WebElement txtCity;

	@FindBy(xpath = "//*[@id=\"address.pinCode\"]")
	private WebElement txtPincode;

	@FindBy(xpath = "//*[@id=\"country\"]")
	private WebElement ddlCountry;

	@FindBy(xpath = "//*[@id=\"state\"]")
	private WebElement ddlState;

	@FindBy(xpath = "//label[@for='organizationLogo']")
	private WebElement btnUploadLogo;

	@FindBy(xpath = "//*[@id=\"aboutOrganization\"]")
	private WebElement txaBriefDiscription;

	// Media Sources

	@FindBy(xpath = "//*[@id=\"socialNetwork.website\"]")
	private WebElement txtwebsite;

	@FindBy(xpath = "//*[@id=\"socialNetwork.csrPageLink\"]")
	private WebElement txtcsrLink;

	@FindBy(xpath = "//*[@id=\"socialNetwork.linkedIn\"]")
	private WebElement txtlinkedIn;

	@FindBy(xpath = "//*[@id=\"socialNetwork.facebook\"]")
	private WebElement txtFacebook;

	@FindBy(xpath = "//*[@id=\"socialNetwork.instagram\"]")
	private WebElement txtInstagram;

	@FindBy(xpath = "//*[@id=\"socialNetwork.twitter\"]")
	private WebElement txtTwitter;

	@FindBy(xpath = "//*[@id=\"socialNetwork.youtube\"]")
	private WebElement txtYouTube;

	//
	@FindBy(xpath = "//*[@id=\"grpYes\"]")
	private WebElement establishedByCompanyOrGroupOfCompaniesYes;

	@FindBy(xpath = "//*[@id=\"grpNo\"]")
	private WebElement establishedByCompanyOrGroupOfCompaniesNO;

	@FindBy(xpath = "//*[@id=\"subOrgYes\"]")
	private WebElement subOrganizationYes;

	@FindBy(xpath = "//*[@id=\"subOrgNo\"]")
	private WebElement subOrganizationNO;

	@FindBy(xpath = "//*[@id=\"orgFormSubmitButton\"]")
	private WebElement btnOrgnizationInfoSubmit;

	// CSR Company
	@FindBy(xpath = "//*[@id=\"addBtnCSR\"]")
	private WebElement btnAddCsrCompanydetails;

	@FindBy(xpath = "//*[@id=\"csrCompanyName\"]")
	private WebElement txtCsrCompanyName;

	@FindBy(xpath = "//*[@id=\"csrCinNo\"]")
	private WebElement txtCsrCinNo;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/section[1]/div[1]/div[1]/form[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	private WebElement txtCsrShortName;
	
	@FindBy(xpath = "//*[@id=\"csrHeadManagerName\"]")
	private WebElement txtCsrHeadManager;
	
	@FindBy(xpath = "//*[@id=\"csrMobileNo\"]")
	private WebElement txtCsrMobileNo;
	
	@FindBy(xpath = "//*[@id=\"csrCity\"]")
	private WebElement txtCsrCity;
	
	@FindBy(xpath = "//*[@id=\"csrState\"]")
	private WebElement ddlCsrState;
	
	@FindBy(xpath = "//*[@id=\"csrCompanyButton\"]")
	private WebElement btnAddCsr;

	@FindBy(xpath = "//*[@id=\"csrCompanyDetailCollapse\"]/div[2]/button[2]")
	private WebElement btnCancelCsr;
	
	@FindBy(xpath = "//*[@id=\"tbl_csrCompany_wrapper\"]")
	private WebElement tblCsrDetails;
	
	@FindBy(xpath = "//*[@id=\"tbl_csrCompany_next\"]")
	private WebElement btnCsrDetailsNext;
	
	//Sub-Organization
	@FindBy(xpath = "//*[@id=\"subOrgBtn\"]")
	private WebElement btnSubOrganizationAdd;
	
	@FindBy(xpath = "//*[@id=\"subOrganizationName\"]")
	private WebElement txtSubOrganizationName;
	
	
	// Profile
	@FindBy(id = "mcaNumber")
	private WebElement mcaCsrRegNoText;

	@FindBy(id = "cinNumber")
	private WebElement cinRegistrationNoText;

	@FindBy(xpath = "//label[text()='Email ID']")
	private WebElement emailIdText;

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
		Select ET = new Select(entityType);
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
		Select c = new Select(Country);
		c.selectByVisibleText("India");
	}

	public void state() {
		Select s = new Select(State);
		s.selectByVisibleText("Maharashtra");
	}

	public void uploadLogo() {
		// UploadLogo.click();
	}

	public void briefDiscription() {
		BriefDiscription.clear();
		BriefDiscription.sendKeys("Driving Excellence for NGOs, Corporate CSR, and Foundations.\r\n"
				+ "Embracing the evolving role of technology, we enable NGOs and corporate CSR and foundations to harness its power in driving operational excellence to maximize their social impact and create a sustainable future");
	}

	public void submit() {
		Submit.click();
	}

	// Validation
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
