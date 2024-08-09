package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class AddProgram {
public AddProgram(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="addProgramBtn")
	WebElement AddProgram;
	
	@FindBy(id="programName")
	WebElement ProgramName;
	
	@FindBy(name="shortName")
	WebElement ShortName;
	
	@FindBy(id="description")
	WebElement BriefIntroduction;
	
	@FindBy(name="programStartDateStr")
	WebElement StartDate;
	
	@FindBy(xpath="(//td[text()='1'])[2]")
	WebElement StartDatePick;
	
	@FindBy(name="programEndDateStr")
	WebElement EndDate;
	
	@FindBy(xpath="//td[text()='26']")
	WebElement EndDatePick;
	
	@FindBy(id="currency")
	WebElement Currency;
	
	@FindBy(id="programBudget")
	WebElement BudgetAmount;
	
	@FindBy(id="department")
	WebElement Department;
	
	@FindBy(id="owner")
	WebElement ProgramOwner;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add;
	
	public void ClickOnAddProgram() {
		AddProgram.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Program Successfully ");
		
	}
	
	public void enterProgramName(String programName) {
		ProgramName.sendKeys(programName);
		ExtentReportListener.getExtent().log(Status.PASS, "Program Name entered :"+programName);
		
	}
	
	public void enterShortName(String shortName) {
		ShortName.sendKeys(shortName);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Name entered :"+shortName);
		
	}
	
	public void enterBriefIntroduction(String briefIntroduction) {
		BriefIntroduction.sendKeys(briefIntroduction);
		ExtentReportListener.getExtent().log(Status.PASS, "Brief Introduction Entered entered :"+briefIntroduction);
		
	}
	
	public void ClickOnStartDate() {
		StartDate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on start date Successfully ");
		
	}
	
	public void PickOnStartDate() {
		StartDatePick.click();
			
	}
	
	public void ClickOnEndDate() {
		EndDate.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on End Date date Successfully ");
		
	}
	
	public void PickOnEndDate() {
		EndDatePick.click();
			
	}
	
	public void clickOnCurrency(String currency) {
		Select c=new Select(Currency);
		c.selectByVisibleText(currency);
		ExtentReportListener.getExtent().log(Status.PASS, "Currency type selected :"+currency);

	}	
	public void enterBudgetAmount(String budgetAmount) {
		BudgetAmount.sendKeys(budgetAmount);
		ExtentReportListener.getExtent().log(Status.PASS, "Budget Amount entered :"+budgetAmount);
		
	}
	
	public void clickOnDepartment(String department) {
		Select d=new Select(Department);
		d.selectByVisibleText(department);
		ExtentReportListener.getExtent().log(Status.PASS, "Department is selected :"+department);
	}
	

	public void clickOnProgramOwner(String programOwner) {
		Select d=new Select(ProgramOwner);
		d.selectByVisibleText(programOwner);
		ExtentReportListener.getExtent().log(Status.PASS, "Program Owner  selected :"+programOwner);
	}
	
	public void ClickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add  Successfully ");
		
	}
	
	
	
	
	
	
	
	
	

}
