package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineInputs {
public DefineInputs(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Define Inputs']")
	WebElement DefineInputs;
	
	@FindBy(id="inputBtn")
	WebElement AddInput;
	
	@FindBy(id="input")
	WebElement EnterInput;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add;
	
	public void ClickOnDefineInputs() {
		DefineInputs.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineInput Successfully ");
		
	}
	
	public void ClickOnAddInput() {
		AddInput.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on AddInput Successfully ");
		
	}
	
	public void enterInput(String input) {
		EnterInput.sendKeys(input);
		ExtentReportListener.getExtent().log(Status.PASS, "Enter input Name :"+input);
		
	}
	
	public void ClickOnAdd() {
		Add.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
		
	}

}
