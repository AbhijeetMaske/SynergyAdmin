package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailConfiguration {
public EmailConfiguration(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	


}
