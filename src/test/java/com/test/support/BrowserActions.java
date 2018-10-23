package com.test.support;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

/**
 * Wrapper for Selenium WebDriver actions which will be performed on browser
 * 
 * Wrappers are provided with exception handling which throws Skip Exception on
 * occurrence of NoSuchElementException
 * 
 */
public class BrowserActions {

	public static String MOUSE_HOVER_JS = "var evObj = document.createEvent('MouseEvents');"
			+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
			+ "arguments[0].dispatchEvent(evObj);";

	/**
	 * Wrapper to type a text in browser text field
	 * 
	 * @param txt
	 *            : WebElement of the Text Field
	 * @param txtToType
	 *            : Text to type [String]
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void typeOnTextField(WebElement txt, String txtToType, WebDriver driver, String elementDescription)
			throws Exception {

		if (!Utils.waitForElement(driver, txt))
			throw new Exception(elementDescription + " field not found in page!!");

		try {
			txt.clear();
			txt.sendKeys(txtToType);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " field not found in page!!");

		}

	}// typeOnTextField

	/**
	 * Wrapper to type a text in browser text field
	 * 
	 * @param txt
	 *            : String Input (CSS Locator)
	 * @param txtToType
	 *            : Text to type [String]
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void typeOnTextField(String txt, String txtToType, WebDriver driver, String elementDescription)
			throws Exception {

		WebElement element = checkLocator(driver, txt);
		if (!Utils.waitForElement(driver, element, 1))
			throw new Exception(elementDescription + " field not found in page!!");

		try {
			element.clear();
			element.click();
			element.sendKeys(txtToType);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " field not found in page!!");

		}

	}// typeOnTextField

	/**
	 * Wrapper to type a text in browser text field
	 * 
	 * @param txt
	 *            : String Input (CSS Locator)
	 * @param txtToType
	 *            : Text to type [String]
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void javascriptType(String txt, String txtToType, WebDriver driver, String elementDescription)
			throws Exception {

		WebElement element = checkLocator(driver, txt);
		if (!Utils.waitForElement(driver, element, 1))
			throw new Exception(elementDescription + " field not found in page!!");

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + txtToType + "';", element);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " field not found in page!!");

		}

	}// typeOnTextField

	public static void scrollToView(WebElement element, WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		BrowserActions.nap(2);
	}

	/**
	 * To scroll into particular element
	 * 
	 * @param driver
	 *            -
	 * @param element
	 *            - the element to scroll to
	 */
	public static void scrollToViewElement(WebElement element, WebDriver driver) {
		try {
			String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
					+ "var elementTop = arguments[0].getBoundingClientRect().top;"
					+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
			((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
			BrowserActions.nap(2);
		} catch (Exception ex) {
			System.out.println("element is not dsplayed");
		}
	}

	public static void nap(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Wrapper to click on button/text/radio/checkbox in browser
	 * 
	 * @param btn
	 *            : WebElement of the Button Field
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 */

	public static int countElements(String xpath, WebDriver driver) {
		return driver.findElements(By.xpath(xpath)).size();
	}

	public static void clickOnElement(WebElement btn, WebDriver driver, String elementDescription) throws Exception {

		if (!Utils.waitForElement(driver, btn))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			btn.click();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

	}// clickOnButton

	/**
	 * Wrapper to click on button/text/radio/checkbox in browser
	 * 
	 * @param btn
	 *            : String Input (CSS Locator) [of the Button Field]
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void clickOnElement(String btn, WebDriver driver, String elementDescription) throws Exception {

		WebElement element = checkLocator(driver, btn);
		if (!Utils.waitForElement(driver, element, 1))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			element.click();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

	}// clickOnButton

	public static void actionClick(WebElement element, WebDriver driver, String elementDescription) throws Exception {
		if (!Utils.waitForElement(driver, element, 5))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click(element).build().perform();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}

	public static void javascriptClick(WebElement element, WebDriver driver, String elementDescription)
			throws Exception {
		if (!Utils.waitForElement(driver, element, 5))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}

	/**
	 * Wrapper to get a text from the provided WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which text to be extract in String format
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static String getText(WebDriver driver, WebElement fromWhichTxtShldExtract, String elementDescription)
			throws Exception {

		String textFromHTMLAttribute = "";

		try {
			textFromHTMLAttribute = fromWhichTxtShldExtract.getText().trim();

			if (textFromHTMLAttribute.isEmpty())
				textFromHTMLAttribute = fromWhichTxtShldExtract.getAttribute("textContent");

		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

		return textFromHTMLAttribute;

	}// getText

	/**
	 * Wrapper to get a text from the provided WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : String Input (CSS Locator) [from which text to be extract in
	 *            String format]
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static String getText(WebDriver driver, String fromWhichTxtShldExtract, String elementDescription)
			throws Exception {

		String textFromHTMLAttribute = "";

		WebElement element = checkLocator(driver, fromWhichTxtShldExtract);

		try {
			textFromHTMLAttribute = element.getText().trim();

			if (textFromHTMLAttribute.isEmpty())
				textFromHTMLAttribute = element.getAttribute("textContent");

		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

		return textFromHTMLAttribute;

	}// getText

	/**
	 * Wrapper to get a text from the provided WebElement's Attribute
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which text to be extract in String format
	 * @param attributeName
	 *            : Attribute Name from which text should be extracted like "style,
	 *            class, value,..."
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static String getTextFromAttribute(WebDriver driver, WebElement fromWhichTxtShldExtract,
			String attributeName, String elementDescription) throws Exception {

		String textFromHTMLAttribute = "";

		try {
			textFromHTMLAttribute = fromWhichTxtShldExtract.getAttribute(attributeName).trim();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

		return textFromHTMLAttribute;

	}// getTextFromAttribute

	/**
	 * Wrapper to get a text from the provided WebElement's Attribute
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : String Input (CSS Locator) [from which text to be extract in
	 *            String format]
	 * @param attributeName
	 *            : Attribute Name from which text should be extracted like "style,
	 *            class, value,..."
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static String getTextFromAttribute(WebDriver driver, String fromWhichTxtShldExtract, String attributeName,
			String elementDescription) throws Exception {

		String textFromHTMLAttribute = "";
		WebElement element = checkLocator(driver, fromWhichTxtShldExtract);

		try {
			textFromHTMLAttribute = element.getAttribute(attributeName).trim();
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

		return textFromHTMLAttribute;

	}// getTextFromAttribute

	/**
	 * Wrapper to select option from combobox in browser and doesn't wait for
	 * spinner to disappear
	 * 
	 * @param btn
	 *            : String Input (CSS Locator) [of the ComboBox Field]
	 * 
	 * @param optToSelect
	 *            : option to select from combobox
	 * 
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void selectFromComboBox(String btn, String optToSelect, WebDriver driver, String elementDescription)
			throws Exception {

		WebElement element = checkLocator(driver, btn);
		if (!Utils.waitForElement(driver, element, 1))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(optToSelect);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

	}// selectFromComboBox

	/**
	 * Wrapper to select option from combobox in browser
	 * 
	 * @param btn
	 *            : WebElement of the combobox Field
	 * 
	 * @param optToSelect
	 *            : option to select from combobox
	 * 
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 * @throws Exception
	 */
	public static void selectFromComboBox(WebElement btn, String optToSelect, WebDriver driver,
			String elementDescription) throws Exception {

		try {
			Select selectBox = new Select(btn);
			selectBox.selectByValue(optToSelect);
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}

	}// selectFromComboBox

	/**
	 * Select drop down value and doesn't wait for spinner.
	 *
	 * @param elementLocator
	 *            the element locator
	 * @param valueToBeSelected
	 *            the value to be selected
	 */
	public static void selectDropDownValue(WebDriver driver, WebElement dropDown, String valueToBeSelected) {
		dropDown.click();
		By valueBy = By.xpath("//li[@data-label='" + valueToBeSelected + "']");
		for (WebElement element : driver.findElements(valueBy)) {
			if (valueToBeSelected.equals(element.getText()) && element.isDisplayed()) {
				element.click();
				break;
			}
		}
	}

	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).clickAndHold(element).build().perform();
	}

	public static void javaScriptMouseHover(WebDriver driver, WebElement element) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		/*
		 * String javaScript =
		 * "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseenter',true, false); "
		 * +
		 * "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('mouseenter');}"
		 * ;
		 */
		((JavascriptExecutor) driver).executeScript(javaScript, element);
	}

	public static void javaScriptMouseHoverForIE(WebDriver driver, WebElement element) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	public static void selectRadioOrCheckbox(WebElement element, String enableOrDisable) {
		if ("YES".equalsIgnoreCase(enableOrDisable)) {
			if (!(isRadioOrCheckBoxSelected(element))) {
				element.click();
			}
		}
		if ("NO".equalsIgnoreCase(enableOrDisable)) {
			if (isRadioOrCheckBoxSelected(element)) {
				element.click();
			}
		}
	}

	public static boolean isRadioOrCheckBoxSelected(WebElement element) {
		if (element.getAttribute("class").contains("active")) {
			return true;
		}

		if (null != element.getAttribute("checked")) {
			return true;
		}

		for (WebElement childElement : element.findElements(By.xpath(".//*"))) {
			if (childElement.getAttribute("class").contains("active")) {
				return true;
			}
		}

		return false;
	}

	public static String getRadioOrCheckboxChecked(WebElement element) {
		if (element.getAttribute("class").contains("active")) {
			return "Yes";
		}

		if (null != element.getAttribute("checked")) {
			return "Yes";
		}

		for (WebElement childElement : element.findElements(By.xpath(".//*"))) {
			if (childElement.getAttribute("class").contains("active")) {
				return "Yes";
			}
		}

		return "No";
	}

	/**
	 * To check whether locator string is xpath or css
	 * 
	 * @param driver
	 * @param locator
	 * @return elements
	 */
	public static List<WebElement> checkLocators(WebDriver driver, String locator) {
		List<WebElement> elements = null;
		if (locator.startsWith("//")) {
			elements = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Couldn't find " + locator)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
		} else {
			elements = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Couldn't find " + locator)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
		}
		return elements;
	}

	/**
	 * To check whether locator string is xpath or css
	 * 
	 * @param driver
	 * @param locator
	 * @return element
	 */
	public static WebElement checkLocator(WebDriver driver, String locator) {
		WebElement element = null;
		if (locator.startsWith("//")) {
			element = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Couldn't find " + locator)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} else {
			element = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Couldn't find " + locator)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		}
		return element;
	}

	/**
	 * To perform mouse hover on an element using javascript
	 * 
	 * @param driver
	 * @param element
	 */
	public static void moveToElementJS(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(MOUSE_HOVER_JS, element);
	}

	/**
	 * To get matching text element from List of web elements
	 * 
	 * @param elements
	 *            -
	 * @param contenttext
	 *            - text to match
	 * @return elementToBeReturned as WebElement
	 * @throws Exception
	 *             -
	 */
	public static WebElement getMachingTextElementFromList(List<WebElement> elements, String contenttext,
			String condition) throws Exception {
		WebElement elementToBeReturned = null;
		boolean found = false;
		if (elements.size() > 0) {
			for (WebElement element : elements) {
				if (condition.toLowerCase().equals("equals")
						&& element.getText().trim().replaceAll("\\s+", " ").equalsIgnoreCase(contenttext)) {
					elementToBeReturned = element;
					found = true;
					break;
				}

				if (condition.toLowerCase().equals("contains")
						&& element.getText().trim().replaceAll("\\s+", " ").contains(contenttext)) {
					elementToBeReturned = element;
					found = true;
					break;
				}
			}
			if (!found) {
				throw new Exception("Didn't find the correct text(" + contenttext + ")..! on the page");
			}
		} else {
			throw new Exception("Unable to find list element...!");
		}
		return elementToBeReturned;
	}

	/**
	 * Open a new tab on the browser
	 * 
	 * @param driver
	 */
	public static void openNewTab(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	/*
	 * public static void navigateToBack(WebDriver driver) {
	 * driver.navigate().back(); Utils.waitForPageLoad(driver); }
	 */

	/*
	 * public static boolean isRadioOrCheckBoxSelected(WebElement element){
	 * if(element.getAttribute("class").contains("active")){ return true; }
	 * 
	 * if(null != element.getAttribute("checked")){ return true; }
	 * 
	 * for(WebElement childElement : element.findElements(By.xpath(".//*"))){
	 * if(childElement.getAttribute("class").contains("active")){ return true; } }
	 * 
	 * return false; }
	 */

	public static void selectDropdownByIndex(WebElement element) {
		Select selectByIndex = new Select(element);
		selectByIndex.selectByIndex(0);

	}

	/**
	 * @author :
	 * @Description: verification on element present
	 * @param driver
	 *            : WebDriver Instances
	 * @param locator
	 *            : WebElement
	 * @return: boolean
	 */
	public static boolean isElementPresent(WebDriver driver, WebElement locator) {
		try {
			locator.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void actionClickByCoordinates(WebElement element, WebDriver driver, String elementDescription)
			throws Exception {
		if (!Utils.waitForElement(driver, element, 5))
			throw new Exception(elementDescription + " not found in page!!");

		try {
			Actions actions = new Actions(driver);
			actions.moveByOffset(element.getLocation().getX() + 5, element.getLocation().getY() + 5).click().build()
					.perform();
			;
		} catch (NoSuchElementException e) {
			throw new Exception(elementDescription + " not found in page!!");
		}
	}

	public static void mouseClickByJS(WebDriver driver, WebElement fromElement) {
		((JavascriptExecutor) driver).executeScript(
				"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",0,0); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
				fromElement, 0, 0);
	}

	public static void moveToElementAndClick(WebDriver driver, WebElement element, int x, int y) {
		String xOffset = Integer.toString(element.getLocation().x + x);
		String yOffset = Integer.toString(element.getLocation().y + y);
		((JavascriptExecutor) driver).executeScript(
				"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mousedown\",'0','0'); simulate(arguments[0],\"mouseup\",'0','0'); ",
				element, xOffset, yOffset);
	}

	public static void mouseClick(WebDriver driver, WebElement element) {
		String javaScript = "if( document.createEvent) { var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'click', true, false );" + "arguments[0].dispatchEvent(evObj);"
				+ "} else if( document.createEventObject ) {" + "arguments[0].fireEvent('onclick');" + "}";
		((JavascriptExecutor) driver).executeScript(javaScript, element);
	}

	public static void pressEscKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

}// BrowserActions
