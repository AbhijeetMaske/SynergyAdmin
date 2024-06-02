package com.synergyconnect.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtils {

    public static String getChromeBrowserVersion() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String version = "";
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            version = (String) js.executeScript("return navigator.userAgent;");
            if (version.contains("Chrome/")) {
                version = version.substring(version.indexOf("Chrome/") + 7);
                version = version.split(" ")[0];
            }
        } finally {
            driver.quit();
        }
        System.out.println(version);
        return version;
    }
}