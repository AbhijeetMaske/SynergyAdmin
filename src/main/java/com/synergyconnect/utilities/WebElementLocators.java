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
	 * Finds a web element using the specified locator and waits until the element
	 * is present within the given timeout period.
	 * 
	 * This method uses a FluentWait to wait for the presence of the element located
	 * by the provided `By` locator. If the element is found within the timeout
	 * period, it is returned.
	 * 
	 * @param byelement the `By` locator used to identify the web element
	 * @param timeout   the duration to wait for the element to be located
	 * @return the found `WebElement`, or `null` if the element is not found
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
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

	/********************************************************************************************
	 * Finds a web element based on its tag name and the text it contains.
	 * 
	 * This method constructs an XPath expression using the provided tag name and
	 * text, then finds and returns the matching web element.
	 * 
	 * @param tagName the tag name of the web element
	 * @param text    the text contained within the web element
	 * @return the found `WebElement`, or `null` if no matching element is found
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static WebElement findElementByText(String tagName, String text) {
		String xpathExpression = String.format("//%s[contains(text(),'%s')]", tagName, text);
		return driver.findElement(By.xpath(xpathExpression));
	}

	/********************************************************************************************
	 * Finds a web element using an XPath expression and waits until the element is
	 * visible.
	 * 
	 * This method uses a `WebDriverWait` to wait for the visibility of the element
	 * located by the provided XPath expression within a small timeout period.
	 * 
	 * @param text the XPath expression used to locate the web element
	 * @return the found `WebElement`, or `null` if the element is not found
	 * @throws Exception if an error occurs while waiting for the element to become
	 *                   visible
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
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

	/********************************************************************************************
	 * Finds a web element using its class name and the exact text it contains.
	 * 
	 * This method constructs an XPath expression using the provided class name and
	 * text, then finds and returns the matching web element.
	 * 
	 * @param className the class name of the web element
	 * @param text      the exact text contained within the web element
	 * @return the found `WebElement`, or `null` if no matching element is found
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static WebElement xpathByClassAndText(String className, String text) {
		String dayXpath = "//*[@class='" + className + "' and text()='" + text + "']";
		return driver.findElement(By.xpath(dayXpath));
	}

}
