package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class BulkLocation {
public BulkLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="addbulk")
	WebElement BulkLocation;
	
	@FindBy(id="locationBulkUpload")
	WebElement Browser;
	
	@FindBy(id="bulkUploadButton")
	WebElement Submit;
	
	public void clickOnBulkLocaion() {
		BulkLocation.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Clicked on Bulk Location Successfully ");

	}
	
	public void UploadFile() {
		Browser.sendKeys("C:/Users/User/Downloads/BulkUploadLocationReport_12-06-2024-12-55-50.xlsx");
		ExtentReportListener.getExtent().log(Status.PASS, "Upload File Successfully ");

	}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Submit Successfully ");

	}
	



}
