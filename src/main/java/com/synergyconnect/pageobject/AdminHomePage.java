package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
//WebDriver ldriver;
	
	public AdminHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}	
	@FindBy(xpath="//span[text()='Organization Details']")
	WebElement OrganizationDetails;
	
	
	@FindBy(xpath="//span[text()='Add Organization Info']")
	WebElement AddOrganizationInfo;
	
	@FindBy(xpath="//span[text()='Add Location']")
	WebElement AddLocation;
	
	@FindBy(xpath="//span[text()='Stakeholder & User Creation']")
	WebElement StakeholderAndUserCreation;
	
	@FindBy(xpath="//span[text()='Add NGO & Non-NGO Partner']")
	WebElement AddNgoAndNonNgoPartner;
	
	@FindBy(xpath="//span[text()='Add Users']")
	WebElement AddUsers;
	
	@FindBy(xpath="//span[text()='Add Donor']")
	WebElement AddDonar;
	

	@FindBy(xpath="//span[text()='Add Board Members']")
	WebElement AddBoardMembers;
	
	@FindBy(xpath="//span[text()='Organization Documents']")
	WebElement OrganizationDocument;
	
	@FindBy(xpath="//span[text()='Add Compliance Documents']")
	WebElement AddComplianceDocuments;
	
	
	public void clickOnOrganizationDetails() {
		OrganizationDetails.click();
		}
	
	public void clickOnAddOrganizationInfo() {
		AddOrganizationInfo.click();
	}
	
	public void clickOnAddLocation() {
		AddLocation.click();
	}
	
	public void clickOnStakeholderAndUserCreation() {
		StakeholderAndUserCreation.click();
	}
	
	public void clickOnAddNgoAndNonNgoPartner() {
		AddNgoAndNonNgoPartner.click();
	}
	
	public void clickOnAddUsers() {
		AddUsers.click();
	}
	
	public void clickOnAddDonarInfo() {
		AddDonar.click();
	}
	
	public void clickOnAddBoardMembers() {
		AddBoardMembers.click();
	}
	
	public void clickOnOrganizationDocument() {
		OrganizationDocument.click();
	}
	
	public void clickOnAddComplianceDocuments() {
		AddComplianceDocuments.click();
	}
	
}
