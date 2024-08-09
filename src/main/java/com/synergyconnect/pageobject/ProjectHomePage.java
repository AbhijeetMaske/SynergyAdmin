package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectHomePage {
public ProjectHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[text()='App Setup']")
	WebElement Appsetup;

	@FindBy(xpath="//span[text()='Define Program']")
	WebElement DefineProgram;
	
	@FindBy(xpath="//span[text()='Create Project']")
	WebElement CreateProject;
	
	public void clickOnAppSetup() {
		Appsetup.click();
		}
	
	public void clickOnDefineProgram() {
		DefineProgram.click();
		}
	
	public void clickOnCreateProject() {
		CreateProject.click();
		}
	
	
}
