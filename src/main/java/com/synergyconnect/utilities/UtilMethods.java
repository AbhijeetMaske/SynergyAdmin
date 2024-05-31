package com.synergyconnect.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilMethods {

    private static final Logger logger = LogManager.getLogger(UtilMethods.class);
    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "//screenshots//";

    public static synchronized String captureScreenShot(WebDriver driver, String testName) {
        try {
            // Ensure the screenshots directory exists
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Convert WebDriver object to TakeScreenshot interface
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Create image file from screenshot
            File src = screenshot.getScreenshotAs(OutputType.FILE);

            // Define the destination file
            File dest = new File(SCREENSHOT_DIR + testName + ".png");

            // Copy the image file to the destination
            FileUtils.copyFile(src, dest);

            logger.info("Screenshot captured for test case: " + testName);
            return dest.getAbsolutePath();

        } catch (IOException e) {
            logger.error("Failed to capture screenshot for test case: " + testName, e);
            return null;
        }
    }
}
