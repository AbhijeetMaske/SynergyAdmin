package com.synergyconnect.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AddLocation;
import com.synergyconnect.pageobject.AdminHomePage;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.Organization;
import com.synergyconnect.pageobject.ViewProgram;
import com.synergyconnect.pageobject.XYZ;

public class AdminSynergyConnect extends BaseClass{
	
	@Test
	public void verifyLoginisworking() throws InterruptedException {
		
		getDriver().get(url);
		Logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(1000);
		
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.enterUserid("kuldeep@synergyconnect.in");
		Thread.sleep(1000);
				
		loginPage.enterPassword("Admin@123");
		System.out.println("paswword entered");
		Thread.sleep(500);
		loginPage.clickOnLogin();
		Thread.sleep(3000);
		
		String  expectedUrl="https://test30.synergyapps.in/adminhomepage";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	@Test()
	public void verifyAddOrganization() throws InterruptedException {
		
		getDriver().get(url);
		Logger.info("url opeed");
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
		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
		
		adminHomePage.clickOnAddOrganizationInfo();
		Thread.sleep(500);
		
	
		
		
		Organization organizationPage=new Organization(getDriver());
		organizationPage.clickOnEdit();
		Thread.sleep(500);
		
		organizationPage.enterOrganizationName();
		Thread.sleep(500);
		
		organizationPage.clickOnIncorporationDate();
		Thread.sleep(500);
		
		organizationPage.DatePicker();
		Thread.sleep(500);
				
		organizationPage.enterShortName();
		Thread.sleep(500);
		
		organizationPage.clickOnEntityType();
		Thread.sleep(500);
		
		organizationPage.enterCinNo();
		Thread.sleep(500);
		
		organizationPage.enterCsrRegNo();
		Thread.sleep(500);
		
		organizationPage.enterEntityPanNo();
		Thread.sleep(500);
		
		organizationPage.enterContactPerson();
		Thread.sleep(500);
		
		organizationPage.enterMobileNo();
		Thread.sleep(500);
		
		organizationPage.enterEmailId();
		Thread.sleep(500);
		
		organizationPage.enterAddress1();
		Thread.sleep(500);
		
		organizationPage.enterAddress2();
		Thread.sleep(500);
		
		organizationPage.enterCity();
		Thread.sleep(500);
		
		organizationPage.enterPincode();
		Thread.sleep(500);
		
		organizationPage.clickOnCountry();
		Thread.sleep(500);
		
		organizationPage.clickOnState();
		Thread.sleep(500);
		
		organizationPage.clickOnUploadLogo();
		Thread.sleep(500);
				
		organizationPage.enterBriefDiscription();
		Thread.sleep(500);
		
		organizationPage.clickOnSubmit();
		Thread.sleep(15000);
		
		String csrText = organizationPage.getCSRText();
		System.out.println("Actua CSR : "+csrText);
		Assert.assertEquals(csrText, "ABD00081234");
		XYZ xy = new XYZ(getDriver());
		
		String CinNoText=xy.getCINText();
		System.out.println("Actual CinNo : "+ CinNoText);
		Assert.assertEquals(CinNoText,"L12345AA1234PLC044444" );
		
//		String PanNoText=organizationPage.getPanNo();
//		System.out.println("Actual PanNo: "+ PanNoText);
//		Assert.assertEquals(PanNoText, PanNoText);
		
		
		
		}
	@Test(dependsOnMethods = "verifyLoginisworking",priority=1)
		public void	verifyAddLocation() throws InterruptedException {
		getDriver().get(url);
		Logger.info("url opeed");
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
		
		AdminHomePage ahp=new AdminHomePage(getDriver());
		ahp.clickOnOrganizationDetails();
		Thread.sleep(500);
			
		ahp.clickOnAddLocation();
		Thread.sleep(2000);
		
		AddLocation al=new AddLocation(getDriver());
			
		al.clickOnLocationType();
			Thread.sleep(2000);
			
			al.clickOncountry();
			Thread.sleep(2000);
			
			al.clickOnstate();
			Thread.sleep(2000);
			
			al.clickOndistrict();
			Thread.sleep(2000);
			
			al.clickOnblock();
			Thread.sleep(2000);
			
			al.clickOnpinCode();
			Thread.sleep(2000);
			
			al.clickOnvillage();
			Thread.sleep(2000);
			
			al.enterLocation();
			Thread.sleep(2000);
			
			al.entershorCode();
			Thread.sleep(2000);
			
			al.enterlocationLatitude();
			Thread.sleep(2000);
			
			al.enterlocationLongitude();
			Thread.sleep(2000);
			
			al.clickOnsubmit();
			Thread.sleep(2000);
			
		}
}
