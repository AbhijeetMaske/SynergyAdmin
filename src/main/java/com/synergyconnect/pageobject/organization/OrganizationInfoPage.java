package com.synergyconnect.pageobject.organization;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.Config;
import com.synergyconnect.utilities.AlertUtils;
import com.synergyconnect.utilities.ElementInteractionUtils;
import com.synergyconnect.utilities.ReadConfig;
import com.synergyconnect.utilities.WebElementLocators;

import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

public class OrganizationInfoPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	WebElementLocators WL;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(OrganizationInfoPage.class);
	ReadConfig readconfig = new ReadConfig();
	Config config = new Config();

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		WL = new WebElementLocators(driver);
		AU = new AlertUtils(driver);
	}

	WebElement Yearswitch;
	// identify WebElements

	@FindBy(xpath = "//span[contains(text(),'Organization Details')]")
	private WebElement ddlOrganizationDetails;

	@FindBy(xpath = "//span[contains(text(),'Add Organization Info')]")
	private WebElement ddlAddOrganizationInfo;

	/* Organization Info */
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

	@FindBy(xpath = "//input[@id='organizationLogo']")
	private WebElement btnUploadLogo;

	@FindBy(xpath = "//*[@id=\"aboutOrganization\"]")
	private WebElement txaBriefDiscription;

	/* Media Sources */
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

	/* CSR Company Details */
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

	/* CSR Table */
	@FindBy(xpath = "//*[@id=\"tbl_csrCompany_wrapper\"]")
	private WebElement tblCsrDetails;

	@FindBy(xpath = "//*[@id=\"tbl_csrCompany_next\"]")
	private WebElement btnCsrDetailsNext;

	// Sub-Organization
	/* Sub-Organization Details */
	@FindBy(xpath = "//*[@id=\"subOrgBtn\"]")
	private WebElement btnSubOrganizationAdd;

	@FindBy(xpath = "//*[@id=\"subOrganizationName\"]")
	private WebElement txtSubOrganizationName;

	@FindBy(xpath = "//*[@id=\"subIncorporationDate\"]")
	private WebElement dtpSubOrganizationIncorporationDate;

	@FindBy(xpath = "//*[@id=\"subShortName\"]")
	private WebElement txtSubOrganizationShortName;

	@FindBy(xpath = "//*[@id=\"typeofSubOrg\"]")
	private WebElement ddlSubOrganizationTypeOfOrgnization;

	@FindBy(xpath = "//*[@id=\"subOrgType\"]")
	private WebElement ddlSubOrganizationOrgnizationType;

	@FindBy(xpath = "//*[@id=\"subCinNumber\"]")
	private WebElement txtSubOrganizationCin;

	@FindBy(xpath = "//*[@id=\"subMcaNumber\"]")
	private WebElement txtSubOrganizationMcaCsrRegNo;

	@FindBy(xpath = "//*[@id=\"subPanNumber\"]")
	private WebElement txtSubOrganizationPanNo;

	@FindBy(xpath = "//*[@id=\"subPanNumber\"]")
	private WebElement uplSubOrganizationLogo;

	@FindBy(xpath = "//*[@id=\"aboutSubOrganization\"]")
	private WebElement uplSubOrganizationBriefIntroduction;

	/* Contact Person Details */
	@FindBy(xpath = "//*[@id=\"aboutSubOrganization\"]")
	private WebElement txtSubOrganizationContactName;

	@FindBy(xpath = "//*[@id=\"subOrgMobileNumber\"]")
	private WebElement txtSubOrganizationMobileNumber;

	@FindBy(xpath = "//*[@id=\"subOrgEmail\"]")
	private WebElement txtSubOrganizationEmailId;

	/* Organization Registered Address Details */
	@FindBy(xpath = "//*[@id=\"subOrgAddressLine1\"]")
	private WebElement txtSubOrganizationAddressLineI;

	@FindBy(xpath = "//*[@id=\"subOrgAddressLine2\"]")
	private WebElement txtSubOrganizationAddressLineII;

	@FindBy(xpath = "//*[@id=\"subOrgCountry\"]")
	private WebElement ddlSubOrganizationCountry;

	@FindBy(xpath = "//*[@id=\"subOrgState\"]")
	private WebElement ddlSubOrganizationState;

	@FindBy(xpath = "//*[@id=\"subOrgCity\"]")
	private WebElement txtSubOrganizationCity;

	@FindBy(xpath = "//*[@id=\"subOrgPincode\"]")
	private WebElement txtSubOrganizationPincode;

	@FindBy(xpath = "//*[@id=\"addSuborgBtn\"]")
	private WebElement btnAddSubOrganization;

	@FindBy(xpath = "//*[@id=\"closeBtn\"]")
	private WebElement btnCancelSubOrganization;

	/* Sub-Organization Table */
	@FindBy(xpath = "//*[@id=\"tbl_subOrgDetails_wrapper\"]")
	private WebElement tblSubOrgizationDetails;

	@FindBy(xpath = "//*[@id=\"tbl_subOrgDetails_wrapper\"]")
	private WebElement btnSubOrgizationDetailsEdit;

	@FindBy(xpath = "//*[@id=\"tbl_subOrgDetails_wrapper\"]")
	private WebElement tblSubOrgizationDetailsInactive;

	@FindBy(xpath = "//*[@id=\"tbl_subOrgDetails_next\"]")
	private WebElement btnSubOrgnizationDetailsNext;

	/* Organization - Profile */
	@FindBy(xpath = "//*[@id=\"orgDescription\"]")
	private WebElement frmOrgnizationProfileDescription;

	@FindBy(xpath = "//*[@id=\"incorporationDate\"]")
	private WebElement frmOrgnizationProfileIncorporationDate;

	@FindBy(xpath = "//*[@id=\"orgType\"]")
	private WebElement frmOrgnizationProfileOrgType;

	@FindBy(xpath = "//*[@id=\"cinNumber\"]")
	private WebElement frmOrgnizationProfileCinRegistrationNo;

	@FindBy(xpath = "//*[@id=\"mcaNumber\"]")
	private WebElement frmOrgnizationProfileMcaCsrRegNo;

	/* Organization - Contact Details */
	@FindBy(xpath = "//*[@id=\"contactDetails\"]")
	private WebElement frmOrgnizationProfileAddress;

	@FindBy(xpath = "//*[@id=\"contactPerson\"]")
	private WebElement frmOrgnizationProfileContactPerson;

	@FindBy(xpath = "//*[@id=\"mobileNumber\"]")
	private WebElement frmOrgnizationProfileMobileNumber;

	@FindBy(xpath = "//*[@id=\"emailID\"]")
	private WebElement frmOrgnizationProfileEmailId;

	/* Social Media Links */
	@FindBy(xpath = "//*[@class=\"fa fa-globe\" and @data-original-title=\"Website\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaWebsite;

	@FindBy(xpath = "//*[@class=\"fa fa-link\" and @data-original-title=\"Link\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaCsrPage;

	@FindBy(xpath = "//*[@class=\"fa fa-linkedin\" and @data-original-title=\"Linkedin\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaLinkedin;

	@FindBy(xpath = "//*[@class=\"fa fa-facebook\" and @data-original-title=\"Facebook\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaFacebook;

	@FindBy(xpath = "//*[@class=\"fa fa-instagram\" and @data-original-title=\"Instagram\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaInstagram;

	@FindBy(xpath = "//*[@class=\"fa fa-times\" and @data-original-title=\"Twitter\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaTwitter;

	@FindBy(xpath = "//*[@class=\"fa fa-youtube\" and @data-original-title=\"Youtube\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaYoutube;

	/* CSR Company Details - Card */
	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li")
	private WebElement frmOrgnizationProfileCsrCompanyCount;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[1]/h4")
	private WebElement OrgnizationProfileCsrCompanyName;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[1]/p[2]/text()")
	private WebElement OrgnizationProfileCsrHeadManager;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[1]/text()")
	private WebElement OrgnizationProfileCsrState;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[2]/text()")
	private WebElement OrgnizationProfileCsrCity;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[3]/text()")
	private WebElement OrgnizationProfileCsrMobileNumber;

	/* Sub-Organization List - Card */
	@FindBy(xpath = "//*[@id=\"sub-org-card\"]/li")
	private WebElement OrgnizationProfileSubOrgnizationCount;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[1]/h4")
	private WebElement OrgnizationProfileSubOrganizationName;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[1]/p[2]/text()")
	private WebElement frmOrgnizationProfileSubOrganizationHeadManager;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[1]/text()")
	private WebElement frmOrgnizationProfileSubOrganizationState;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[2]/text()")
	private WebElement frmOrgnizationProfileSubOrganizationCity;

	@FindBy(xpath = "//*[@id=\"csrCompanyListDiv\"]/li[1]/div/div[2]/div/div[2]/p[3]/text()")
	private WebElement frmOrgnizationProfileSubOrganizationMobileNumber;

	/* Organization Info Data */
	private String OrganiationName = "Society for Nutrition, Education and Health Action SNEHA, Mumbai";
	private String OrgnizationIncorporationDate = "18/08/2028";
	String DatePicker_Switch = "/html/body/div[4]/div[1]/table/thead/tr[2]/th[2]";
	String DatePicker_Header = "/html/body/div[4]/div[2]/table/thead/tr[2]/th[2]";
	String DatePicker_prev = "/html/body/div[4]/div[2]/table/thead/tr[2]/th[1]";
	String DatePicker_next = "/html/body/div[4]/div[2]/table/thead/tr[2]/th[3]";
	String OrganizationShortName = "SNEHA";
	String EntityType = "Entity Established under and Act of Parliament of State Legislature";
	String OrganizationCinNo = "L12345AA1234PLC012345";
	String OrganizationCrnNo = "12345678";
	String OrganizationMcaCsrRegNo = "MCA12345678";
	String OrganizationPanNo = "EDCVG4567Q";
	String OrganizationContactPerson = "Jiten Dalvi";
	String OrganizationMobileNo = "9820074310";
	String OrganizationEmailId = "sneha@synergyconnect.in";
	String OrganizationAddressLineI = "Santacruz West";
	String OrganizationAddressLineII = "mumbai";
	String OrganizationCity = "Mumbai";
	String OrganizationPincode = "400054";
	String OrganizationCountry = "United States Of America";
	String OrganizationState = "New Jersey";
	String OrganizationBriefDiscription = "SNEHA is a non-profit organization that works with women, children, adolescents, public health and safety systems and in the area of palliative care. Our innovative work in urban informal settlements in seven Municipal Corporations including Mumbai aims to reduce maternal and neonatal mortality and morbidity, child malnutrition, adolescent empowerment and sexuality, gender-based violence and palliative care.";
	String OrganizationWebsite = "https://snehamumbai.org/";
	String OrganizationCsrPage = "https://snehamumbai.org/";
	String OrganizationLinkedIn = "https://www.linkedin.com/company/society-for-nutrition-education-and-health-action-sneha-";
	String OrganizationFacebook = "https://www.facebook.com/SnehaMumbai";
	String OrganizationInstagram = "https://www.instagram.com/give_india/https://www.instagram.com/snehamumbai_official";
	String OrganizationTwitter = "https://twitter.com/SNEHAmumbai";
	String OrganizationYoutube = "https://youtube.com/SNEHAmumbai";

	@Test
	public void redirectToAddOrganizationInfoAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlOrganizationDetails);
		ElementInteractionUtils.click(ddlAddOrganizationInfo);
	}

	@Test
	public void AddorganizationInfo() throws InterruptedException {
		try {
			ElementInteractionUtils.click(btnOrganizationInfoEdit);
			ElementInteractionUtils.sendKeys(txtOrganizationName, OrganiationName);
			// ElementInteractionUtils.sendKeys(dtpIncorporationDate, "");
			ElementInteractionUtils.datePicker(OrgnizationIncorporationDate, dtpIncorporationDate);
			ElementInteractionUtils.sendKeys(txtShortName, OrganizationShortName);
			ElementInteractionUtils.selectByVisibleText(ddlEntityType, EntityType);
			ElementInteractionUtils.sendKeys(txtCinNo, OrganizationCinNo);
			ElementInteractionUtils.sendKeys(txtCrnNo, OrganizationCrnNo);
			ElementInteractionUtils.sendKeys(txtMcaCsrRegNo, OrganizationMcaCsrRegNo);
			ElementInteractionUtils.sendKeys(txtEntityPanNo, OrganizationPanNo);
			ElementInteractionUtils.sendKeys(txtContactPerson, OrganizationContactPerson);
			ElementInteractionUtils.sendKeys(txtMobileNo, OrganizationMobileNo);
			ElementInteractionUtils.sendKeys(txtEmailId, OrganizationEmailId);
			ElementInteractionUtils.sendKeys(txtAddressLineI, OrganizationAddressLineI);
			ElementInteractionUtils.sendKeys(txtAddressLineII, OrganizationAddressLineII);
			ElementInteractionUtils.sendKeys(txtCity, OrganizationCity);
			ElementInteractionUtils.sendKeys(txtPincode, OrganizationPincode);
			ElementInteractionUtils.selectByVisibleText(ddlCountry, OrganizationCountry);
			Thread.sleep(2000);
			ElementInteractionUtils.selectByVisibleText(ddlState, OrganizationState);
			ElementInteractionUtils.uploadFile(btnUploadLogo,
					"C:\\Users\\Abhijeet\\git\\SynergyAdmin\\src\\test\\resources\\SynergyLogo.jpg");
			ElementInteractionUtils.sendKeys(txaBriefDiscription, OrganizationBriefDiscription);
			/* Media Sources */
			ElementInteractionUtils.sendKeys(txtwebsite, OrganizationWebsite);
			ElementInteractionUtils.sendKeys(txtcsrLink, OrganizationCsrPage);
			ElementInteractionUtils.sendKeys(txtlinkedIn, OrganizationLinkedIn);
			ElementInteractionUtils.sendKeys(txtFacebook, OrganizationFacebook);
			ElementInteractionUtils.sendKeys(txtInstagram, OrganizationInstagram);
			ElementInteractionUtils.sendKeys(txtTwitter, OrganizationTwitter);
			ElementInteractionUtils.sendKeys(txtYouTube, OrganizationYoutube);
			ElementInteractionUtils.click(establishedByCompanyOrGroupOfCompaniesYes);
			ElementInteractionUtils.click(subOrganizationYes);
			ElementInteractionUtils.click(btnOrgnizationInfoSubmit);
			String SubmitToasterMessage = AU.getToasterText();
			Assert.assertEquals(SubmitToasterMessage, "Organization data updated !");
		} catch (Exception e) {
			logger.error("Exception occurred during add Organization Info: ", e);
		}
	}

	@Test
	public void VerifyOrganizationProfile() {
		try {
			ElementInteractionUtils.verifyText(frmOrgnizationProfileDescription, OrganizationBriefDiscription);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileIncorporationDate, OrgnizationIncorporationDate);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileOrgType, EntityType);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileCinRegistrationNo, OrganizationCinNo);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileMcaCsrRegNo, OrganizationMcaCsrRegNo);

			ElementInteractionUtils.verifyText(frmOrgnizationProfileAddress, OrganizationAddressLineI);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileContactPerson, OrganizationContactPerson);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileMobileNumber, OrganizationMobileNo);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileEmailId, OrganizationEmailId);

			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaWebsite, OrganizationWebsite);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaCsrPage, OrganizationCsrPage);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaLinkedin, OrganizationLinkedIn);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaFacebook, OrganizationFacebook);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaInstagram, OrganizationInstagram);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaTwitter, OrganizationTwitter);
			ElementInteractionUtils.verifyText(frmOrgnizationProfileSocialMediaYoutube, OrganizationYoutube);
		} catch (Exception e) {
			logger.error("Exception occurred during verification of Organization profile Info: ", e);
		}
	}

	@Test
	public void AddCsrCompanyDetails() {
		try {
			ElementInteractionUtils.click(btnOrganizationInfoEdit);
			ElementInteractionUtils.click(btnAddCsrCompanydetails);
			ElementInteractionUtils.sendKeys(txtCsrCompanyName, "SNEHA CSR");
			ElementInteractionUtils.sendKeys(txtCsrCinNo, "L12345AA1234PLC012346");
			ElementInteractionUtils.sendKeys(txtCsrShortName, "SNHCSR");
			ElementInteractionUtils.sendKeys(txtCsrHeadManager, "Abhijeet Maske");
			ElementInteractionUtils.sendKeys(txtCsrMobileNo, "9812345678");
			ElementInteractionUtils.sendKeys(txtCsrCity, "Pune");
			ElementInteractionUtils.selectByVisibleText(ddlCsrState, "New Jersey");
			ElementInteractionUtils.click(btnAddCsr);
			String SubmitToasterMessage = AU.getToasterText();
			Assert.assertEquals(SubmitToasterMessage, "CIN Registration number already exists");
			ElementInteractionUtils.click(btnCancelCsr);
		} catch (Exception e) {
			logger.error("Exception occurred during addition of CSR company details: ", e);
		}
	}

	@Test
	public void verifyAddedCsrCompanyDetails() {
		try {
			ElementInteractionUtils.pause(500);
			ElementInteractionUtils.scrollToElement(btnAddCsrCompanydetails);
			boolean result = ElementInteractionUtils.verifyTextInTable("tbl_csrCompany", 2, "SNEHA CSR",
					btnCsrDetailsNext);
			Assert.assertTrue(result, "Added CSR details data NOT found in the table.");
		} catch (AssertionError ae) {
			logger.error("Assertion failed while verifying added CSR details: ", ae);
			throw ae;
		} catch (Exception e) {
			logger.error("Exception occurred during addition of CSR company details: ", e);
		}
	}

	@Test
	public void AddSubOrganization() {
		try {
			ElementInteractionUtils.click(btnSubOrganizationAdd);
			ElementInteractionUtils.sendKeys(txtSubOrganizationName, "SNEHA SUB ORG");
			ElementInteractionUtils.sendKeys(txtSubOrganizationName, "SNEHA SUB ORG");
		} catch (Exception e) {
			logger.error("Exception occurred during addition of CSR company details: ", e);
		}
	}
}
