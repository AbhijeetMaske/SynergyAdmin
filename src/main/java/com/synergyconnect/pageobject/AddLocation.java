package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class AddLocation {
//WebDriver ldriver;
	
	public AddLocation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@id='addLocationBtn']")
	WebElement Location;
	
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
	public void clickOnLocation() {
		Location.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Location :");

	}
	
	public void clickOnLocationType(String locationType) {
		Select lt=new Select(LocationType);
		lt.selectByVisibleText(locationType);
		ExtentReportListener.getExtent().log(Status.PASS, "Location type selected :"+locationType);

		}
	
	public void clickOncountry(String Country) {
		Select lt=new Select(country);
		lt.selectByVisibleText(Country);
		ExtentReportListener.getExtent().log(Status.PASS, "Country selected :"+Country);

		}
	
	public void clickOnstate(String State) {
		Select lt=new Select(state);
		lt.selectByVisibleText(State);
		ExtentReportListener.getExtent().log(Status.PASS, "State selected :"+State);

		}
	
	public void clickOndistrict(String District) {
		Select lt=new Select(district);
		lt.selectByVisibleText(District);
		ExtentReportListener.getExtent().log(Status.PASS, "District selected :"+District);

		}
	
	public void clickOnblock(String Block) {
		Select lt=new Select(block);
		lt.selectByVisibleText(Block);
		ExtentReportListener.getExtent().log(Status.PASS, "Block selected :"+Block);

		}
	
	public void clickOnpinCode(String Pincode) {
		Select lt=new Select(pinCode);
		lt.selectByVisibleText(Pincode);
		ExtentReportListener.getExtent().log(Status.PASS, "Pincode selected :"+Pincode);

		}
	
	public void clickOnvillage(String Village) {
		Select lt=new Select(village);
		lt.selectByVisibleText(Village);
		ExtentReportListener.getExtent().log(Status.PASS, "Village selected :"+Village);

		}
	
	public void enterLocation(String Elocation) {
		location.sendKeys(Elocation);
		ExtentReportListener.getExtent().log(Status.PASS, "Location entered :"+Elocation);

		
		}
	
	public void entershorCode(String Shortcode) {
		shortCode.sendKeys(Shortcode);
		ExtentReportListener.getExtent().log(Status.PASS, "Shortcode entered :"+Shortcode);
		
	}
	
	public void enterlocationLatitude(String latitude) {
		locationLatitude.sendKeys(latitude);
		ExtentReportListener.getExtent().log(Status.PASS, "Latitude entered :"+latitude);

		}
	
	public void enterlocationLongitude(String longitude) {
		locationLongitude.sendKeys(longitude);
		ExtentReportListener.getExtent().log(Status.PASS, "Longitude entered :"+longitude);

		}
	public void clickOnsubmit() {
		submit.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Submit Successfully :");

	}
	
	

}
