package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class AddUsers {
public AddUsers(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="addbtnuser")
	WebElement User;
	
	@FindBy(id="firstName")
	WebElement FirstName;
	
	@FindBy(id="middleName")
	WebElement MiddleName;
	
	@FindBy(id="lastName")
	WebElement LastName;
	
	@FindBy(id="gender")
	WebElement Gender;
	
	@FindBy(id="userDesignation")
	WebElement Designation;
	
	@FindBy(id="userEmail")
	WebElement EmailId;
	
	@FindBy(id="userContact")
	WebElement MobileNo;
	
	@FindBy(id="userType")
	WebElement UserType;
	
	@FindBy(id="userRole")
	WebElement AssignRole;
	
	@FindBy(id="department")
	WebElement Department;
	
	@FindBy(id="locationType")
	WebElement LocationType;
	
	@FindBy(id="location")
	WebElement Location;
	
	@FindBy(id="reporteeId")
	WebElement ReportingTo;
	
	@FindBy(id="employeeId")
	WebElement EmployeeCode;
	
	@FindBy(xpath="//span[@class='custom-switch-indicator']")
	WebElement AddAdvanceDetails;
	
	@FindBy(id="specialization")
	WebElement DomainExperties;
	
	@FindBy(id="workExperience")
	WebElement TotalExperience;
	
	@FindBy(id="workTime")
	WebElement WorkTime;
	
	@FindBy(id="workStart")
	WebElement WorkingSince;
	
	@FindBy(xpath="(//td[text()='30'])[2]")
	WebElement DatePicker;
	
	
	@FindBy(id="userbtn")
	WebElement Add;
	
	public void clickOnUser() {
		User.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Add Clicked Successfully ");

		}
	
	public void enterFirstName(String firstName) {
		FirstName.sendKeys(firstName);
		ExtentReportListener.getExtent().log(Status.PASS, "First Name Entered :"+firstName);

		}
	
	public void enterMiddleName(String middleName) {
		MiddleName.sendKeys(middleName);
		ExtentReportListener.getExtent().log(Status.PASS, "Middle Name Entered :"+middleName);

		}
	
	public void enterLastName(String lastName) {
		LastName.sendKeys(lastName);
		ExtentReportListener.getExtent().log(Status.PASS, "Last Name Entered :"+lastName);

		}
	
	public void clickOnGender(String gender) {
		Select g=new Select(Gender);
		g.selectByVisibleText(gender);
		ExtentReportListener.getExtent().log(Status.PASS, "Gender selected :"+gender);

		}
	
	public void clickOnDesignation(String designation) {
		Select d=new Select(Designation);
		d.selectByVisibleText(designation);
		ExtentReportListener.getExtent().log(Status.PASS, "Designation selected :"+designation);

		}
	
	public void enterEmailId(String emailId) {
		EmailId.sendKeys(emailId);
		ExtentReportListener.getExtent().log(Status.PASS, "Email ID Entered :"+emailId);

		}
	
	public void enterMobileNo(String mobileNo) {
		MobileNo.sendKeys(mobileNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number Entered :"+mobileNo);

		}
	
	public void clickOnUserType(String userType) {
		Select ut=new Select(UserType);
		ut.selectByVisibleText(userType);
		ExtentReportListener.getExtent().log(Status.PASS, "User type selected :"+userType);

		}
	
	public void clickOnAssignRole(String assignRole) {
		Select ar=new Select(AssignRole);
		ar.selectByVisibleText(assignRole);
		ExtentReportListener.getExtent().log(Status.PASS, "Assign Role selected :"+assignRole);

		}
	
	public void clickOnDepartment(String department) {
		Select d=new Select(Department);
		d.selectByVisibleText(department);
		ExtentReportListener.getExtent().log(Status.PASS, "Department selected :"+department);

		}
	
	public void clickOnLocationType(String locationType) {
		Select lt=new Select(LocationType);
		lt.selectByVisibleText(locationType);
		ExtentReportListener.getExtent().log(Status.PASS, "Location type selected :"+locationType);

		}
	
	public void clickOnLocation(String location) {
		Select l=new Select(Location);
		l.selectByVisibleText(location);
		ExtentReportListener.getExtent().log(Status.PASS, "Location selected :"+location);

		}
	
	public void clickOnReportingTo(String reportingTo) {
		Select rt=new Select(ReportingTo);
		rt.selectByVisibleText(reportingTo);
		ExtentReportListener.getExtent().log(Status.PASS, "Reporting To selected :"+reportingTo);

		}
	
	public void enterEmployeeCode(String employeeCode) {
		EmployeeCode.sendKeys(employeeCode);
		ExtentReportListener.getExtent().log(Status.PASS, "Employee Code Entered :"+employeeCode);

		}
	
	public void clickOnAddAdvanceDetails() {
		AddAdvanceDetails.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Advance Details Successfully ");

		}
	
	public void enterDomainExperties(String domainExperties) {
		DomainExperties.sendKeys(domainExperties);	
		ExtentReportListener.getExtent().log(Status.PASS, "Entered Domain Experties :"+domainExperties);

		}
	
	public void enterTotalExperience(String totalExperience) {
		TotalExperience.sendKeys(totalExperience);
		ExtentReportListener.getExtent().log(Status.PASS, "Enter total Experience :"+totalExperience);

		}
	
	public void clickOnWorkTime(String workTime) {
		Select wt=new Select(WorkTime);
		wt.selectByVisibleText(workTime);
		ExtentReportListener.getExtent().log(Status.PASS, "Work Time selected :"+workTime);

		}
	
	public void clickOnWorkingSince() {
		WorkingSince.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Working Since Date selected ");

		}
	
	public void clickOnDate() {
		DatePicker.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Working Since Date Picked ");

		}
	
	public void clickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on add Successfully :");
		
		}
	
	
	
	
	

}
