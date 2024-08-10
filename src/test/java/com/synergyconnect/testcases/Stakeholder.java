package com.synergyconnect.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AdminHome;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.ViewProgram;
import com.synergyconnect.pageobject.stakeholder.AddUsers;
import com.synergyconnect.pageobject.stakeholder.NgoPartners;
import com.synergyconnect.pageobject.stakeholder.NonNgoPartners;

public class Stakeholder extends BaseClass {
	@Test(priority=7)
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
		Thread.sleep(3000);
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	@Test(dependsOnMethods = "verifyLoginisworking",priority=8)
	public void verifyNgoPartners() throws InterruptedException {
		
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
		
//		ViewProgram viewprogram=new ViewProgram(getDriver());
//		viewprogram.clickOnToggleButton();
//		Thread.sleep(1000);
//		viewprogram.clickOnAdmin();
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHome adminHomePage=new AdminHome(getDriver());
		adminHomePage.clickOnStakeholderAndUserCreation();
		Thread.sleep(1000);
		
		adminHomePage.clickOnAddNgoAndNonNgoPartner();
		Thread.sleep(1000);
		
		NgoPartners ngopartners=new NgoPartners(getDriver());
		
		ngopartners.enterNgoName("NGO NonNGO partnrs");
		Thread.sleep(5000);
		
		ngopartners.clickOnNgoSearch();
		Thread.sleep(1000);
		
		ngopartners.clickOnNgoUpload();
		Thread.sleep(1000);
		
		ngopartners.enterOrgName("Synergy Connect Data Innovation");
		Thread.sleep(1000);
		
		ngopartners.clickOnEntityType("Registered Society with 12A and 80G");
		Thread.sleep(1000);
		
		ngopartners.enterCinRegNo("L12345AA1234PLC044444");
		Thread.sleep(1000);
		
		ngopartners.enterCsrRegNo("ABD00081234");
		Thread.sleep(1000);
		
		ngopartners.clickOnCategory("National");
		Thread.sleep(1000);
		
		ngopartners.enterLocation("Mumbai");
		Thread.sleep(1000);
		
		ngopartners.enterContactPerson("Kuldeep Hirde");
		Thread.sleep(1000);
		
		ngopartners.enterMobileNo("9175437343");
		Thread.sleep(1000);
		
		ngopartners.enterEmailId("kuldeephirde02@gmail.com");
		Thread.sleep(1000);
		
		ngopartners.clickOnCountry("India");
		Thread.sleep(1000);
		
		ngopartners.clickOnState("Maharashtra");
		Thread.sleep(1000);
		
		ngopartners.clickOnDistrict("Amravati");
		Thread.sleep(1000);
		
		ngopartners.enterAddress("Amravati Road, Chandur Bazar");
		Thread.sleep(1000);
		
		ngopartners.enterPincode("444704");
		Thread.sleep(1000);
		
		ngopartners.clickOnSubmit();
		Thread.sleep(15000);
				
	}
	@Test(priority=9)
public void verifyNonNgoPartners() throws InterruptedException {
		
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
		
		adminHomePage.clickOnAddNgoAndNonNgoPartner();
		Thread.sleep(1000);
	
		NonNgoPartners nonngopartners=new NonNgoPartners(getDriver());
		
		nonngopartners.clickOnNonNgoPartners();
		Thread.sleep(1000);
		
		nonngopartners.clickOnNonNgoPartner();
		Thread.sleep(1000);
		
		nonngopartners.enterOrganizationName("Nabard Foundations");
		Thread.sleep(1000);
		
		nonngopartners.clickOnPartnerCategory("Finance Partner");
		Thread.sleep(1000);
		
		nonngopartners.enterCinNo("L12345AA2234PLC044444");
		Thread.sleep(1000);
		
		nonngopartners.enterContactPerson("Kuldeep Hirde");
		Thread.sleep(1000);
		
		nonngopartners.enterMobileNo("9898897854");
		Thread.sleep(0);
		
		nonngopartners.enterEmailId("kuldeep@synergyconnect.in");
		Thread.sleep(1000);
		
		nonngopartners.enterDepartment("QA");
		Thread.sleep(1000);
		
		nonngopartners.enterAddress("ShriKrishna Nagar, Sangola Road, Solapur   ");
		Thread.sleep(1000);
		
		nonngopartners.enterCity("Pandharpur");
		Thread.sleep(1000);
		
		nonngopartners.enterPincode("444878");
		Thread.sleep(1000);
		
		nonngopartners.clickOnCountry("India");
		Thread.sleep(1000);
		
		nonngopartners.clickOnState("Maharashtra");
		Thread.sleep(1000);
		
		nonngopartners.clickOnSubmit();
		Thread.sleep(10000);
	
	}
	@Test(priority=10)
	public void verifyAddUsers() throws InterruptedException {
			
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
			
			adminHomePage.clickOnAddUsers();
			Thread.sleep(3000);
			
			AddUsers addusers=new AddUsers(getDriver());
			
			addusers.clickOnUser();
			Thread.sleep(2000);
			
			addusers.enterFirstName("Kuldeep");
			Thread.sleep(1000);
			
			addusers.enterMiddleName("Bhashkarrao");
			Thread.sleep(1000);
			
			addusers.enterLastName("Hirde");
			Thread.sleep(1000);
			
			addusers.clickOnGender("Male");
			Thread.sleep(1000);
			
			addusers.clickOnDesignation("Engineering Student");
			Thread.sleep(1000);
			
			addusers.enterEmailId("kuldeephirde21@gmail.com");
			Thread.sleep(1000);
			
			addusers.enterMobileNo("9175437343");
			Thread.sleep(1000);
			
			addusers.clickOnUserType("Internal");
			Thread.sleep(1000);
			
			addusers.clickOnAssignRole("Project Manager");
			Thread.sleep(1000);
			
			addusers.clickOnDepartment("Testing");
			Thread.sleep(1000);
			
			addusers.clickOnLocationType("Office");
			Thread.sleep(1000);
			
			addusers.clickOnLocation("Mumbai");
			Thread.sleep(1000);
			
			addusers.clickOnReportingTo("vishal tatkari");
			Thread.sleep(1000);
			
			addusers.enterEmployeeCode("E0158");
			Thread.sleep(1000);
			
			addusers.clickOnAddAdvanceDetails();
			Thread.sleep(1000);
			
			addusers.enterDomainExperties("Healthcare");
			Thread.sleep(1000);
			
			addusers.enterTotalExperience("3");
			Thread.sleep(1000);
			
			addusers.clickOnWorkTime("Full Time");
			Thread.sleep(1000);
			
			addusers.clickOnWorkingSince();
			Thread.sleep(1000);
			
			addusers.clickOnDate();
			Thread.sleep(2000);
			
			addusers.clickOnAdd();
			Thread.sleep(5000);
	
	}
}
