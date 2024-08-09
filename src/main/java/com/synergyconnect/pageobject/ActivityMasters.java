package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class ActivityMasters {
public ActivityMasters(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[text()='Activity Masters']")
	WebElement ActivityMasters;
	
	@FindBy(xpath="//span[@class='select2-selection__arrow']")
	WebElement Program;
	
	@FindBy(id="btnAddActivityMasters")
	WebElement AddActivityMasters;
	
	@FindBy(name="activityType")
	WebElement ActivityType;
	
	@FindBy(name="activityName")
	WebElement ActivityName;
	
	@FindBy(name="shortName")
	WebElement ShortName;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add;
	
	public void ClickOnActivityMasters() {
		ActivityMasters.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Activity Masters Successfully ");
		
	}
	
	public void clickOnProgram(String program) {
		Select p=new Select(Program);
		p.selectByVisibleText(program);
		ExtentReportListener.getExtent().log(Status.PASS, "Activity type selected :"+program);

		}
	
	public void ClickOnAddActivityMasters() {
		AddActivityMasters.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Activity Masters Successfully ");
		
	}
	
	public void clickOnActivityType(String activityType) {
		Select at=new Select(ActivityType);
		at.selectByVisibleText(activityType);
		ExtentReportListener.getExtent().log(Status.PASS, "Activity type selected :"+activityType);

		}
	
	public void enterActivityName(String activityName) {
		ActivityName.sendKeys(activityName);
		ExtentReportListener.getExtent().log(Status.PASS, "Activity Name entered :"+activityName);
		
	}
	
	public void enterShortName(String shortName) {
		ShortName.sendKeys(shortName);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Name entered :"+shortName);
		
	}
	
	public void ClickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
		
	
	
}
	
	
	
	

}
