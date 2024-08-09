package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation {

	public Validation(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id="cinNumber")
	static WebElement cinElement;

	public static String getCINText() {

		return cinElement.getText();

	}
	@FindBy(id="emailID")
	static WebElement emailId;
	
	public static String getEmailId() {
		return emailId.getText();
	}
	@FindBy(id="orgType")
	static WebElement entityType;
	
	public static String getEntityType() {
		return entityType.getText();
	}
	
	@FindBy(xpath="//td[text()='SCDI Foundation']")
	static WebElement csrDetails;
	
	public static String getCSRdetails() {
		return csrDetails.getText();
	}
	
	

}
