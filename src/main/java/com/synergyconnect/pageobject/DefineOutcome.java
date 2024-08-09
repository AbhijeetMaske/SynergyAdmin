package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineOutcome {
public DefineOutcome(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[text()='Define Outcome']")
WebElement DefineOutcome;

@FindBy(id="addOutcomeBtn")
WebElement AddOutCome;

@FindBy(name="selectProgramName")
WebElement SelectProgramName;

@FindBy(name="outcomeName")
WebElement OutcomeName;

@FindBy(xpath="//button[text()='Add']")
WebElement Add;

public void ClickOnDefineOutcome() {
	DefineOutcome.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineOutcome Successfully ");
	
}

public void ClickOnAddOutcome() {
	AddOutCome.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on AddOutcome Successfully ");
	
}

public void SelectOnProgramName(String programName) {
	Select pn=new Select(SelectProgramName);
	pn.selectByVisibleText(programName);
	ExtentReportListener.getExtent().log(Status.PASS, "Select Program Name Successfully :"+programName);
	
}

public void enterOutcomeName(String outcomeName) {
	OutcomeName.sendKeys(outcomeName);
	ExtentReportListener.getExtent().log(Status.PASS, "Outcome  Name entered :"+outcomeName);
	
}

public void ClickOnAdd() {
	Add.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
	


}
	

}
