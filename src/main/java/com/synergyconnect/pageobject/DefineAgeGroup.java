package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineAgeGroup {
public DefineAgeGroup(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
}
		@FindBy(xpath="//span[text()='Define Age Group']")
		WebElement DefineAgeGroup;
		
		@FindBy(id="addAgeBtn")
		WebElement AddAgeGroup;
		
		@FindBy(id="age")
		WebElement EnterAgeGroup;
		
		@FindBy(xpath="//button[text()='Add']")
		WebElement Add;
		
		public void ClickOnDefineAgeGroup() {
			DefineAgeGroup.click();;
			ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineAgeGroup Successfully ");
			
		}
		
		public void ClickOnAddAgeGroup() {
			AddAgeGroup.click();
			ExtentReportListener.getExtent().log(Status.PASS, "Click on AddAgeGroup Successfully ");
			
		}
		
		public void EnterAgeGroup(String ageGroup) {
			EnterAgeGroup.sendKeys(ageGroup);
			ExtentReportListener.getExtent().log(Status.PASS, "Enter Age group :"+ageGroup);
			
		}
		
		public void ClickOnAdd() {
			Add.click();
			ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
			
		
		
	}

}
