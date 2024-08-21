package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class BoardMember {
public BoardMember(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=' Board Member']")
	WebElement BoardMember;
	
	@FindBy(id="financialYear")
	WebElement FinancialYear;
	
	@FindBy(id="user")
	WebElement UserName;
	
	@FindBy(id="boardMemberName")
	WebElement BoardMemberName;
	
	@FindBy(id="emailId")
	WebElement EmailId;
	
	@FindBy(id="designation")
	WebElement Designation;
	
	@FindBy(id="din")
	WebElement Din;
	
	@FindBy(id="pan")
	WebElement Pan;
	
	@FindBy(xpath="//input[@id='appointmentDate']")
	WebElement AppointmentDate;
	
	@FindBy(xpath="//td[@data-date='04/06/2024']")
	WebElement DatePicker;
	
	@FindBy(id="submitboardMemBtn")
	WebElement Submit;

}
