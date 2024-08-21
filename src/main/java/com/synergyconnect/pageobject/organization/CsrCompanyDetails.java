package com.synergyconnect.pageobject.organization;

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
}
