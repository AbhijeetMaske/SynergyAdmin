package com.synergyconnect.pageobject.stakeholder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class Corporate {

public Corporate(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="corporate-tab")
	WebElement Corporate;
	
	@FindBy(id="individual-corp")
	WebElement CompanyType;

	@FindBy(id="corporateSubmitBtn")
	WebElement Submit;
	
	public void clickOnCorporate() {
		Corporate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Corporate Successfully ");

		}
	
	public void clicOnCompanyType() {
		CompanyType.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Company Type Selected ");

		}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Donar Successfully ");

		}
	
}
