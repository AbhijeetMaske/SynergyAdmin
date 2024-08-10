package com.synergyconnect.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AdminHome;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.stakeholder.BoardMember;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddBoardMembers extends BaseClass {
	@Test(priority=14)
	public void verifyAddBoardMembersInfo() throws InterruptedException {
		
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
		
		adminHomePage.clickOnAddBoardMembers();
		Thread.sleep(2000);
		
		BoardMember boardmember=new BoardMember(getDriver());
		
		boardmember.clickOnBoardMember();
		Thread.sleep(1000);
		
		boardmember.clickOnFinancialYear("2024-2025");
		Thread.sleep(1000);
		
		boardmember.clickOnUserName("Nilesh Khanolkar");
		Thread.sleep(1000);
		
		//boardmember.enterBoardMemberName("");
		Thread.sleep(1000);
		
		//boardmember.enterEmailId("nilesh@synergyconnect.in");
		Thread.sleep(1000);
		
		boardmember.clickOnDesignation("Director");
		Thread.sleep(1000);
		
		boardmember.enterDIN("9876543210");
		Thread.sleep(1000);
		
		boardmember.enterPanNo("BLFAE8526Q");
		Thread.sleep(1000);
		
		boardmember.clickOnAppointedDate();
		Thread.sleep(2000);
		
			
		//boardmember.clickOnDatePick();
		Thread.sleep(2000);
		
		boardmember.clickOnSubmit();
		Thread.sleep(1000);
		
	}
	

}
