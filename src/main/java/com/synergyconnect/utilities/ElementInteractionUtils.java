package com.synergyconnect.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.common.Config;

/**
 * Utility class to interact with web elements in Selenium WebDriver.
 */

public class ElementInteractionUtils {

	private static final Logger logger = LogManager.getLogger(ElementInteractionUtils.class);
	private static WebDriverWait wait;
	static Duration timeout = Duration.ofSeconds(Config.MEDIUM_PAUSE);
	static Duration polling = Duration.ofMillis(Config.POLLING_TIME);
	public static WebDriver driver;
	static private Actions action;

	public ElementInteractionUtils(WebDriver webDriver) {

		driver = BaseClass.getDriver();
		if (driver == null) {
			logger.error("WebDriver is null in ElementInteractionUtils constructor.");
		} else {
			logger.info("WebDriver initialized in ElementInteractionUtils: " + driver);
		}
		setWait(driver);
		ElementInteractionUtils.action = new Actions(driver);
	}

	private static void setWait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Setting in a static method
	}

	/********************************************************************************************
	 * Clicks on a web element.
	 * 
	 * @param element the web element to click
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 17,2024
	 ********************************************************************************************/
	public static boolean click(WebElement webElement) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			highlightElement(webElement);
			webElement.click();
			logger.info("Clicked on element: " + webElement);
			status = true;
		} catch (NoSuchElementException | TimeoutException e) {
			logger.error("Unable to click on element: " + describeElement(webElement), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Click the identified web element by javascript.
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean clickUsingJS(WebElement webElement) {
		boolean status = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			waitForElementToBeVisible(webElement);
			highlightElement(webElement);
			js.executeScript("arguments[0].click();", webElement);
			status = true;
			logger.info("Successfully clicked on the web element using JavaScript: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to click on the web element using JavaScript: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * wait for web element and set text in it
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param text       {@link String} - text to enter
	 * @return status {@link boolean} - true/false
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean sendKeys(WebElement webElement, String text) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			highlightElement(webElement);
			webElement.clear();
			webElement.sendKeys(text);
			status = true;
		} catch (Exception e) {
			logger.error("Unable to set text in webElement: " + webElement.toString());
			System.out.println(e);
		}
		return status;
	}

	/********************************************************************************************
	 * Send text in element with javascript.
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @return status {@link boolean} - true/false
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static void sendKeysUsingJS(WebElement webElement, String value) {
		try {
			if (driver instanceof JavascriptExecutor) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				highlightElement(webElement);
				js.executeScript("arguments[0].value='" + value + "';", webElement);
			} else {
				throw new IllegalStateException("This driver does not support JavaScript execution");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/********************************************************************************************
	 * wait for web element and clears text in it
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * 
	 * @return status {@link boolean} - true/false
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean clear(WebElement webElement) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			highlightElement(webElement);
			webElement.clear();
			status = true;
			logger.info("Successfully cleared text in webElement: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to clear text in webElement: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Gets the description of a web element (tagName and attributes).
	 * 
	 * @param element the web element
	 * @return the description of the element
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	private static String describeElement(WebElement webElement) {
		String tagName = webElement.getTagName();
		String attributes = webElement.toString().split("-> ")[1].replace("]", "");
		return tagName + " [" + attributes + "]";
	}

	/********************************************************************************************
	 * Send text in element with javascript.
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param value      {@link String} - value too be entered
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static void searchClickByJS(WebElement webElement) {
		try {
			if (driver instanceof JavascriptExecutor) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				highlightElement(webElement);
				js.executeScript("var el = document.querySelector(\"" + webElement + "\").click();");
			} else {
				throw new IllegalStateException("This driver does not support JavaScript execution");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/********************************************************************************************
	 * wait for web element and selects value from drop down
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param value      {@link String} - value too be entered
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean selectByValue(WebElement webElement, String value) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByValue(value);
			status = true;
			logger.info(
					"Successfully selected the value '" + value + "' from the dropdown list: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to select the value '" + value + "' from the dropdown list: " + webElement.toString(),
					e);
		}
		return status;
	}

	/********************************************************************************************
	 * wait for web element and selects value from drop down
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param value      {@link String} - value too be entered
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean selectByVisibleText(WebElement webElement, String value) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			highlightElement(webElement);
			listBox.selectByVisibleText(value);			
			status = true;
			logger.info(
					"Successfully selected the value '" + value + "' from the dropdown list: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to select the value '" + value + "' from the dropdown list: " + webElement.toString(),
					e);
		}
		return status;
	}

	/********************************************************************************************
	 * wait for web element and selects value from drop down
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param index      {@link String} - value index to select
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean selectByIndex(WebElement webElement, int index) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByIndex(index);
			status = true;
			logger.info("Successfully selected the value at index '" + index + "' from the dropdown list: "
					+ webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to select the value at index '" + index + "' from the dropdown list: "
					+ webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * wait for web element visibility
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param timeOut    {@link int} - The amount of the time in milliseconds to
	 *                   pause
	 * @param polling    The interval at which to check the condition.
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean waitForVisibility(WebElement webElement, Duration timeout, Duration polling) {
		boolean status = false;
		FluentWait<WebDriver> fluentWait;
		try {
			// Initialize FluentWait with WebDriver instance and timeout duration
			fluentWait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling)
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
			status = true;
			logger.info("Element is clickable: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Element is not clickable: " + webElement.toString(), e);
		}
		return status;
	}

	public static boolean waitForElementToBeVisible(WebElement webElement) {
		boolean status = false;
		WebDriverWait wait;
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			status = true;
			logger.info("Element is visible: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Element is not visible: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * wait for web element to be non visible
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param timeOut    {@link int} - The amount of the time in milliseconds to
	 *                   pause
	 * 
	 * @return status {@link boolean} - true/false
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean waitForInvisibilityOfElement(WebElement webElement, Duration timeout, Duration polling) {
		boolean status = false;
		FluentWait<WebDriver> fluentWait;
		try {
			fluentWait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling)
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.invisibilityOf(webElement));
			status = true;
			logger.info("Element is now invisible: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Unable to wait for invisibility of element: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * verifies element is present
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param timeout    {@link Integer} - The amount of time in milliseconds to
	 *                   pause.
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean isPresent(WebElement webElement, int timeOut) {
		boolean status = false;
		try {
			status = webElement.isDisplayed();
			logger.info("Element is visible: " + webElement.toString());
		} catch (Exception e) {
			logger.error("WebElement is not present: " + webElement.toString());
		}
		return status;

	}

	/********************************************************************************************
	 * verifies element is enabled
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean isEnabled(WebElement webElement) {
		boolean status = false;
		waitForElementToBeVisible(webElement);
		try {
			status = webElement.isEnabled();
			logger.info("Element is enabled: " + webElement.toString());
		} catch (Exception e) {
			logger.error("WebElement is disabled: " + webElement.toString());
		}

		return status;

	}

	/********************************************************************************************
	 * Determine if an element has a specific text value or not.
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param text       {@link String } - WebElement to verify text
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean verifyText(WebElement webElement, String text) {
		boolean status = false;
		waitForElementToBeVisible(webElement);
		try {
			highlightElement(webElement);
			status = webElement.getText().contains(text);
			logger.info("Verifying text: " + text + " within web element: " + webElement);
		} catch (Exception e) {
			logger.error("unable to verify text for webelement: " + webElement.toString());
		}
		return status;
	}

	/********************************************************************************************
	 * Fetches element specific attribute value
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @param attribute  {@link String } - The attribute value
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static String getAttribute(WebElement webElement, String attribute) {
		String attributeValue = " ";
		waitForElementToBeVisible(webElement);
		try {
			logger.info("Getting attribute '" + attribute + "' for webElement: " + webElement.toString());
			attributeValue = webElement.getAttribute(attribute);
		} catch (Exception e) {
			logger.error("Unable to get attribute for webElement " + webElement.toString(), e);
		}
		return attributeValue;
	}

	/********************************************************************************************
	 * Determine if an element has a specific attribute value or not.
	 * 
	 * @param webElement     {@link WebElement} -webElement to click
	 * @param attribute      {@link String } - The specific attribute type to
	 *                       evaluate
	 * @param attributeValue {link String} - The value of the attribute to evaluate
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean verifyAttributeValue(WebElement webElement, String attribute, String attributeValue) {
		boolean status = false;
		waitForElementToBeVisible(webElement);
		try {
			logger.info("Verifying attribute '" + attribute + "' value to be '" + attributeValue + "' for webElement: "
					+ webElement.toString());
			status = webElement.getAttribute(attribute).equalsIgnoreCase(attributeValue);
		} catch (Exception e) {
			logger.error("Unable to get attribute for webElement " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Determine if an element has a specific attribute value or not.
	 * 
	 * @param webElement     {@link WebElement} -webElement to click
	 * @param attribute      {@link String } - The specific attribute type to
	 *                       evaluate
	 * @param attributeValue {link String} - The value of the attribute to evaluate
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean verifyAttributeContains(WebElement webElement, String attribute, String attributeValue) {
		boolean status = false;
		waitForElementToBeVisible(webElement);
		try {
			logger.info("Verifying if attribute '" + attribute + "' contains value '" + attributeValue
					+ "' for webElement: " + webElement.toString());
			status = webElement.getAttribute(attribute).toUpperCase().contains(attributeValue.toUpperCase());
		} catch (Exception e) {
			logger.error("Unable to verify if attribute contains for webElement " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Waits for element to have specific attribute value
	 * 
	 * @param webElement     {@link WebElement} -webElement to click
	 * @param attribute      {@link String } - The specific attribute type to
	 *                       evaluate
	 * @param attributeValue {link String} - The value of the attribute to evaluate
	 * @param timeOut        {@link int} - The value of the timeout
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean waitForAttributeContains(WebElement webElement, String attribute, String attributeValue) {
		boolean status = false;
		try {
			logger.info("Waiting for attribute '" + attribute + "' of webElement to contain value '" + attributeValue
					+ "': " + webElement.toString());
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.attributeContains(webElement, attribute, attributeValue));
			status = webElement.getAttribute(attribute).toUpperCase().contains(attributeValue.toUpperCase());
			status = true;
		} catch (Exception e) {
			logger.error("Unable to verify if attribute contains for webElement " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Scroll to element
	 * 
	 * @param webElement {@link WebElement} -webElement to click
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean scrollToElement(WebElement webElement) {
		boolean status = false;
		wait.until(ExpectedConditions.visibilityOf(webElement));
		try {
			if (webElement == null) {
				logger.error("Cannot scroll to null WebElement.");
				throw new IllegalArgumentException("WebElement is null.");
			}
			highlightElement(webElement);
			pause(500);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
			logger.info("Scrolled to element: {}", webElement);
			status = true;
		} catch (Exception e) {
			String errorMsg = String.format("An error occurred while scrolling to the element: %s. Error: %s",
					webElement, e.getMessage());
			logger.error(errorMsg, e);
			throw new RuntimeException(errorMsg, e);
		}
		return status;
	}

	/********************************************************************************************
	 * Pause the test action
	 * 
	 * @param waitTime {@link Integer} - The amount of the time in milliseconds to
	 *                 pause
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static void pause(Integer waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (Exception e) {
			logger.error("Thread was interrupted while pausing for {" + waitTime + "} milliseconds", waitTime, e);
			Thread.currentThread().interrupt();
		}
	}

	/********************************************************************************************
	 * Splits a given string into an array of substrings based on commas, trimming
	 * any leading and trailing whitespace from each substring.
	 * 
	 * @param text The string to be split.
	 * @return An array of substrings.@param waitTime {@link Integer} - The amount
	 *         of the time in milliseconds to pause
	 * 
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static String[] splitString(String text) {
		logger.info("Splitting string: {}", text);
		String[] list = text.trim().split("\\s*,\\s*");
		logger.debug("Split result: {}", (Object) list);
		return list;
	}

	/********************************************************************************************
	 * Generates a random email address and sets it in the configuration.
	 * 
	 * @return The generated email address.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static String setEmail() {
		String email = null;
		try {
			final String randomEmail = UUID.randomUUID().toString().replace("-", " ") + "@" + "gmail.com";
			Config.emailaddr = "qa" + "." + randomEmail;
			logger.info("Email generated is: " + Config.emailaddr);
			email = Config.emailaddr;
		} catch (Exception e) {
			logger.error("Unable to generate random email: " + e);
		}
		return email;
	}

	/********************************************************************************************
	 * Checks if an element with the specified text is present on the page. If the
	 * element is found, it scrolls into view and highlights it.
	 * 
	 * @param text The text to search for in the element.
	 * @return True if the element is found and visible, otherwise false.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean getElementByText(String text) {
		boolean status = false;
		WebElement getElementByText;
		try {
			getElementByText = driver.findElement(By.xpath("(//*[contains(text(),\"" + text + "\")])[]1]"));
			ElementInteractionUtils.scrollToElement(getElementByText);
			if (ElementInteractionUtils.isPresent(getElementByText, 60)
					|| ElementInteractionUtils.waitForElementToBeVisible(getElementByText)) {
				status = true;
				logger.info("Element is present and text is " + getElementByText.getText());
				highlightElement(getElementByText);
			} else {
				status = false;
				logger.warn("Element is not present or not visible.");
			}
		} catch (Exception e) {
			logger.error("Element not found: " + e.getMessage());
			status = false;
		}
		return status;
	}

	/********************************************************************************************
	 * Verifies if the specified value is selected in a drop-down list or
	 * multi-select element.
	 * 
	 * @param webElement The drop-down list or multi-select element.
	 * @param value      The value to verify if selected.
	 * @return True if the specified value is selected, otherwise false.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean isSelected(WebElement webElement, String value) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.getAllSelectedOptions().size();
			String isSelected = listBox.getFirstSelectedOption().getText();
			if (isSelected.contains(value)) {
				status = true;
			}
		} catch (Exception e) {
			logger.error("Unable to verify if the value is selected from listBox: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Verifies if the specified value is not selected in a drop-down list or
	 * multi-select element.
	 * 
	 * @param webElement The drop-down list or multi-select element.
	 * @param value      The value to verify if not selected.
	 * @return True if the specified value is not selected, otherwise false.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean isNotSelected(WebElement webElement, String value) {
		boolean status = false;
		try {
			waitForElementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			String actual = listBox.getFirstSelectedOption().getText();
			if (!actual.contains(value)) {
				status = true;
			}
		} catch (Exception e) {
			logger.error("Unable to verify if the value is not selected from listBox: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Highlights the specified WebElement by adding a border and changing its color
	 * temporarily.
	 * 
	 * @param element The WebElement to highlight.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static void highlightElement(WebElement webElement) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String originalStyle = webElement.getAttribute("style");
			// Check if the element is a dropdown (select element)
	        String tagName = webElement.getTagName();
	        String highlightStyle;
	        if ("select".equalsIgnoreCase(tagName)) {
	            // Style for dropdowns (select element)
	            highlightStyle = "border: 2px solid red !important; border-style: dashed !important;";
	        } else if ("option".equalsIgnoreCase(tagName)) {
	            // Style for dropdown options (option element)
	            highlightStyle = "border: 2px solid red !important; border-style: dashed !important;";
	        } else if ("button".equalsIgnoreCase(tagName) || "input".equalsIgnoreCase(tagName) && "button".equalsIgnoreCase(webElement.getAttribute("type"))) {
	            // Style for buttons (button or input type="button")
	            highlightStyle = "border: 2px solid red !important; border-style: dashed !important;";
	        } else {
	            // Standard highlight style for other elements
	            highlightStyle = "border: 2px solid red !important; border-style: dashed !important;";
	        }
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement, highlightStyle);
			//logger.info("Element highlighted: {}", webElement.toString());
			Thread.sleep(500); // Highlight duration in milliseconds
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement, originalStyle);
			// logger.info("Element highlight removed: {}", webElement.toString());
		} catch (InterruptedException e) {
			logger.error("Interrupted Exception during element highlighting: ", e);
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			logger.error("Exception occurred while highlighting element: ", e);
		}
	}

	public static void highlightElement(By locator) {
		WebElement webElement = driver.findElement(locator);
		highlightElement(webElement);
	}

	public static void highlightElement(int x) {
		WebElement webElement = driver.findElement(
				By.xpath(String.format("//*[contains(@style, 'left: %dpx') and contains(@style, 'top: %dpx')]", x)));
		highlightElement(webElement);
	}

	public static void highlightElement(String visibleText) {
		WebElement webElement = driver.findElement(By.xpath(String.format("//*[text()='%s']", visibleText)));
		highlightElement(webElement);
	}

//	public static void highlightElement(String partialText) {
//		WebElement webElement = driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]", partialText)));
//		highlightElement(webElement);
//	}

	/********************************************************************************************
	 * Verifies the presence of page text based on the provided test data.
	 * 
	 * @param testData a map containing test data.
	 * @return true if all page texts are present, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean verifyPageContainsText(Map<String, String> testData) {
		boolean status = false;
		try {
			String[] verifyingPageText;
			verifyingPageText = testData.get("VerifyPageText").split("\\|");
			int count = verifyingPageText.length;
			logger.info("Size: " + count);
			for (int i = 0; i < count; i++) {
				boolean webelement = false;
				try {
					webelement = ElementInteractionUtils.getElementByText(verifyingPageText[i]);
				} catch (Exception e) {
					logger.error("Error occurred while verifying page text: ", e);
				}
				if (webelement) {
					logger.info(verifyingPageText[i] + "is present");
					status = true;
				} else {
					logger.error(verifyingPageText[i] + "is not present");
					status = false;
				}
			}
		} catch (Exception e) {
			logger.error("Element not found: ", e);
			status = false;
		}
		return status;
	}

	/********************************************************************************************
	 * Moves the mouse cursor to the specified WebElement.
	 * 
	 * @param webElement The WebElement to hover over.
	 * @return true if the mouse hover operation was successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean mouseHover(WebElement webElement) {
		boolean status = false;
		try {
			if (webElement.isDisplayed()) {
				logger.info("hovering over element: " + webElement);
				Actions action = new Actions(driver);
				highlightElement(webElement);
				action.moveToElement(webElement).build().perform();
				status = true;
			}
		} catch (Exception e) {
			logger.error("Problem in hovering over element: " + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Double clicks on the specified WebElement.
	 * 
	 * @param webElement The WebElement to double click on.
	 * @return true if the action was successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean doubleClick(WebElement webElement) {
		boolean status = false;
		try {
			if (webElement.isDisplayed()) {
				logger.info("Double clicking on element: " + webElement);
				Actions action = new Actions(driver);
				highlightElement(webElement);
				action.doubleClick(webElement).perform();
				status = true;
			}
		} catch (Exception e) {
			logger.error("Problem in double clicking on element:" + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Right clicks on the specified WebElement.
	 * 
	 * @param webElement The WebElement to right click on.
	 * @return true if the action was successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean rightClick(WebElement webElement) {
		boolean status = false;
		try {
			if (webElement.isDisplayed()) {
				logger.info("Right clicking on element: " + webElement);
				highlightElement(webElement);
				action.contextClick(webElement).perform();
				status = true;
			}
		} catch (Exception e) {
			logger.error("Problem in right clicking on element:" + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Selects the webelement if it is not already selected and clicks on it.
	 * 
	 * @param WebElement to select and click.
	 * @return true if the action was selected and clicked, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean selectOptionAndClick(WebElement webElement) {
		boolean status = false;
		try {
			if (!webElement.isSelected()) {
				webElement.click();
				status = true;
				logger.info("webelement selected and clicked: " + webElement);
			} else {
				logger.info("webelement is already selected: " + webElement);
			}
		} catch (Exception e) {
			logger.error("Problem in selecting and clicking on element:" + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Clicks the webelement if it is displayed.
	 * 
	 * @param webElement to click.
	 * @return true if the element was displayed and clicked, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean isDisplayedAndClick(WebElement webElement) {
		boolean status = false;
		try {
			if (webElement.isDisplayed()) {
				webElement.click();
				status = true;
				logger.info("webelement displyed and clicked: " + webElement);
			} else {
				logger.info("webelement is not displayed: " + webElement);
			}
		} catch (Exception e) {
			logger.error("Problem in displaying and clicking on element: " + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Clicks the webelement if it is enabled.
	 * 
	 * @param WebElement to click.
	 * @return true if the element was enabled and clicked, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/

	public static boolean isEnabledAndClick(WebElement webElement) {
		boolean status = false;
		try {
			if (webElement.isEnabled()) {
				webElement.click();
				status = true;
				logger.info("webelement enabled and clicked: " + webElement);
			} else {
				logger.info("webelement is not enabled: " + webElement);
			}
		} catch (Exception e) {
			logger.error("Problem in enabling and clicking on element: " + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Clicks the webelement of table
	 * 
	 * @param WebElement to click.
	 * @return true if the element was enabled and clicked, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/

	public static boolean webTables(WebElement webElement) {
		boolean status = false;
		String sRow = "1";
		String sCol = "2";
		// Here we are locating the xpath by passing variables in the xpath
		String sCellValue = driver
				.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
		System.out.println(sCellValue);
		String sRowValue = "Clock Tower Hotel";

		// First loop will find the 'ClOCK TWER HOTEL' in the first column
		for (int i = 1; i <= 5; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
			if (sValue.equalsIgnoreCase(sRowValue)) {
				// If the sValue match with the description, it will initiate one more inner
				// loop for all the columns of 'i' row
				for (int j = 1; j <= 5; j++) {
					String sColumnValue = driver
							.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText();
					System.out.println(sColumnValue);
				}
				break;
			}
		}

		return status;
	}

	/********************************************************************************************
	 * Drag and drop the element
	 * 
	 * @param source WebElement to move.
	 * @param target WebElement where to move.
	 * @return true if the element was enabled and clicked, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/

	public static boolean dragAndDrop(WebElement source, WebElement target) {
		boolean status = false;
		try {
			action.dragAndDrop(source, target).perform();
			status = true;
			logger.info("webelement moved from source" + source + " to target " + target);
		} catch (Exception e) {
			logger.error("Problem in dragAndDroping element " + e.getMessage());
		}
		return status;
	}

	public static void keyDown(WebElement webElement, String inputString, String string) {
		try {
			action.keyDown(webElement, "keys" + "." + "string");
			System.out.println();
			action.sendKeys(webElement, inputString);
			action.keyUp(string).perform();
			logger.info("Performed keyDown action with key: " + string + ", and input string: " + inputString);
		} catch (Exception e) {
			logger.error("Unable to perform keyDown action with key: " + string + ", and input string: " + inputString,
					e);
		}
	}

	/********************************************************************************************
	 * Simulates pressing a single key.
	 * 
	 * @param key the key to press
	 * @return true if the key is pressed, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean pressKey(Keys key) {
		boolean status = false;
		try {
			action.sendKeys(key).perform();
			logger.info("Pressed key: " + key.name());
		} catch (Exception e) {
			logger.error("Failed to press key: " + key.name(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Simulates pressing and releasing multiple keys.
	 * 
	 * @param keys the keys to press and release
	 * @return true if the key is pressed, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean pressKeys(Keys... keys) {
		boolean status = false;
		try {
			for (Keys key : keys) {
				action.keyDown(key);
			}
			for (Keys key : keys) {
				action.keyUp(key);
			}
			action.perform();
			logger.info("Pressed keys: " + keys);
		} catch (Exception e) {
			logger.error("Failed to press keys: " + keys, e);
		}
		return status;
	}

	/********************************************************************************************
	 * Simulates pressing a key on a specific element.
	 * 
	 * @param element the WebElement to send the key to
	 * @param key     the key to press
	 * @return true if the key is pressed, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean pressKeyOnElement(WebElement webElement, Keys key) {
		boolean status = false;
		try {
			action.sendKeys(webElement, key).perform();
			logger.info("Pressed key: " + key.name() + " on element: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Failed to press key: " + key.name() + " on element: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Simulates typing text into a specific element.
	 * 
	 * @param element the WebElement to send the text to
	 * @param text    the text to type
	 * @return true if the key is pressed, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean typeText(WebElement webElement, String text) {
		boolean status = false;
		try {
			action.sendKeys(webElement, text).perform();
			logger.info("Typed text: " + text + " on element: " + webElement.toString());
		} catch (Exception e) {
			logger.error("Failed to type text: " + text + " on element: " + webElement.toString(), e);
		}
		return status;
	}

	/********************************************************************************************
	 * Simulates pressing Enter key.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressEnter() {
		pressKey(Keys.ENTER);
	}

	/********************************************************************************************
	 * Simulates pressing Tab key.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressTab() {
		pressKey(Keys.TAB);
	}

	/********************************************************************************************
	 * Simulates pressing Escape key.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressEscape() {
		pressKey(Keys.ESCAPE);
	}

	/********************************************************************************************
	 * Simulates pressing Backspace key.
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressBackspace() {
		pressKey(Keys.BACK_SPACE);
	}

	/********************************************************************************************
	 * Simulates pressing the combination of Ctrl + key.
	 * 
	 * @param key the key
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/

	public void pressCtrlAndKey(Keys key) {
		pressKeys(Keys.CONTROL, key);
	}

	/********************************************************************************************
	 * Simulates pressing the combination of Shift + key.
	 * 
	 * @param key the key to press with Shift
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressShiftAndKey(Keys key) {
		pressKeys(Keys.SHIFT, key);
	}

	/********************************************************************************************
	 * Simulates pressing the combination of Alt + key.
	 * 
	 * @param key the key to press with Alt
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void pressAltAndKey(Keys key) {
		pressKeys(Keys.ALT, key);
	}

	/********************************************************************************************
	 * Simulates releasing a key.
	 * 
	 * @param key the key to release
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public void releaseKey(Keys key) {
		try {
			action.keyUp(key).perform();
			logger.info("Released key: " + key.name());
		} catch (Exception e) {
			logger.error("Failed to release key: " + key.name(), e);
		}
	}

	/********************************************************************************************
	 * Simulates copying text from one element and pasting it into another.
	 * 
	 * @param sourceElement      the WebElement to copy text from
	 * @param destinationElement the WebElement to paste text into
	 * 
	 * @author Abhijeet Maske Created June 22,2024
	 * @version 1.0 June 22,2024
	 ********************************************************************************************/
	public static boolean copyAndPaste(WebElement sourceElement, WebElement destinationElement) {
		boolean status = false;
		try {
			action.click(sourceElement).keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL)
					.click(destinationElement).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			logger.info("Copied text from element: " + sourceElement.toString() + " and pasted into element: "
					+ destinationElement.toString());
		} catch (Exception e) {
			logger.error("Unable to Copy text from element: " + sourceElement.toString() + " and pasted into element: "
					+ destinationElement.toString());
		}
		return status;
	}

	/********************************************************************************************
	 * Switches to a different window based on the index provided.
	 * 
	 * @param value The index of the window to switch to.
	 * @return true if the window was successfully switched, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/

	public static boolean switchWindow(int value) {
		boolean status = false;
		Set<String> windowHandles;
		windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		int numWindows = windowHandlesList.size();
		if (numWindows > 1 && value >= 0 && value < numWindows) {
			driver.switchTo().window(windowHandlesList.get(value));
			status = true;
		}
		return status;
	}

	/********************************************************************************************
	 * Closes the current window and switches to the first window in the window
	 * handles list.
	 * 
	 * @param value Unused parameter. Keeping for compatibility with other methods.
	 * @return true if the window was successfully closed and switched, false
	 *         otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/

	public static boolean closeWindow(int Value) {
		boolean status = false;
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		if (windowHandlesList.size() > 1) {
			driver.close();
			driver.switchTo().window(windowHandlesList.get(0));
			status = true;
		}
		return status;
	}

	/********************************************************************************************
	 * Switch to frame
	 * 
	 * @param indexOrNameOrId {@link String} - Id, Name or Index of the frames
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean switchToFrame(String indexOrNameOrId) {
		boolean status = false;
		try {
			logger.info("Switching to frame: " + indexOrNameOrId);
			((RemoteWebDriver) driver).switchTo().frame(indexOrNameOrId);
			status = true;
		} catch (Exception e) {
			logger.error("Unable to switch to frame: " + indexOrNameOrId, e);
		}
		return status;
	}

	/********************************************************************************************
	 * Switch to default frame
	 * 
	 * @param idNameIndex {@link String} - Id, Name or Index of the frames
	 * @return status {@link boolean} - true/false
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean switchToDefaultContent() {
		boolean status = false;
		try {
			logger.info("Switching to default content");
			((RemoteWebDriver) driver).switchTo().defaultContent();
			status = true;
		} catch (Exception e) {
			logger.error("Unable to switch to default content", e);
		}
		return status;
	}

	/********************************************************************************************
	 * Navigates back to the previous page.
	 * 
	 * @return true if the navigation is successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean navigateBack() {
		boolean status = false;
		try {
			driver.navigate().back();
			status = true;
		} catch (Exception e) {
			logger.error("Navigation back failed: ", e);
		}
		return status;
	}

	/**
	 * Navigates forward to the next page.
	 */
	public static boolean navigateForward() {
		boolean status = false;
		try {
			driver.navigate().forward();
			logger.info("Navigated forward to the next page.");
			status = true;
		} catch (Exception e) {
			logger.error("Failed to navigate forward to the next page.", e);
		}
		return status;
	}

	/********************************************************************************************
	 * Refreshes the current page.
	 * 
	 * @return true if the page refresh was successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created June 27,2023
	 * @version 1.0 June 27,2023
	 ********************************************************************************************/
	public static boolean refresh() {
		boolean status = false;
		try {
			driver.navigate().refresh();
			action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();
			status = true;
		} catch (Exception e) {
			logger.error("Failed to refresh the page: " + e.getMessage());
		}
		return status;
	}

	/********************************************************************************************
	 * Verifies if a specified text is present in a table column.
	 * 
	 * @param tableId          The ID of the table.
	 * @param tableColumnIndex The column index to search in.
	 * @param searchText       The text to search for.
	 * @param nextButton       The WebElement representing the next button.
	 * @return True if the text is found, false otherwise.
	 * @return true if the page refresh was successful, false otherwise.
	 * 
	 * @author Abhijeet Maske Created July 08,2024
	 * @version 1.0 July 08,2024
	 ********************************************************************************************/
	public static boolean verifyTextInTable(String tableId, int tableColumnIndex, String searchText,
			WebElement nextButton) {
		try {
			WebElement table = driver.findElement(By.id(tableId));
			List<WebElement> tableEntries = table.findElements(By.tagName("tr"));
			String rowXpathPrefix = "//table[@id='" + tableId + "']/tbody/tr[";
			String colXpathSuffix = "]/td[" + tableColumnIndex + "]";
			@SuppressWarnings("unused")
			int rowCount = 0;
			while (true) {
				int tableSize = tableEntries.size();
				logger.info("Current number of table entries: {}", tableSize);

				for (int i = 1; i <= tableSize; i++) {
					String cellValue = driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)).getText();
					if (cellValue.contains(searchText)) {
						highlightElement(searchText);
						pause(100);
						logger.info("Text '{}' found in cell value: {}", searchText, cellValue);
						return true;
					}
				}

				if (nextButton != null && nextButton.isEnabled()) {
					nextButton.click();
					logger.info("Next button clicked, checking the next set of entries");
					rowCount += tableSize;
					// Re-fetch the table entries after clicking next
					tableEntries = driver.findElement(By.id(tableId)).findElements(By.tagName("tr"));
				} else {
					logger.info("Reached the end of the table, text '{}' not found", searchText);
					break;
				}
			}
			logger.info("Search completed. Text '{}' not found in the table", searchText);
			return false;
		} catch (Exception e) {
			logger.error("Exception occurred while verifying text in table: ", e);
			return false;
		}
	}

	/********************************************************************************************
	 * Verifies if a specified text is present in a table column and performs an
	 * action if found.
	 * 
	 * @param tableId             The ID of the table.
	 * @param tableColumnIndex    The column index to search in.
	 * @param searchText          The text to search for.
	 * @param nextButton          The WebElement representing the next button.
	 * @param actionButtonPrefix  The XPath prefix for locating the action button
	 *                            within the same row.
	 * @param actionButtonPostfix The XPath postfix for locating the action button
	 *                            within the same row.
	 * @return True if the text is found and action performed, false otherwise.
	 * 
	 * @version 1.0 July 08, 2024
	 ********************************************************************************************/
	public static boolean verifyTextInTableAndPerformAction(String tableId, int tableColumnIndex, String searchText,
			WebElement nextButton, String actionButtonPrefix, String actionButtonPostfix) {
		try {
			WebElement table = driver.findElement(By.id(tableId));
			List<WebElement> tableEntries = table.findElements(By.tagName("tr"));
			String rowXpathPrefix = "//table[@id='" + tableId + "']/tbody/tr[";
			String colXpathSuffix = "]/td[" + tableColumnIndex + "]";
			@SuppressWarnings("unused")
			int rowCount = 0;

			while (true) {
				int tableSize = tableEntries.size();
				logger.info("Current number of table entries: {}", tableSize);

				for (int i = 1; i <= tableSize; i++) {
					String cellValue = driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)).getText();
					if (cellValue.contains(searchText)) {
						highlightElement(searchText);
						logger.info("Text '{}' found in cell value: {}", searchText, cellValue);
						WebElement actionElement = driver
								.findElement(By.xpath(actionButtonPrefix + i + actionButtonPostfix));
						if (actionElement.isDisplayed()) {
							actionElement.click();
							logger.info("Action performed on text '{}'", searchText);
							return true;
						}
					}
				}

				if (nextButton != null && nextButton.isEnabled()) {
					nextButton.click();
					logger.info("Next button clicked, checking the next set of entries");
					rowCount += tableSize;
					// Re-fetch the table entries after clicking next
					tableEntries = driver.findElement(By.id(tableId)).findElements(By.tagName("tr"));
				} else {
					logger.info("Reached the end of the table, text '{}' not found", searchText);
					break;
				}
			}
			logger.info("Search completed. Text '{}' not found in the table", searchText);
			return false;
		} catch (Exception e) {
			logger.error("Exception occurred while verifying text in table: ", e);
			return false;
		}
	}

	/********************************************************************************************
	 * Verifies if a specified text is present in a table column and performs an
	 * action if found.
	 * 
	 * @param tableId                The ID of the table.
	 * @param tableColumnIndex       The column index to search in.
	 * @param searchText             The text to search for.
	 * @param nextButton             The WebElement representing the next button.
	 * @param additionalLookupValues A map containing column indexes and expected
	 *                               values for additional verification within the
	 *                               same row.
	 * @return True if the text is found, false otherwise.
	 * 
	 * @version 1.0 July 08, 2024
	 ********************************************************************************************/
	public static boolean verifyTableData(String tableId, int tableColumnIndex, String searchText,
			WebElement nextButton, Map<Integer, String> additionalLookupValues) {
		try {
			WebElement table = driver.findElement(By.id(tableId));
			scrollToElement(table);
			List<WebElement> tableEntries = table.findElements(By.tagName("tr"));
			String rowXpathPrefix = "//table[@id='" + tableId + "']/tbody/tr[";
			String colXpathSuffix = "]/td[" + tableColumnIndex + "]";
			@SuppressWarnings("unused")
			int rowCount = 0;

			while (true) {
				int tableSize = tableEntries.size() - 1;
				for (int i = 1; i <= tableSize; i++) {
					highlightElement(driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)));
					String cellValue = driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)).getText();
					if (cellValue.contains(searchText)) {
						highlightElement(driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)));
						logger.info("Text '{}' found in cell value: {}", searchText, cellValue);
						boolean allValuesMatch = true;
						for (Map.Entry<Integer, String> entry : additionalLookupValues.entrySet()) {
							int lookupColumnIndex = entry.getKey();
							String expectedValue = entry.getValue();
							String actualValue = driver
									.findElement(By.xpath(rowXpathPrefix + i + "]/td[" + lookupColumnIndex + "]"))
									.getText();
							highlightElement(actualValue);
							if (!actualValue.equals(expectedValue)) {
								allValuesMatch = false;
								logger.info("Mismatch found in column {}: expected '{}', but got '{}'",
										lookupColumnIndex, expectedValue, actualValue);
								break;
							}
						}
						if (allValuesMatch) {
							logger.info("All lookup values match for text '{}'", searchText);
							return true;
						}
					}
				}

				if (nextButton != null && nextButton.isEnabled()) {
					highlightElement(nextButton);
					WebElement Copyright = driver.findElement(By.xpath("//*[@id='app']/div[2]/footer/div/a"));
					scrollToElement(Copyright);
					nextButton.click();
					rowCount += tableSize;
					// Re-fetch the table entries after clicking next
					tableEntries = driver.findElement(By.id(tableId)).findElements(By.tagName("tr"));
				} else {
					logger.info("Reached the end of the table, text '{}' not found", searchText);
					break;
				}
			}
			logger.info("Search completed. Text '{}' not found in the table", searchText);
			return false;
		} catch (Exception e) {
			logger.error("Exception occurred while verifying text in table and performing action: ", e);
			return false;
		}
	}

	/********************************************************************************************
	 * Verifies if a specified text is present in a table column and performs an
	 * action if found.
	 * 
	 * @param tableId                The ID of the table.
	 * @param tableColumnIndex       The column index to search in.
	 * @param searchText             The text to search for.
	 * @param nextButton             The WebElement representing the next button.
	 * @param actionButtonPrefix     The XPath prefix for locating the action button
	 *                               within the same row.
	 * @param actionButtonPostfix    The XPath postfix for locating the action
	 *                               button within the same row.
	 * @param additionalLookupValues A map containing column indexes and expected
	 *                               values for additional verification within the
	 *                               same row.
	 * @return True if the text is found and action performed, false otherwise.
	 * 
	 * @version 1.0 July 08, 2024
	 ********************************************************************************************/
	public static boolean verifyTableDataAndPerformAction(String tableId, int tableColumnIndex, String searchText,
			WebElement nextButton, WebElement actionButton, Map<Integer, String> additionalLookupValues) {
		try {
			WebElement table = driver.findElement(By.id(tableId));
			List<WebElement> tableEntries = table.findElements(By.tagName("tr"));
			String rowXpathPrefix = "//table[@id='" + tableId + "']/tbody/tr[";
			String colXpathSuffix = "]/td[" + tableColumnIndex + "]";
			@SuppressWarnings("unused")
			int rowCount = 0;

			while (true) {
				int tableSize = tableEntries.size();
				logger.info("Current number of table entries: {}", tableSize);

				for (int i = 1; i <= tableSize; i++) {
					String cellValue = driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)).getText();
					if (cellValue.contains(searchText)) {
						highlightElement(driver.findElement(By.xpath(rowXpathPrefix + i + colXpathSuffix)));
						logger.info("Text '{}' found in cell value: {}", searchText, cellValue);
						boolean allValuesMatch = true;
						for (Map.Entry<Integer, String> entry : additionalLookupValues.entrySet()) {
							int lookupColumnIndex = entry.getKey();
							String expectedValue = entry.getValue();
							String actualValue = driver
									.findElement(By.xpath(rowXpathPrefix + i + "]/td[" + lookupColumnIndex + "]"))
									.getText();
							highlightElement(actualValue);

							if (!actualValue.equals(expectedValue)) {
								allValuesMatch = false;
								logger.info("Mismatch found in column {}: expected '{}', but got '{}'",
										lookupColumnIndex, expectedValue, actualValue);
								break;
							}
						}

						if (allValuesMatch) {
							logger.info("All lookup values match for text '{}'", searchText);
							if (actionButton.isDisplayed()) {
								highlightElement(actionButton);
								actionButton.click();
								logger.info("clickedon action button '{}'", searchText);
								logger.info("Action performed on text '{}'", searchText);
								return true;
							}
						}
					}
				}

				if (nextButton != null && nextButton.isEnabled()) {
					nextButton.click();
					logger.info("Next button clicked, checking the next set of entries");
					rowCount += tableSize;
					// Re-fetch the table entries after clicking next
					tableEntries = driver.findElement(By.id(tableId)).findElements(By.tagName("tr"));
				} else {
					logger.info("Reached the end of the table, text '{}' not found", searchText);
					break;
				}
			}
			logger.info("Search completed. Text '{}' not found in the table", searchText);
			return false;
		} catch (Exception e) {
			logger.error("Exception occurred while verifying text in table and performing action: ", e);
			return false;
		}
	}

	/********************************************************************************************
	 * Uploads a file to the specified web element (e.g., file input field).
	 * 
	 * This method accepts the file path and sends it to the upload input field,
	 * allowing the file to be uploaded.
	 * 
	 * @param uploadButton the web element (file input field) where the file will be
	 *                     uploaded
	 * @param filePath     the absolute path of the file to be uploaded
	 * @throws Exception if an error occurs during the file upload process
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static void uploadFile(WebElement uploadButton, String filePath) throws Exception {
		try {
			File file = new File(filePath);
			if (file.exists() && file.isFile()) {
				uploadButton.sendKeys(file.getAbsolutePath());
				logger.info("File uploaded successfully: {}", filePath);
			} else {
				logger.error("File not found or invalid: {}", filePath);
				throw new FileNotFoundException("File not found or invalid: " + filePath);
			}
		} catch (Exception e) {
			logger.error("Error during file upload: {}", filePath, e);
			throw e;
		}
	}

	/********************************************************************************************
	 * Retrieves the visible text of a web element. This method attempts to retrieve
	 * the text content of the provided web element.
	 * 
	 * @param webElement the web element from which the text is to be retrieved
	 * @return the visible text of the web element, or `null` if an exception occurs
	 * 
	 * @author Abhijeet Maske Created August 20, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/

	public static String getElementVisibleText(WebElement webElement) {
		String text = null;
		try {
			text = webElement.getText();
			logger.info("Successfully retrieved the visible text: '{}'", text);
		} catch (Exception e) {
			logger.error("Exception occurred while retrieving the visible text from the WebElement: {}", webElement, e);
		}
		return text;
	}

	/* Datepicker Start */
	/********************************************************************************************
	 * Selects a date from a date picker UI element. This method validates the date
	 * format, navigates through the calendar UI, and selects the specified date.
	 * 
	 * @param date              the date to be selected in the format DD/MM/YYYY
	 * @param webElement        the web element representing the date picker input
	 *                          field
	 * @param DatePicker_Switch the XPath expression for the calendar's switch
	 *                          button (e.g., year selector)
	 * @param DatePicker_Header the XPath expression for the calendar's header
	 *                          (e.g., displaying the year)
	 * @param DatePicker_prev   the XPath expression for the previous year button
	 * @param DatePicker_next   the XPath expression for the next year button
	 * 
	 * @throws InterruptedException if the thread is interrupted during execution
	 * @throws RuntimeException     if an error occurs during date selection
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static void datePicker(String date, WebElement webElement) throws InterruptedException {
		try {
			if (!isValidDateFormat(date)) {
				logger.error("Invalid date format: {}. Expected format is DD/MM/YYYY.", date);
				throw new IllegalArgumentException("Invalid date format: " + date);
			}
			webElement.click();
			WebElement yearToggleButton = driver.findElement(By.xpath("//*[@id='datePickerHeader']"));
			highlightElement(yearToggleButton);
			yearToggleButton.click();

			String displayedYearText = driver.findElement(By.xpath("(//*[@id=\"datePickerHeader\"])[2]")).getText();
			logger.info("Displayed Calendar Year: {}", displayedYearText);

			int displayedYear = Integer.parseInt(displayedYearText);
			String[] dateParts = date.split("/");
			String selectedDay = dateParts[0];
			String selectedMonth = convertMonthNumberToName(Integer.parseInt(dateParts[1]));
			int selectedYear = Integer.parseInt(dateParts[2]);
			logger.info("Selected Year: {}", selectedYear);

			navigateToYear(displayedYear, selectedYear);

			WebElement monthElement = WebElementLocators.xpathByTagnameAndText("span", selectedMonth);
			highlightElement(monthElement);
			monthElement.click();

			WebElement dayElement = WebElementLocators.xpathByClassAndText("day", selectedDay);
			highlightElement(dayElement);
			dayElement.click();

			logger.info("Date selected: {}/{}/{}", selectedDay, selectedMonth, selectedYear);
		} catch (Exception e) {
			logger.error("An error occurred while selecting the date: {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/********************************************************************************************
	 * Navigates the calendar to the target year.
	 * 
	 * This method calculates the difference between the currently displayed year
	 * and the target year, and clicks the appropriate navigation button until the
	 * target year is displayed.
	 * 
	 * @param displayedYear     the currently displayed year on the calendar
	 * @param targetYear        the year to navigate to
	 * @param DatePicker_Header the XPath expression for the calendar's header
	 *                          (e.g., displaying the year)
	 * @param DatePicker_prev   the XPath expression for the previous year button
	 * @param DatePicker_next   the XPath expression for the next year button
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	private static void navigateToYear(int displayedYear, int targetYear) {
		int yearDifference = displayedYear - targetYear;
		if (yearDifference != 0) {
			By navigationButtonLocator = By.xpath(
					yearDifference > 0 ? "(//*[@id=\"datePickerPrevious\"])[2]" : "(//*[@id=\"datePickerNext\"])[4]");
			for (int i = 0; i < Math.abs(yearDifference); i++) {
				highlightElement(navigationButtonLocator);
				driver.findElement(navigationButtonLocator).click();
				logger.debug("Navigated to year: {}", targetYear);
			}
			logger.info("Displayed Year after selection: {}",
					driver.findElement(By.xpath("(//*[@id=\"datePickerHeader\"])[2]")).getText());
		}
	}

	/********************************************************************************************
	 * Converts a numeric month to its corresponding abbreviated name.
	 * 
	 * This method converts the given month number (1-12) into its corresponding
	 * month name (e.g., 1 -> Jan, 2 -> Feb).
	 * 
	 * @param monthNumber the numeric month (1-12)
	 * @return the abbreviated month name (e.g., "Jan", "Feb") *
	 * @throws IllegalArgumentException if the month number is invalid
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static String convertMonthNumberToName(int monthNumber) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		if (monthNumber >= 1 && monthNumber <= 12) {
			return months[monthNumber - 1];
		} else {
			logger.error("Invalid month number: {}", monthNumber);
			throw new IllegalArgumentException("Invalid month number: " + monthNumber);
		}
	}

	/********************************************************************************************
	 * Retrieves text from an element using a dynamic XPath expression.
	 * 
	 * This method waits until the element located by the provided XPath expression
	 * is visible, then retrieves and returns the text content of that element.
	 * 
	 * @param xpathExpression the XPath expression used to locate the element
	 * @return the text content of the located element
	 * 
	 * @throws Exception if an error occurs while locating or retrieving the
	 *                   element's text
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	public static String getTextByDynamicXpath(String xpathExpression) {
		try {
			Duration XSMALL_PAUSE = Duration.ofSeconds(Config.XSMALL_PAUSE);
			WebDriverWait wait = new WebDriverWait(driver, XSMALL_PAUSE);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			String elementText = element.getText();
			logger.info("Text retrieved from element: {}", elementText);
			return elementText;
		} catch (Exception e) {
			logger.error("Error retrieving text with XPath {}: {}", xpathExpression, e.getMessage());
			throw e;
		}
	}

	/********************************************************************************************
	 * Validates whether the given date is in the format DD/MM/YYYY and is a valid
	 * calendar date.
	 * 
	 * This method uses regular expressions and the `SimpleDateFormat` class to
	 * ensure that the date is correctly formatted and represents a valid date on
	 * the calendar.
	 * 
	 * @param date the date string to validate
	 * @return `true` if the date is valid and correctly formatted, `false`
	 *         otherwise
	 * 
	 * @author Abhijeet Maske Created August 17, 2024
	 * @version 1.0 August 17, 2024
	 ********************************************************************************************/
	private static boolean isValidDateFormat(String date) {
		// Regular expression to validate the date format DD/MM/YYYY
		String datePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		if (!Pattern.matches(datePattern, date)) {
			return false;
		}
		// Split the date to check day and month range
		String[] dateParts = date.split("/");
		int day = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);

		// Additional check to ensure the date is valid (e.g., no 30th of February)
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(date); // Parse the date to ensure it's valid
		} catch (ParseException e) {
			return false;
		}
		// Ensure day is between 1-31 and month is between 1-12
		if (day < 1 || day > 31 || month < 1 || month > 12) {
			return false;
		}
		return true;
	}
	/* Datepicker end */
}