package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class NpbtDetails {
	
public NpbtDetails(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	WebElement SearchName;

	@FindBy(xpath="//i[@class='fa fa-edit']")
	WebElement EditDonar;

	@FindBy(id="PATDetail-tab")
	WebElement NPBTdetails;
	
	@FindBy(id="patYear")
	WebElement FinancialYear;
	
	@FindBy(id="patAmount")
	WebElement NPBTamount;
	
	@FindBy(id="csrBudget")
	WebElement CsrBudget;
	
	@FindBy(xpath="(//button[text()='Submit'])[3]")
	WebElement Submit;
	
	@FindBy(id="Goals-tab")
	WebElement Goals;
	
}
