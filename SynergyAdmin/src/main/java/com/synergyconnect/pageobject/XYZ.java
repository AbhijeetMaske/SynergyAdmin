package com.synergyconnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZ {

	public XYZ(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id="cinNumber")
	static WebElement cinElement;
	public static String getCINText() {
		return cinElement.getText();
	}

}
