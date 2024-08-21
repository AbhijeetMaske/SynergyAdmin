package com.synergyconnect.pageobject.stakeholder;

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

}
