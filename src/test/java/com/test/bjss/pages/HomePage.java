package com.test.bjss.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.support.BrowserActions;
import com.test.support.Utils;

public class HomePage {

	private WebDriver driver;
	LoginPage loginpage = new LoginPage(driver);

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		Utils.waitForPageLoaded(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input#email")
	WebElement txtemailid_login;
	@FindBy(css = "a.login")
	WebElement login;
	@FindBy(css = "a.logout")
	WebElement logout;
	@FindBy(css = "#search_query_top")
	WebElement searchtextbox;
	@FindBy(css = "button[name='submit_search']")
	WebElement btnsearch;
	@FindBy(css = "ul[class ~='product_list grid row']")
	WebElement searchresults;
	@FindBy(css = "div[class='shopping_cart'] a")
	WebElement shoppingbag;
	@FindBy(css = ".account")
	WebElement lnkmyaccount;
	@FindBy(css = "a[title='Orders']")
	WebElement myorderhistory;

	public void navigate_to_login() throws Exception {
		BrowserActions.clickOnElement(login, driver, "Sign in link");
		Utils.waitForElement(driver,txtemailid_login);
	}

	public Object search_product() throws Exception {
		BrowserActions.typeOnTextField(searchtextbox, "Dresses", driver, "Search box");
		BrowserActions.clickOnElement(btnsearch, driver, "Search Button");
		return Utils.waitForElement(driver, searchresults);
	}

	public void navigateto_shoppingcart() throws Exception {
		BrowserActions.clickOnElement(shoppingbag, driver, "Cart icon");

	}

	public void myaccountpage() throws Exception {
		BrowserActions.clickOnElement(lnkmyaccount, driver, "My Account");
		Utils.waitForElement(driver, myorderhistory);
	}

	public void signout() throws Exception {
		BrowserActions.clickOnElement(logout, driver, "Logout");
		Utils.waitForElement(driver, login);
	}
}
