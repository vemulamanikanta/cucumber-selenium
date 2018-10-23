package com.test.bjss.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.support.BrowserActions;
import com.test.support.Utils;

public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		Utils.waitForPageLoaded(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[name='processCheckout']")
	WebElement btnprocesscheckout;
	@FindBy(css = "button[name='processAddress']")
	WebElement btnprocessaddress;
	@FindBy(css = "button[name='processCarrier']")
	WebElement btnprocescarrier;
	@FindBy(css = "input[name='cgv']")
	WebElement checkboxterms;
	@FindBy(css = ".bankwire")
	WebElement btnchoosepayment;
	@FindBy(css = "button[type='submit']")
	WebElement submitorder;
	@FindBy(css = ".cheque-indent")
	WebElement successmessage;

	public void navigatetocheckout() throws Exception {
		BrowserActions.scrollToView(btnprocesscheckout, driver);
		BrowserActions.clickOnElement(btnprocesscheckout, driver, "Procescheckout");
		Utils.waitForElement(driver, btnprocessaddress);
	}

	public void navigatettodeliverydetails() throws Exception {
		BrowserActions.scrollToView(btnprocessaddress, driver);
		BrowserActions.clickOnElement(btnprocessaddress, driver, "Processaddress");
		Utils.waitForElement(driver, btnprocescarrier);
	}

	public void navigatetocarrier() throws Exception {
		BrowserActions.scrollToView(checkboxterms, driver);
		BrowserActions.selectRadioOrCheckbox(checkboxterms, "Yes");
		BrowserActions.clickOnElement(btnprocescarrier, driver, "Process carrier");
		Utils.waitForElement(driver, btnchoosepayment);

	}

	public void navigatetosubmitorder() throws Exception {
		BrowserActions.scrollToView(submitorder, driver);
		BrowserActions.clickOnElement(submitorder, driver, "Submit order");
		Utils.waitForElement(driver, successmessage);

	}

	public void choosepayment() throws Exception {
		BrowserActions.scrollToView(btnchoosepayment, driver);
		BrowserActions.clickOnElement(btnchoosepayment, driver, "Choose payment");
		Utils.waitForElement(driver, submitorder);

	}

	public void verifyorderconfirmation() {
		String confirmationmesage = successmessage.getText();
		Assert.assertEquals("Your order on My Store is complete.", confirmationmesage);
	}
}
