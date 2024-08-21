package com.synergyconnect.pageobject.organization;

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
	
}
