package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddLocation {
//WebDriver ldriver;
	
	public AddLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}	
	@FindBy(id="LocationType")
	WebElement LocationType;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="district")
	WebElement district;
	
	@FindBy(id="block")
	WebElement block;
	
	@FindBy(id="pinCode")
	WebElement pinCode;
	
	@FindBy(id="village")
	WebElement village;
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(id="shortCode")
	WebElement shortCode;
	
	@FindBy(id="locationLatitude")
	WebElement locationLatitude;
	
	@FindBy(id="locationLongitude")
	WebElement locationLongitude;
	
	@FindBy(id="btnAddOfficeLoc")
	WebElement submit;
	
	public void clickOnLocationType() {
		Select lt=new Select(LocationType);
		lt.selectByVisibleText("Office");
		}
	
	public void clickOncountry() {
		Select lt=new Select(country);
		lt.selectByVisibleText("India");
		}
	
	public void clickOnstate() {
		Select lt=new Select(state);
		lt.selectByVisibleText("Maharashtra");
		}
	
	public void clickOndistrict() {
		Select lt=new Select(district);
		lt.selectByVisibleText("Amravati");
		}
	
	public void clickOnblock() {
		Select lt=new Select(block);
		lt.selectByVisibleText("Chandurbazar");
		}
	
	public void clickOnpinCode() {
		Select lt=new Select(pinCode);
		lt.selectByVisibleText("444704");
		}
	
	public void clickOnvillage() {
		Select lt=new Select(village);
		lt.selectByVisibleText("Chandur bazar");
		}
	
	public void enterLocation() {
		location.sendKeys("Amravati");
		}
	
	public void entershorCode() {
		shortCode.sendKeys("AMI");
	}
	
	public void enterlocationLatitude() {
		locationLatitude.sendKeys("19.00000");
		}
	
	public void enterlocationLongitude() {
		locationLongitude.sendKeys("27.00000");
		}
	public void clickOnsubmit() {
		submit.click();
	}
	
	

}
