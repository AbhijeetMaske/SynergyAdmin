package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class Contact {
public Contact(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="contact-tab")
	WebElement Contact;
	
	@FindBy(id="firstNm")
	WebElement FirstName;
	
	@FindBy(id="lastNm")
	WebElement LastName;
	
	@FindBy(id="designation")
	WebElement Designation;
	
	@FindBy(xpath="(//input[@id='decision'])[1]")
	WebElement DecisionMarker;
	
	@FindBy(id="emailId")
	WebElement EmailId;
	
	@FindBy(id="contactNumber")
	WebElement MobileNumber;
	
	@FindBy(id="comment")
	WebElement Comment;
	
	@FindBy(xpath="(//button[text()='Submit'])[4]")
	WebElement Submit;	

}
