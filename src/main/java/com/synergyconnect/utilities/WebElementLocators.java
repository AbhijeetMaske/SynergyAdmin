package com.synergyconnect.utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.common.Config;

public class WebElementLocators {
	private static final Logger logger = LogManager.getLogger(WebElementLocators.class);
	private static WebDriverWait wait;
	static Duration timeout = Duration.ofSeconds(Config.MEDIUM_PAUSE);
	static Duration polling = Duration.ofMillis(Config.POLLING_TIME);
	public static WebDriver driver;
	static private Actions action;

	public WebElementLocators(WebDriver webDriver) {
		driver = BaseClass.getDriver();
		if (driver == null) {
			logger.error("WebDriver is null in ElementInteractionUtils constructor.");
		} else {
			logger.info("WebDriver initialized in ElementInteractionUtils: " + driver);
		}
		setWait(driver);
		WebElementLocators.action = new Actions(driver);
	}

	private static void setWait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Setting in a static method
	}

	/********************************************************************************************
	 * wait for web element and set text in it.
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param text       {@link String} - text to enter
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static WebElement findElement(By byelement, Duration timeout) {
		WebElement webelement = null;
		try {
			FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(timeout)
					.ignoring(NoSuchElementException.class);
			webelement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(byelement));
			logger.info("Element is visible: " + byelement.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to find webElement: " + byelement);
		}
		return webelement;
	}

	public static WebElement findElementByText(String tagName, String text) {
		String xpathExpression = String.format("//%s[contains(text(),'%s')]", tagName, text);
		return driver.findElement(By.xpath(xpathExpression));
	}

	public static WebElement xpathBytext(String text) {
		Duration SMALL_PAUSE = Duration.ofSeconds(Config.XSMALL_PAUSE);
		wait = new WebDriverWait(driver, SMALL_PAUSE);
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
			return element;
		} catch (Exception e) {
			System.out.println("Error in xpath by text: " + e.getMessage());
			throw e;
		}
	}

	public static WebElement xpathByClassAndText(String className, String text) {
		String dayXpath = "//*[@class='" + className + "' and text()='" + text + "']";
		return driver.findElement(By.xpath(dayXpath));
	}

}
