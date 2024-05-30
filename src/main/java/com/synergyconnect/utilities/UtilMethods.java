package com.synergyconnect.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilMethods {

	public static synchronized String captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: Convert WebDriver object to take Screenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: Call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//screenshots//" + testName + ".png");
		// step 3: copy image file to destination
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir") + "//screenshots//" + testName + ".png";

	}
}
