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

}
