package com.synergyconnect.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AddLocation;
import com.synergyconnect.pageobject.AdminHomePage;
import com.synergyconnect.pageobject.BulkLocation;
import com.synergyconnect.pageobject.CsrCompanyDetails;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.Organization;
import com.synergyconnect.pageobject.SubOrganizationList;
import com.synergyconnect.pageobject.ViewProgram;
import com.synergyconnect.pageobject.Validation;

public class OrganizationDetails extends BaseClass{
	
	@Test(priority=1)
	public void verifyLoginisworking() throws InterruptedException {
		
		getDriver().get(url);
		Logger.info("url opeed");
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
	@Test(dependsOnMethods = "verifyLoginisworking",priority=2)
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
		
//		ViewProgram viewprogram=new ViewProgram(getDriver());
//		viewprogram.clickOnToggleButton();
//		Thread.sleep(1000);
//		viewprogram.clickOnAdmin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
//		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
		
		adminHomePage.clickOnAddOrganizationInfo();
		Thread.sleep(500);
		
			
		Organization organizationPage=new Organization(getDriver());
		organizationPage.clickOnEdit();
		Thread.sleep(500);
		
		organizationPage.enterOrganizationName("SynergyConnect Foundation");
		Thread.sleep(500);
		
		organizationPage.clickOnIncorporationDate();
		Thread.sleep(500);
		
		organizationPage.DatePicker();
		Thread.sleep(500);
				
		organizationPage.enterShortName("SCFDI");
		Thread.sleep(500);
		
		organizationPage.clickOnEntityType("Entity Established under and Act of Parliament of State Legislature");
		Thread.sleep(2000);
		
		organizationPage.enterCinNo("L12345AA1234PLC044444");
		Thread.sleep(2000);
		
		organizationPage.enterCRN("");
		
		organizationPage.enterCsrRegNo("ABD00081234");
		Thread.sleep(500);
		
		organizationPage.enterEntityPanNo("AFDHA1789A");
		Thread.sleep(500);
		
		organizationPage.enterContactPerson("Kuldeep Hirde");
		Thread.sleep(500);
		
		organizationPage.enterMobileNo("9175437343");
		Thread.sleep(500);
		
		organizationPage.enterEmailId("kuldeep@synergyconnect.in");
		Thread.sleep(500);
		
				
		organizationPage.enterAddressL1("Near RBL Bank, Gokhle Road");
		Thread.sleep(500);
		
		organizationPage.enterAddressL2("Dadar West");
		Thread.sleep(500);
		
		organizationPage.enterCity("Mumbai");
		Thread.sleep(500);
		
		organizationPage.enterPincode("400002");
		Thread.sleep(500);
		
		organizationPage.clickOnCountry("India");
		Thread.sleep(500);
		
		organizationPage.clickOnState("Maharashtra");
		Thread.sleep(500);
		
		//organizationPage.clickOnUploadLogo();
		Thread.sleep(500);
				
		organizationPage.enterBriefDiscription("Driving Excellence for NGOs, Corporate CSR, and Foundations.\r\n"
				+ "Embracing the evolving role of technology, we enable NGOs and corporate CSR and foundations to harness its power in driving operational excellence to maximize their social impact and create a sustainable future");
		Thread.sleep(500);
		
		organizationPage.clickOnSubmit();
		Thread.sleep(15000);
		
		String csrText = organizationPage.getCSRText();
		System.out.println("Actua CSR : "+csrText);
		Assert.assertEquals(csrText, "ABD00081234");
		Validation validation = new Validation(getDriver());
		
		String CinNoText=validation.getCINText();
		System.out.println("Actual CinNo : "+ CinNoText);
		Assert.assertEquals(CinNoText,"L12345AA1234PLC044444" );
		
		String EmailIdText=validation.getEmailId();
		System.out.println("Actual EmailId : "+EmailIdText);
		Assert.assertEquals(EmailIdText,"kuldeep@synergyconnect.in" );

		String EntityTypeText=validation.getEntityType();
		System.out.println("Actual Entity Type : "+EntityTypeText);
		Assert.assertEquals(EntityTypeText,"Entity Established under and Act of Parliament of State Legislature" );

//		String PanNoText=organizationPage.getPanNo();
//		System.out.println("Actual PanNo: "+ PanNoText);
//		Assert.assertEquals(PanNoText, PanNoText);
		
		
		
		}
	@Test(dependsOnMethods = "verifyLoginisworking",priority=5)
		public void	verifyAddLocation() throws InterruptedException {
		getDriver().get(url);
		Logger.info("url opened");
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
//		Thread.sleep(500);
//		viewprogram.clickOnAdmin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
			
		adminHomePage.clickOnAddLocation();
		Thread.sleep(2000);
		
		AddLocation addLocation=new AddLocation(getDriver());
		
			addLocation.clickOnLocation();
			Thread.sleep(1000);
		
		 	addLocation.clickOnLocationType("Office");
			Thread.sleep(2000);
			
			addLocation.clickOncountry("India");
			Thread.sleep(2000);
			
			addLocation.clickOnstate("Maharashtra");
			Thread.sleep(2000);
			
			addLocation.clickOndistrict("Amravati");
			Thread.sleep(2000);
			
			addLocation.clickOnblock("Chandurbazar");
			Thread.sleep(2000);
			
			addLocation.clickOnpinCode("444704");
			Thread.sleep(2000);
			
			addLocation.clickOnvillage("Chandur bazar");
			Thread.sleep(2000);
			
			addLocation.enterLocation("Amravati");
			Thread.sleep(2000);
			
			addLocation.entershorCode("AMI");
			Thread.sleep(2000);
			
			addLocation.enterlocationLatitude("196");
			Thread.sleep(2000);
			
			addLocation.enterlocationLongitude("200");
			Thread.sleep(2000);
			
			addLocation.clickOnsubmit();
			Thread.sleep(2000);
			
		}
	@Test(priority=3)
	public void verifyCsrCompanyDetails() throws InterruptedException {
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
		
//		ViewProgram viewprogram=new ViewProgram(getDriver());
//		viewprogram.clickOnToggleButton();
//		Thread.sleep(1000);
//		viewprogram.clickOnAdmin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
		
		adminHomePage.clickOnAddOrganizationInfo();
		Thread.sleep(500);
		
			
//		Organization organizationPage=new Organization(getDriver());
//		organizationPage.clickOnEdit();
//		Thread.sleep(500);
//		
		CsrCompanyDetails csr=new CsrCompanyDetails(getDriver());
		
		csr.clickOnEdit();
		Thread.sleep(1000);
		
		csr.clickOnAdd();
		Thread.sleep(1000);
		
		csr.enterCompanyName("SCDIE Foundation");
		Thread.sleep(1000);
		
		csr.enterCinNo("L92345AA1234PLC042438");
		Thread.sleep(1000);
		
		csr.enterShortName("SCF");
		Thread.sleep(1000);
		
		csr.enterCsrManager("Nirav Vaidya");
		Thread.sleep(1000);
		
		csr.enterMobileNo("9775372735");
		Thread.sleep(1000);
		
		csr.enterCity("Mumbai");
		Thread.sleep(1000);
		
		csr.clickOnState("Maharashtra");
		Thread.sleep(1000);
		
		csr.clickOnAddCsr();
		Thread.sleep(2000);
		
		//csr.entercsrName("SCDI");
		Thread.sleep(10000);
		
//		Validation validation = new Validation(getDriver());
//		
//		String CSRdetailsText=Validation.getCSRdetails();
//		System.out.println("Actual CSR Name : "+CSRdetailsText);
//		Assert.assertEquals(CSRdetailsText,"SCDI Foundation" );
//		Thread.sleep(10000);
		
		
		
		
		
	}
	
	@Test(priority=4)
	public void verifySubOrganizationList() throws InterruptedException {
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
		
//		ViewProgram viewprogram=new ViewProgram(getDriver());
//		viewprogram.clickOnToggleButton();
//		Thread.sleep(1000);
//		viewprogram.clickOnAdmin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
		
		adminHomePage.clickOnAddOrganizationInfo();
		Thread.sleep(500);
		
		SubOrganizationList suborganization=new SubOrganizationList(getDriver());
		suborganization.clickOnEdit();
		Thread.sleep(2000);
		
		suborganization.clickOnAdd();
		Thread.sleep(1000);
		
		suborganization.enterOrgName("Nabard Foundation");
		Thread.sleep(1000);
		
		suborganization.clickOnIncorporationDate();
		Thread.sleep(1000);
		
		suborganization.clickOnDatepick();
		Thread.sleep(1000);
		
		suborganization.enterShortName("SCF");
		Thread.sleep(1000);
		
		suborganization.clickOnTypeOfOrganization("Corporate Foundation");
		Thread.sleep(1000);
		
		suborganization.clickOnOrgType("Registered Public Trust with 12A and 80G");
		Thread.sleep(1000);
		
		suborganization.enterCinNo("L12345AA1834PLC012345");
		Thread.sleep(1000);
		
		suborganization.enterCsrRegNo("12345678901");
		Thread.sleep(1000);
		
		suborganization.enterPanNo("BHLPH6252K");
		Thread.sleep(1000);
		
		suborganization.enterBriefIntro("Driving Excellence for NGOs, Corporate CSR, and Foundations.\\r\\n\"\r\n"
				+ "				+ \"Embracing the evolving role of technology, we enable NGOs and corporate CSR and foundations to harness its power in driving operational excellence to maximize their social impact and create a sustainable future");
		Thread.sleep(1000);
		
		suborganization.enterName("Kuldeep Hirde");
		Thread.sleep(1000);
		
		suborganization.enterMobNo("9175437343");
		Thread.sleep(1000);
		
		suborganization.enterEmailId("kuldeephirde02@gmail.com");
		Thread.sleep(1000);
		
		suborganization.enterAddressL1("Near RBL Bank, Gokhle Road");
		Thread.sleep(1000);
		
		suborganization.enterAddressL2("Dadar West");
		Thread.sleep(1000);
		
		suborganization.clickOnCountry("India");
		Thread.sleep(1000);
		
		suborganization.clickOnState("Maharashtra");
		Thread.sleep(1000);
		
		suborganization.enterCity("Mumbai");
		Thread.sleep(1000);
		
		suborganization.enterPincode("400002");
		Thread.sleep(1000);
		
		suborganization.clickOnAddSubOrg();
		Thread.sleep(10000);
	
	}
	@Test(priority=6)
	public void	verifyBulkLocation() throws InterruptedException {
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
		
//		ViewProgram viewprogram=new ViewProgram(getDriver());
//		viewprogram.clickOnToggleButton();
//		Thread.sleep(500);
//		viewprogram.clickOnAdmin();
		
		String  expectedUrl="https://test30.synergyapps.in/myworkspace";
		String actualUrl = loginPage.getHompageUrl();
		System.out.println("actualUrl :"+actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		AdminHomePage adminHomePage=new AdminHomePage(getDriver());
		adminHomePage.clickOnOrganizationDetails();
		Thread.sleep(500);
			
		adminHomePage.clickOnAddLocation();
		Thread.sleep(2000);
		
		BulkLocation bulkLocation=new BulkLocation(getDriver());
		
		bulkLocation.clickOnBulkLocaion();
		Thread.sleep(1000);
		
		bulkLocation.UploadFile();
		Thread.sleep(1000);
		
		bulkLocation.clickOnSubmit();
		Thread.sleep(10000);
	
	
	}
	
	
	
}
