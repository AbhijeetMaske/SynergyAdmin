package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class PreferedLocation {
public PreferedLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="preferred-location-tab")
	WebElement  PreferedLocation;
	
	@FindBy(id="preferredCountry")
	WebElement PreferedCountry;
	
	@FindBy(id="preferredState")
	WebElement  State;
	
	@FindBy(id="donorPreferredLocationButton")
	WebElement  Submit;
	
	public void clickOnPreferdLocation() {
		PreferedLocation.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Prefered Location Successfully ");

		}
	
	public void clickOnPreferedCountry(String country) {
		Select c=new Select(PreferedCountry);
		c.selectByVisibleText(country);
		ExtentReportListener.getExtent().log(Status.PASS, "Donar selected :"+country);

		}
	
	public void clickOnState(String state) {
		Select s=new Select(State);
		s.selectByVisibleText(state);
		ExtentReportListener.getExtent().log(Status.PASS, "State selected :"+state);

		}
	
	public void clickOnSubmit() {
		Submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Submit Successfully ");

		}
	
	
	
	

}
