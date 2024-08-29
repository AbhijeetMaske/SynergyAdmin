package com.synergyconnect.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.organization.LocationPage;
import com.synergyconnect.utilities.ExtentReportListener;

public class Location extends BaseClass {

	private LocationPage locationPage;
	private ExtentTest parentTest;

	public Location() {
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public void setUp() {
		parentTest = ExtentReportListener.createParentTest("Add location details", "Add Location Details");
		ExtentReportListener.tags("Regression", "Smoke");
		locationPage = new LocationPage(getDriver());
	}

	@Test(priority = 1)
	public void pageRedirection() throws InterruptedException {
		ExtentTest childTest = parentTest.createNode("Page Redirection & validating URL");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.redirectToAddLocationAndValidateUrl();
			childTest.log(Status.PASS, "Page redirection and URL validation successful");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Page redirection and URL validation failed: " + e.getMessage());
		}
	}

	@Test(priority = 2, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void addLocationDetails() {
		ExtentTest childTest = parentTest.createNode("Adding Location details");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.AddLocationInfo();
			childTest.log(Status.PASS, "Location details added successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to add Location details: " + e.getMessage());
		}
	}

	@Test(priority = 3, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void VerifyAddedLocationDetails() {
		ExtentTest childTest = parentTest.createNode("Verify Location details");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.verifyAddedLocation();
			childTest.log(Status.PASS, "Verified Location details successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to verify Location details: " + e.getMessage());
		}
	}

	@Test(priority = 4, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void VerifyOfficeLocationFilter() {
		ExtentTest childTest = parentTest.createNode("Verify office filter");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.verifyOfficeLocationFilters();
			childTest.log(Status.PASS, "Verified office filter successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to verify office filter: " + e.getMessage());
		}
	}

	@Test(priority = 5, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void VerifyProjectLocationFilter() {
		ExtentTest childTest = parentTest.createNode("Verify projecr filter");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.verifyProjectLocationFilters();
			childTest.log(Status.PASS, "Verified project filter successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to verify project filter: " + e.getMessage());
		}
	}

	@Test(priority = 6, alwaysRun = true, dependsOnMethods = "pageRedirection")
	public void VerifyFactoryLocationFilter() {
		ExtentTest childTest = parentTest.createNode("Verify factory filter");
		ExtentReportListener.author("Abhijeet Maske");
		try {
			locationPage.verifyFactoryLocationFilters();
			childTest.log(Status.PASS, "Verified factory filter successfully");
		} catch (Exception e) {
			childTest.log(Status.FAIL, "Failed to verify factory filter: " + e.getMessage());
		}
	}
}
