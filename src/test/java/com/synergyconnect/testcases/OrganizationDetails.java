package com.synergyconnect.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.organization.OrganizationInfoPage;
import com.synergyconnect.utilities.ExtentReportListener;

public class OrganizationDetails extends BaseClass {

	private OrganizationInfoPage organizationInfoPage;
	private ExtentTest parentTest;

	public OrganizationDetails() {
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public void setUp() {
		parentTest = ExtentReportListener.createParentTest("Add Organization Info Details",
				"Add Orgnization Details Information");
		ExtentReportListener.tags("Regression", "Smoke");
		organizationInfoPage = new OrganizationInfoPage(getDriver());
	}

	@Test(priority = 1)
	public void pageRedirection() throws InterruptedException {
		ExtentTest childTest = parentTest.createNode("Page Redirection & validating URL");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			organizationInfoPage.redirectToAddOrganizationInfoAndValidateUrl();
			childTest.log(Status.PASS, "Page redirection and URL validation successful");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Page redirection and URL validation failed: " + e.getMessage());
		}
	}
	
//	@Test(priority = 2, alwaysRun = true, dependsOnMethods = "pageRedirection")
//	public void addOrganizationInfoDetails() {
//		ExtentTest childTest = parentTest.createNode("Adding organization info details");
//		ExtentReportListener.author("Abhijeet Maske");
//		try {
//			organizationInfoPage.AddorganizationInfo();
//			childTest.log(Status.PASS, "organization info details added successfully");
//		} catch (Exception e) {
//			childTest.log(Status.FAIL, "Failed to add organization info details: " + e.getMessage());
//		}
//	}
	
//	@Test(priority = 3, alwaysRun = true, dependsOnMethods = "pageRedirection")
//	public void VerifyOrganizationInfoDetails() {
//		ExtentTest childTest = parentTest.createNode("Verified organization profile details");
//		ExtentReportListener.author("Abhijeet Maske");
//		try {
//			organizationInfoPage.VerifyOrganizationProfile();
//			childTest.log(Status.PASS, "Verified organization profile details successfully");
//		} catch (Exception e) {
//			childTest.log(Status.FAIL, "organization profile details verification failed: " + e.getMessage());
//		}
//	}
	
	@Test(priority = 4, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void AddCsrCompanyDetails() {
		ExtentTest childTest = parentTest.createNode("Adding CSR company details");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			organizationInfoPage.AddCsrCompanyDetails();;
			childTest.log(Status.PASS, "Added CSR company details successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to add CSR company details to the form: " + e.getMessage());
		}
	}
	
	@Test(priority = 5, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void VerifyCsrCompanyDetails() {
		ExtentTest childTest = parentTest.createNode("verifying CSR company details");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			organizationInfoPage.verifyAddedCsrCompanyDetails();;
			childTest.log(Status.PASS, "verified CSR company details successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to verify CSR company details: " + e.getMessage());
		}
	}
}
