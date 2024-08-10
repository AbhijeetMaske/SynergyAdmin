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
	
	public void enterSearchName(String searchName) {
		SearchName.sendKeys(searchName);		
		ExtentReportListener.getExtent().log(Status.PASS, "Search Name entered :"+searchName);

		}
	
	public void clickOnEditDonar() {
		EditDonar.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Edit Successfully ");


	}
	
	public void clickOnNPBTdetails() {
		NPBTdetails.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on NPBT details Successfully ");
	}
	
	public void clickOnFinancialYear(String financialYear) {
		Select fy=new Select(FinancialYear);
		fy.selectByVisibleText(financialYear);
		ExtentReportListener.getExtent().log(Status.PASS, "Financial year Selected :"+financialYear);

		}
	
	public void enterNPBTamount(String npbtAmount) {
		NPBTamount.sendKeys(npbtAmount);
		ExtentReportListener.getExtent().log(Status.PASS, "NPBT amount entered :"+npbtAmount);
		
	}
	
	public void enterCsrBudget(String csrBudget) {
		CsrBudget.sendKeys(csrBudget);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR Budget is 2% of NPBT amount  :"+csrBudget);
		
	}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Submit Successfully :");

	}
	
	public void clickOnGoals() {
		Goals.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Goals Successfully :");

	}

}
