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
	
	@FindBy(xpath="//em[@class='ion-grid text-white font-weight-bold']")
	WebElement ToggleButton;
	
	@FindBy(xpath="(//span[text()='Admin'])[2]")
	WebElement Admin;
	
	public void clickOnToggleButton() {
		ToggleButton.click();
	}
	
	public void clickOnAdmin() {
		Admin.click();
	}
	
}
