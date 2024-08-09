package com.synergyconnect.pageobject;

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
	 
	public void clickOnContact() {
		Contact.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Contact Successfully ");

		}
	
	public void enterFirstName(String firstName) {
		FirstName.sendKeys(firstName);
		ExtentReportListener.getExtent().log(Status.PASS, "First Name Entered :"+firstName);

		}
	
	public void enterLastName(String laseName) {
		LastName.sendKeys(laseName);
		ExtentReportListener.getExtent().log(Status.PASS, "Last Name Entered :"+laseName);

		}
	
	public void enterDesignation(String designation) {
		Designation.sendKeys(designation);
		ExtentReportListener.getExtent().log(Status.PASS, "Designation Entered :"+designation);

		}
	public void clickOnDecisionMarker() {
		DecisionMarker.sendKeys();
		ExtentReportListener.getExtent().log(Status.PASS, "Clicked on Decision Marker Successfully ");

		}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "EmailId Entered :"+emailId);

		}
	
	public void enterMobileNumber(String mobileNumber) {
		MobileNumber.sendKeys(mobileNumber);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number Entered :"+mobileNumber);

		}
	
	public void enterComment(String comment) {
		Comment.sendKeys(comment);
		ExtentReportListener.getExtent().log(Status.PASS, "Comment Entered :"+comment);

		}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Clicked on Submit Successfully ");

		}
	
	

}
