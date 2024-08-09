package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.synergyconnect.utilities.ExtentReportListener;

public class DefineOutput {
public DefineOutput(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

}
@FindBy(xpath="//span[text()='Define Output']")
WebElement DefineOutput;

@FindBy(xpath="(//button[@class='btn btn-green'])[1]")
WebElement AddOutput;

@FindBy(id="selectProgramName")
WebElement SelectProgramName;

@FindBy(name="selectOutcomeName")
WebElement SelectOutcomeName;

@FindBy(name="outputName")
WebElement OutputName;

@FindBy(xpath="//button[text()='Add']")
WebElement Add;

public void ClickOnDefineOutput() {
	DefineOutput.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on DefineOutput Successfully ");
	
}

public void ClickOnAddOutput() {
	AddOutput.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on AddOutcome Successfully ");
	
}

public void SelectOnProgramName(String programName) {
	Select pn=new Select(SelectProgramName);
	pn.selectByVisibleText(programName);
	ExtentReportListener.getExtent().log(Status.PASS, "Select Program Name Successfully :"+programName);
	
}

public void SelectOnOutcomeName(String outcomeName) {
	Select pn=new Select(SelectOutcomeName);
	pn.selectByVisibleText(outcomeName);
	ExtentReportListener.getExtent().log(Status.PASS, "Select Outcome Name Successfully :"+outcomeName);
}

public void enterOutputName(String outputName) {
	OutputName.sendKeys(outputName);
	ExtentReportListener.getExtent().log(Status.PASS, "Output  Name entered :"+outputName);
	
}

public void ClickOnAdd() {
	Add.click();
	ExtentReportListener.getExtent().log(Status.PASS, "Click on Add Successfully ");
	

}
}
