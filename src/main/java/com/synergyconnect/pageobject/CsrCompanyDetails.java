package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class CsrCompanyDetails {
	public CsrCompanyDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	WebElement Edit;
	
	@FindBy(id="addBtnCSR")
	WebElement Add;
	
	@FindBy(id="csrCompanyName")
	WebElement CompanyName;
	
	@FindBy(id="csrCinNo")
	WebElement CinNo;
	
	@FindBy(xpath="//input[@placeholder='Enter short name for CSR company']")
	WebElement ShortName;
	
	@FindBy(id="csrHeadManagerName")
	WebElement CsrManager;
	
	@FindBy(id="csrMobileNo")
	WebElement MobNo;
	
	@FindBy(id="csrCity")
	WebElement City;
	
	@FindBy(id="csrState")
	WebElement State;
	
	@FindBy(id="csrCompanyButton")
	WebElement AddCsr;
	
	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement Search;	
	
	
	
	public void clickOnEdit() {
		Edit.click();
	}
	
	public void clickOnAdd() {
		Add.click();
	}
	
	public void enterCompanyName(String CmpName) {
		CompanyName.sendKeys(CmpName);
		ExtentReportListener.getExtent().log(Status.PASS, "Company Name entered :"+CmpName);

	}
	
	public void enterCinNo(String cinNo) {
		CinNo.clear();
		CinNo.sendKeys(cinNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Cin Number entered :"+cinNo);

	}
	
	public void enterShortName(String shortName) {
		ShortName.clear();
		ShortName.sendKeys(shortName);
		ExtentReportListener.getExtent().log(Status.PASS, "Short Name entered :"+shortName);

	}
	
	public void enterCsrManager(String csrManager) {
		CsrManager.clear();
		CsrManager.sendKeys(csrManager);
		ExtentReportListener.getExtent().log(Status.PASS, "CSR Manager Name entered :"+csrManager);

	}
	
	public void enterMobileNo(String mobileNo) {
		MobNo.clear();
		MobNo.sendKeys(mobileNo);
		ExtentReportListener.getExtent().log(Status.PASS, "Mobile Number entered :"+mobileNo);

	}
	
	public void enterCity(String city) {
		City.clear();
		City.sendKeys(city);
		ExtentReportListener.getExtent().log(Status.PASS, "City Name entered :"+city);

	}
	
	public void clickOnState(String state) {
		Select st= new Select(State);
				st.selectByVisibleText(state);
				ExtentReportListener.getExtent().log(Status.PASS, "State Name Selected :"+state);
		
	}
	
	public void clickOnAddCsr() {
		AddCsr.click();
		ExtentReportListener.getExtent().log(Status.PASS, "CSR company details add successfully :");

	}
	
	public void entercsrName(String csrName) {
		CompanyName.sendKeys(csrName);
		ExtentReportListener.getExtent().log(Status.PASS, "Company Name entered :"+csrName);

	}
	
	


}
