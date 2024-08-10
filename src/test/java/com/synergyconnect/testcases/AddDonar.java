package com.synergyconnect.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AdminHome;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.stakeholder.AddDonarInfo;
import com.synergyconnect.pageobject.stakeholder.Contact;
import com.synergyconnect.pageobject.stakeholder.Corporate;
import com.synergyconnect.pageobject.stakeholder.Goals;
import com.synergyconnect.pageobject.stakeholder.NpbtDetails;
import com.synergyconnect.pageobject.stakeholder.PreferedLocation;

public class AddDonar extends BaseClass {
	@Test(priority=11)
	public void verifyLoginisworking() throws InterruptedException {
		
		getDriver().get(url);
		//Logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeephirde02@gmail.com");
		Thread.sleep(500);
				
		loginPage.enterPassword("Admin@123123");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		Thread.sleep(2000);
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	@Test(dependsOnMethods = "verifyLoginisworking",priority=12)
	public void verifyAddDonarInfo() throws InterruptedException {
		
		getDriver().get(url);
		//Logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeep@synergyconnect.in");
		Thread.sleep(500);
				
		loginPage.enterPassword("Admin@123");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHome adminHomePage=new AdminHome(getDriver());
		adminHomePage.clickOnStakeholderAndUserCreation();
		Thread.sleep(1000);
		
		adminHomePage.clickOnAddDonarInfo();
		Thread.sleep(2000);
		
		AddDonarInfo addDonarInfo=new AddDonarInfo(getDriver());
		
		addDonarInfo.clickOnDonar();
		Thread.sleep(2000);
		
		addDonarInfo.enterOrganizationName("NABARD");
		Thread.sleep(1000);
		
		addDonarInfo.enterShortCode("NABA");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnDonarCategory("Government");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnSource("Existing Donor");
		Thread.sleep(1000);
		
		addDonarInfo.enterPanNo("NOPSI8745K");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnBoardDate();
		Thread.sleep(1000);
		
		addDonarInfo.clickOnDatePicker();
		Thread.sleep(1000);
		
		addDonarInfo.clickOnCsrActivity("Yes");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnFundType("CSR");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnRelationshipManager("vishal tatkari");
		Thread.sleep(1000);
				
		addDonarInfo.clickOnIndianCitizen();
		Thread.sleep(1000);
		
		addDonarInfo.enterAddress("Bandra Kurla Complex rd, G block BKC, Bandra East, Mumbai");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnCountry("India");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnState("Maharashtra");
		Thread.sleep(1000);
		
		addDonarInfo.enterCity("Bandra");
		Thread.sleep(1000);
		
		addDonarInfo.enterPincode("400051");
		Thread.sleep(1000);
		
		addDonarInfo.enterMobileNo("9665484875");
		Thread.sleep(1000);
		
		addDonarInfo.enterEmailId("vishal@synergyconnect.in");
		Thread.sleep(1000);
		
		addDonarInfo.clickOnSubmit();
		Thread.sleep(5000);
	}
		
		@Test(dependsOnMethods = "verifyLoginisworking",priority=13)
		public void verifyDonarContents() throws InterruptedException {
			
			getDriver().get(url);
			//Logger.info("url opeed");
			Thread.sleep(500);
			getDriver().manage().window().maximize();
			Thread.sleep(500);
			
			LoginPage loginPage=new LoginPage(getDriver());
			loginPage.enterUserid("kuldeep@synergyconnect.in");
			Thread.sleep(500);
					
			loginPage.enterPassword("Admin@123");
			Thread.sleep(500);
			loginPage.clickOnLogin();
			
			String  expectedUrl="https://test30.synergyapps.in/myworkspace";
			String actualUrl = loginPage.getHompageUrl();
			System.out.println("actualUrl :"+actualUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			
			AdminHome adminHomePage=new AdminHome(getDriver());
			adminHomePage.clickOnStakeholderAndUserCreation();
			Thread.sleep(1000);
			
			adminHomePage.clickOnAddDonarInfo();
			Thread.sleep(2000);
				
		NpbtDetails npbtdetails=new NpbtDetails(getDriver());	
		
		npbtdetails.enterSearchName("NABARD");
		Thread.sleep(2000);
		
		npbtdetails.clickOnEditDonar();
		Thread.sleep(3000);
		
		npbtdetails.clickOnNPBTdetails();
		Thread.sleep(2000);
		
		npbtdetails.clickOnFinancialYear("2023-2024");
		Thread.sleep(2000);
		
		npbtdetails.enterNPBTamount("9");
		Thread.sleep(2000);
		
		//npbtdetails.enterCsrBudget("");
		//Thread.sleep(1000);
		
		npbtdetails.clickOnSubmit();
		Thread.sleep(3000);
		
		
		npbtdetails.clickOnGoals();
		Thread.sleep(2000);
		
		Goals goals=new Goals(getDriver());
		
		goals.clickOnShedule7();
		Thread.sleep(1000);
		
		goals.clickOnEradicatingHunger();
		Thread.sleep(1000);
		
		goals.clickOnPromotingEducation();
		Thread.sleep(1000);
		
		goals.clickOnPromotingGenderEquality();
		Thread.sleep(1000);
		
		goals.clickOnMeasureForBenifits();
		Thread.sleep(1000);
		
		goals.clickOnRuralDevelopment();
		Thread.sleep(1000);
		
		goals.clickOnSlumAreaDevelopment();
		Thread.sleep(1000);
		
		goals.clickOnSDGs();
		Thread.sleep(1000);
		
		goals.clickOnNoPoverty();
		Thread.sleep(1000);
		
		goals.clickOnZeroHunger();
		Thread.sleep(1000);
		
		goals.clickOnGenderEquality();
		Thread.sleep(1000);
		
		goals.clickOnQualityEducation();
		Thread.sleep(1000);
		
		goals.clickOnClimateAction();
		Thread.sleep(1000);
		
		goals.clickOnReduceInequality();
		Thread.sleep(1000);
		
		goals.clickOnSave();
		Thread.sleep(5000);
		
		Contact contact=new Contact(getDriver());
		
		contact.clickOnContact();
		Thread.sleep(1000);
		
		contact.enterFirstName("Abhijeet");
		Thread.sleep(1000);
		
		contact.enterLastName("Maske");
		Thread.sleep(1000);
		
		contact.enterDesignation("Project Manager");
		Thread.sleep(1000);
		
		//contact.clickOnDecisionMarker();
		//Thread.sleep(1000);
		
		contact.enterEmailId("abhijeet@synergyconnect.in");
		Thread.sleep(1000);
		
		contact.enterMobileNumber("9529854643");
		Thread.sleep(1000);
		
		contact.enterComment("Verify contact is successfully ");
		Thread.sleep(1000);
		
		contact.clickOnSubmit();
		Thread.sleep(3000);
		
		PreferedLocation preferedlocation=new PreferedLocation(getDriver());
		
		preferedlocation.clickOnPreferdLocation();
		Thread.sleep(1000);
		
		preferedlocation.clickOnPreferedCountry("United States Of America");
		Thread.sleep(1000);
		
		preferedlocation.clickOnState("New Jersey");
		Thread.sleep(1000);
		
		preferedlocation.clickOnSubmit();
		Thread.sleep(3000);
		
		Corporate corporate=new Corporate(getDriver());
		
		corporate.clickOnCorporate();
		Thread.sleep(1000);
		
		corporate.clicOnCompanyType();
		Thread.sleep(1000);
		
		corporate.clickOnSubmit();
		Thread.sleep(1000);
				
		
		}
	}
	
	

	

