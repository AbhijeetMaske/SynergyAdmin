package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineReportType {
public DefineReportType(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[text()='Define Report Type']")
	WebElement DefineRepotType;
	
	@FindBy(id="btnAddReportType")
	WebElement AddReportType;
	
	@FindBy(id="reportType")
	WebElement EnterReportType;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add;
	
	public void ClickOnDefineReportType() {
		DefineRepotType.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineReportType Successfully ");
		
	}
	
	public void ClickOnAddReportType() {
		AddReportType.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on AddReportType Successfully ");
		
	}
	
	public void EnterReportType(String reportType) {
		EnterReportType.sendKeys(reportType);
		
	}
	
	public void ClickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
		
	
	
}
	

}
