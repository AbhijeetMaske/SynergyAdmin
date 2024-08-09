package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class Goals {
public Goals(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="goalset01-tab")
	WebElement Shedule7;
	
	@FindBy(id="301")
	WebElement EradicatingHunger;
	
	@FindBy(id="302")
	WebElement PromotingEducation;
	
	@FindBy(id="303")
	WebElement PromotingGenderEquality;
	
	@FindBy(id="33698")
	WebElement MeasureForBenifits;
	
	@FindBy(id="33702")
	WebElement RuralDevelopment;
	
	@FindBy(id="33703")
	WebElement SlumAreaDevelopment;
	
	@FindBy(id="goalset02-tab")
	WebElement SDGs;
	
	@FindBy(id="275")
	WebElement NoPoverty;
	
	@FindBy(id="33705")
	WebElement ZeroHunger;
	
	@FindBy(id="33708")
	WebElement GenderEquality;
	
	@FindBy(id="33706")
	WebElement QualityEducation;
	
	@FindBy(id="33716")
	WebElement ClimateAction;
	
	@FindBy(id="33713")
	WebElement ReduceInequality;
	
	@FindBy(id="saveDevGoals")
	WebElement Save;
	
	public void clickOnShedule7() {
		Shedule7.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Shedule7 Successfully ");
		
	}
	
	public void clickOnEradicatingHunger() {
		EradicatingHunger.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on EradicatingHunger checkbox Successfully ");
		
	}
	
	public void clickOnPromotingEducation() {
		PromotingEducation.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on PromotingEducation chechbox Successfully ");
		
	}
	
	public void clickOnPromotingGenderEquality() {
		PromotingGenderEquality.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on PromotingGenderEquality checkbox Successfully ");
		
	}
	
	public void clickOnMeasureForBenifits() {
		MeasureForBenifits.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Measure For Benifits checkbox Successfully ");
		
	}
	
	public void clickOnRuralDevelopment() {
		RuralDevelopment.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Rural Development checkbox Successfully ");
		
	}
	
	public void clickOnSlumAreaDevelopment() {
		SlumAreaDevelopment.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Slum Area Development checkbox Successfully ");
		
	}
	
	public void clickOnSDGs() {
		SDGs.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on SDGs Successfully ");
		
	}
	
	public void clickOnNoPoverty() {
		NoPoverty.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on NoPoverty checkbox Successfully ");
		
	}
	
	public void clickOnZeroHunger() {
		ZeroHunger.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on ZeroHunger checkbox Successfully ");
		
	}
	
	public void clickOnGenderEquality() {
		GenderEquality.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on GenderEquality checkbox Successfully ");
		
	}
	
	public void clickOnQualityEducation() {
		QualityEducation.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on QualityEducation checkbox Successfully ");
		
	}
	
	public void clickOnClimateAction() {
		ClimateAction.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on ClimateAction checkbox Successfully ");
		
	}
	
	public void clickOnReduceInequality() {
		ReduceInequality.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on ReduceInequality checkbox Successfully ");
		
	}
	
	public void clickOnSave() {
		Save.click();
		ExtentReportListener.getExtent().log(Status.PASS, "Click on Save Successfully ");
		
	}
	
		
	
	

}
