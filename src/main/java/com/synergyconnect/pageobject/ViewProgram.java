package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProgram {
//	WebDriver ldriver;
	
	public ViewProgram(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
					
	@FindBy(xpath="//img[@id='socialIntegratedPlatform']")
	WebElement ToggleButton;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement Admin;
	
	@FindBy(xpath="(//div[text()='Projects'])[1]")
	WebElement Project;
	
	public void clickOnToggleButton() {
		ToggleButton.click();
	}
	
	public void clickOnAdmin() {
		Admin.click();
	}
	
	public void clickOnProject() {
		Project.click();
	}
	
}
