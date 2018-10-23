package com.test.bjss.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.support.BrowserActions;
import com.test.support.Utils;



public class MyAccountDetails {
	private WebDriver driver;

	public MyAccountDetails(WebDriver driver) {
		this.driver = driver;
		Utils.waitForPageLoaded(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "select[name='id_product']")
	WebElement productlist;
	@FindBy(css = "textarea[name='msgText']")
	WebElement messagetext;
	@FindBy(css = "button[name='submitMessage']")
	WebElement submitmessage;
	@FindBy(xpath = "//div[@class='table_block'][2]/table/tbody/tr/td[2]")
	WebElement msgsavedmessage;
	@FindBy(css = "a[title='Orders']")
	WebElement myorderhistory;
	@FindBy(xpath = "//*[@id='order-list']/tbody/tr/td[7]/a[1]/span/i")
	WebElement history;

	@FindBy(xpath = "//*[@id='order-detail-content']/table/tbody/tr/td[2]")
	WebElement productdetails;

	public void openorderhistory() throws Exception {
		BrowserActions.clickOnElement(myorderhistory, driver, "Order History");
	}

	public void openorderdetails() throws Exception {
		BrowserActions.javascriptClick(history, driver, "Order History");
	}

	public void addmessage(String productindex) throws Exception {
		BrowserActions.scrollToViewElement(productlist, driver);
		BrowserActions.selectFromComboBox(productlist, "4", driver, "Product");
		BrowserActions.typeOnTextField(messagetext, "Test Message", driver, "Message area");
		BrowserActions.clickOnElement(submitmessage, driver, "Submit message");
		Utils.waitForElement(driver, msgsavedmessage);
	}

	public void verifyreviewcommennts() {
		String actual = msgsavedmessage.getText().trim();
		Assert.assertEquals("Test Message", actual);
	}

	public void verifyproductdetails() throws InterruptedException {
		String expectedcolor = "Red";
		Thread.sleep(2000);
		BrowserActions.scrollToView(productdetails, driver);
		String actualcolor = productdetails.getText().trim();
		System.out.println("color"+actualcolor);
		Assert.assertEquals(expectedcolor, actualcolor);
		
	}
}
