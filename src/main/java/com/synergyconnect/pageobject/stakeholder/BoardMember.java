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
	
	public void clickOnBoardMember() {
		BoardMember.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Board Member Successfully ");

		}
	
	public void clickOnFinancialYear(String financialYear) {
		Select fy=new Select(FinancialYear);
		fy.selectByVisibleText(financialYear);
		ExtentReportListener.getExtent().log(Status.PASS, "Financial Year selected :"+financialYear);

		}
	
	public void clickOnUserName(String userName) {
		Select un=new Select(UserName);
		un.selectByVisibleText(userName);
		ExtentReportListener.getExtent().log(Status.PASS, "User Name selected :"+userName);

		}
	
	public void enterBoardMemberName(String boardMemberName) {
		BoardMemberName.sendKeys(boardMemberName);
		ExtentReportListener.getExtent().log(Status.PASS, "Board Member Name Entered :"+boardMemberName);

		}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);		
		ExtentReportListener.getExtent().log(Status.PASS, "EmailId entered :"+emailId);

		}
	
	public void clickOnDesignation(String designation) {
		Select d=new Select(Designation);
		d.selectByVisibleText(designation);
		ExtentReportListener.getExtent().log(Status.PASS, "Financial Year selected :"+designation);

		}
	
	public void enterDIN(String din) {
		Din.sendKeys(din);	
		ExtentReportListener.getExtent().log(Status.PASS, "Director Identification Number entered :"+din);

		}
	
	public void enterPanNo(String panNo) {
		Pan.sendKeys(panNo);	
		ExtentReportListener.getExtent().log(Status.PASS, "PAN entered :"+panNo);

		}
	
	public void clickOnAppointedDate() {
		AppointmentDate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Date Successfully ");

		}
	
	public void clickOnDatePick() {
		DatePicker.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Picked on Date Successfully ");

		}
	

	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Submit Successfully ");

		}
	
	
	
	
	

}
