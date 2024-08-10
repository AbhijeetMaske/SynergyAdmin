package com.synergyconnect.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AdminHome;
import com.synergyconnect.pageobject.AppDriver;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.organization.AddLocation;
import com.synergyconnect.pageobject.organization.OrganizationInfo;

public class Organization extends BaseClass{
	@Test
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyLoginisworking() throws InterruptedException {
		
		getDriver().get(url);
		logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeep@synergyconnect.in");
		Thread.sleep(500);
				
		loginPage.enterPassword("Admin@123");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		Thread.sleep(3000);
		
		String  expectedUrl="https://test30.synergyapps.in/adminhomepage";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	@Test
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyAddOrganization() throws InterruptedException {
		
		getDriver().get(url);
		logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeep@synergyconnect.in");
		Thread.sleep(500);
				
		loginPage.enterPassword("Admin@123");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		
//		ViewProgram vp=new ViewProgram(getDriver());
//		vp.clickOnToggleButton();
//		Thread.sleep(500);
//		vp.clickOnAdmin();
		AppDriver appdriver = new AppDriver(getDriver());
		appdriver.appDriverMenu();
		appdriver.adminModule();
		
		AdminHome adminHomePage=new AdminHome(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
		
		adminHomePage.clickOnAddOrganizationInfo();
		Thread.sleep(500);
		
		OrganizationInfo organizationPage=new OrganizationInfo(getDriver());
		organizationPage.organizationInfoEdit();
		Thread.sleep(500);
		
		organizationPage.organizationName();
		Thread.sleep(500);
		
		organizationPage.incorporationDate();
		Thread.sleep(500);
		
		organizationPage.DatePicker();
		Thread.sleep(500);
				
		organizationPage.shortName();
		Thread.sleep(500);
		
		organizationPage.entityType();
		Thread.sleep(500);
		
		organizationPage.cinNo();
		Thread.sleep(500);
		
		organizationPage.mcaCsrRegNo();
		Thread.sleep(500);
		
		organizationPage.entityPanNo();
		Thread.sleep(500);
		
		organizationPage.contactPerson();
		Thread.sleep(500);
		
		organizationPage.mobileNo();
		Thread.sleep(500);
		
		organizationPage.emailId();
		Thread.sleep(500);
		
		organizationPage.address_I();
		Thread.sleep(500);
		
		organizationPage.address_II();
		Thread.sleep(500);
		
		organizationPage.city();
		Thread.sleep(500);
		
		organizationPage.pincode();
		Thread.sleep(500);
		
		organizationPage.country();
		Thread.sleep(500);
		
		organizationPage.state();
		Thread.sleep(500);
		
		organizationPage.uploadLogo();
		Thread.sleep(500);
				
		organizationPage.briefDiscription();
		Thread.sleep(500);
		
		organizationPage.submit();
		Thread.sleep(15000);
		
		String csrText = organizationPage.mcaCsrRegNoText();
		Assert.assertEquals(csrText, "ABD00081234");
		
		String CinNoText = organizationPage.cinNoText();
		Assert.assertEquals(CinNoText,"L12345AA1234PLC044444" );
		
		String emailIDText = organizationPage.emailIdText();
		Assert.assertEquals(emailIDText,"tanaya@synergyconnect.in");
		}
	
	@Test(dependsOnMethods = "verifyLoginisworking",priority=1)
		public void	verifyAddLocation() throws InterruptedException {
		getDriver().get(url);
		logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeep@synergyconnect.in");
		Thread.sleep(500);
				
		loginPage.enterPassword("Admin@123");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		
//		ViewProgram vp=new ViewProgram(getDriver());
//		vp.clickOnToggleButton();
//		Thread.sleep(500);
//		vp.clickOnAdmin();
		
		AdminHome ahp=new AdminHome(getDriver());
		ahp.clickOnOrganizationDetails();
		Thread.sleep(500);
			
		ahp.clickOnAddLocation();
		Thread.sleep(2000);
		
		AddLocation al=new AddLocation(getDriver());
//			
//		al.clickOnLocationType();
//			Thread.sleep(2000);
//			
//			al.clickOncountry();
//			Thread.sleep(2000);
//			
//			al.clickOnstate();
//			Thread.sleep(2000);
//			
//			al.clickOndistrict();
//			Thread.sleep(2000);
//			
//			al.clickOnblock();
//			Thread.sleep(2000);
//			
//			al.clickOnpinCode();
//			Thread.sleep(2000);
//			
//			al.clickOnvillage();
//			Thread.sleep(2000);
//			
//			al.enterLocation();
//			Thread.sleep(2000);
//			
//			al.entershorCode();
//			Thread.sleep(2000);
//			
//			al.enterlocationLatitude();
//			Thread.sleep(2000);
//			
//			al.enterlocationLongitude();
//			Thread.sleep(2000);
			
			al.clickOnsubmit();
			Thread.sleep(2000);
			
		}
}
