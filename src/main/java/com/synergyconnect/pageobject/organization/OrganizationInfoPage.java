package com.synergyconnect.pageobject.organization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.synergyconnect.utilities.AlertUtils;
import com.synergyconnect.utilities.ElementInteractionUtils;
import com.synergyconnect.utilities.ReadConfig;

public class OrganizationInfoPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(OrganizationInfoPage.class);
	ReadConfig config = new ReadConfig();

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

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

	@FindBy(xpath = "//label[@for='organizationLogo']")
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

	@FindBy(xpath = "//*[@class=\"fa fa-linkedin\" and @data-original-title=\"Linkedin\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaLinkedin;

	@FindBy(xpath = "//*[@class=\"fa fa-facebook\" and @data-original-title=\"Facebook\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaFacebook;

	@FindBy(xpath = "//*[@class=\"fa fa-instagram\" and @data-original-title=\"Instagram\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaInstagram;

	@FindBy(xpath = "//*[@class=\"fa fa-times\" and @data-original-title=\"Twitter\"]/ancestor::a")
	private WebElement frmOrgnizationProfileSocialMediaTwitter;

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

	@Test
	public void redirectToAddOrganizationInfoAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlOrganizationDetails);
		ElementInteractionUtils.click(ddlAddOrganizationInfo);
	}

	public void AddorganizationInfo() {
		ElementInteractionUtils.click(btnOrganizationInfoEdit);
		ElementInteractionUtils.sendKeys(txtOrganizationName, "Society for Nutrition, Education and Health Action SNEHA, Mumbai");
		ElementInteractionUtils.sendKeys(dtpIncorporationDate,"19/12/1998");
		ElementInteractionUtils.sendKeys(txtShortName,"SNEHA");
		ElementInteractionUtils.selectByVisibleText(ddlEntityType,"Entity Established under and Act of Parliament of State Legislature");
		ElementInteractionUtils.sendKeys(txtCinNo,"L12345AA1234PLC012345");
		ElementInteractionUtils.sendKeys(txtCrnNo,"12345678");
		ElementInteractionUtils.sendKeys(txtMcaCsrRegNo,"MCA12345678");
		ElementInteractionUtils.sendKeys(txtEntityPanNo,"EDCVG4567Q");
		ElementInteractionUtils.sendKeys(txtContactPerson,"Jiten Dalvi");
		ElementInteractionUtils.sendKeys(txtMobileNo,"9820074310");
		ElementInteractionUtils.sendKeys(txtEmailId,"sneha@synergyconnect.in");
		ElementInteractionUtils.sendKeys(txtAddressLineI,"Santacruz West");
		ElementInteractionUtils.sendKeys(txtAddressLineII,"mumbai");
		ElementInteractionUtils.sendKeys(txtCity,"Mumbai");
		ElementInteractionUtils.sendKeys(txtPincode,"400054");
		ElementInteractionUtils.selectByVisibleText(ddlCountry,"India");
		ElementInteractionUtils.selectByVisibleText(ddlState,"Maharastra");
		//Logo
		ElementInteractionUtils.sendKeys(txaBriefDiscription, "SNEHA is a non-profit organization that works with women, children, adolescents, public health and safety systems and in the area of palliative care. Our innovative work in urban informal settlements in seven Municipal Corporations including Mumbai aims to reduce maternal and neonatal mortality and morbidity, child malnutrition, adolescent empowerment and sexuality, gender-based violence and palliative care.");
		/* Media Sources */
		ElementInteractionUtils.sendKeys(txtwebsite,"https://snehamumbai.org/");
		ElementInteractionUtils.sendKeys(txtcsrLink,"https://snehamumbai.org/");
		ElementInteractionUtils.sendKeys(txtlinkedIn,"https://www.linkedin.com/company/society-for-nutrition-education-and-health-action-sneha-");
		ElementInteractionUtils.sendKeys(txtFacebook,"https://www.facebook.com/SnehaMumbai");
		ElementInteractionUtils.sendKeys(txtInstagram,"https://www.instagram.com/give_india/https://www.instagram.com/snehamumbai_official/");
		ElementInteractionUtils.sendKeys(txtTwitter,"https://twitter.com/SNEHAmumbai");
		ElementInteractionUtils.sendKeys(txtYouTube,"https://youtube.com/SNEHAmumbai");
		
	}

}
