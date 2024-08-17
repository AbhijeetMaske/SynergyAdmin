package com.synergyconnect.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.utilities.ExtentReportListener;

public class Login extends BaseClass {
	private ExtentTest parentTest;

	@BeforeClass
	public void setUp() {
		parentTest = ExtentReportListener.createParentTest("Login Test", "Verify that login functionality works")
				.assignAuthor("Abhijeet Maske");
		ExtentReportListener.tags("Regression", "Smoke");
		LoginPage loginPage = new LoginPage(getDriver());
	}

	@Test(priority = 1, testName = "Login Test", alwaysRun = true)
	public void verifyLoginIsWorking() throws InterruptedException {

		ExtentTest childTest = parentTest.createNode("Login Functionality Test");
		LoginPage loginPage = new LoginPage(getDriver());

		try {
			getDriver().get(url);
			getDriver().manage().window().maximize();
			loginPage.portalLogin();
			childTest.log(Status.INFO, "Portal Logged successfully");

			loginPage.getHompageUrl();
			logger.info("Validated homepage URL");
			childTest.log(Status.INFO, "Validated homepage URL");

			loginPage.synergyAdmin();
			logger.info("Redirected to Synergy Admin");
			childTest.log(Status.PASS, "Redirected to Synergy Admin");

		} catch (Exception e) {
			logger.error("Test case verifyLoginIsWorking failed: " + e.getMessage());
			childTest.log(Status.FAIL, "Test case verifyLoginIsWorking failed: " + e.getMessage());
		}
	}
}
