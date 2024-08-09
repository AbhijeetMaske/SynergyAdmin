package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineBenificiaryType {
public DefineBenificiaryType(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Define Beneficiary Type']")
	WebElement DefineBenificiaryType;
	
	@FindBy(id="Beneficiarybtn")
	WebElement AddBenificiaryType;
	
	@FindBy(id="beneficiary")
	WebElement EnterBenificiaryType;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add;
	
	public void ClickOnDefineBenificiaryType() {
		DefineBenificiaryType.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineBenificiaryType Successfully ");
		
	}
	
	public void ClickOnAddBenificiaryType() {
		AddBenificiaryType.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on AddBenificiaryType Successfully ");
		
	}
	
	public void ClickOnBenificiaryType(String benificiaryType) {
		EnterBenificiaryType.sendKeys(benificiaryType);
		
	}
	
	public void ClickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
		
	}
	

}
