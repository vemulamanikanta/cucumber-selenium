package com.test.bjss.pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.support.BrowserActions;
import com.test.support.Utils;

public class LoginPage {
	private WebDriver driver;
	public final LinkedHashMap<String, String> accountDetails = new LinkedHashMap<String, String>();

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// -----------------------------------------------------------//
	// --------------Eelement for Create account page-------------//
	// -----------------------------------------------------------//
	@FindBy(css = "input#email_create")
	WebElement txtemailid_create;
	@FindBy(css = "#SubmitCreate")
	WebElement btncreate_account;
	// -----------------------------------------------------------//
	// -------------- Element for login page---------------//
	// -----------------------------------------------------------//
	@FindBy(css = "input#email")
	WebElement txtemailid_login;
	@FindBy(css = "input#passwd")
	WebElement txtpassword_login;
	@FindBy(css = "button#SubmitLogin")
	WebElement btnlogin;
	@FindBy(css = "input#id_gender1")
	WebElement radiogenderMr;
	@FindBy(css = "input#id_gender2")
	WebElement radiogenderMrs;
	@FindBy(css = "input#customer_firstname")
	WebElement txtcustomerfirstname;
	@FindBy(css = "input#customer_lastname")
	WebElement txtcustomerlastname;
	@FindBy(css = "input#firstname")
	WebElement txtfirstname;
	@FindBy(css = "input#lastname")
	WebElement txtlastname;
	@FindBy(css = "input#address1")
	WebElement txtaddress1;
	@FindBy(css = "input#city")
	WebElement txtcity;
	@FindBy(css = "input#postcode")
	WebElement txtzipcode;
	@FindBy(css = "select#id_state")
	WebElement lststate;
	@FindBy(css = "input#phone_mobile")
	WebElement txtPhonenumber;
	@FindBy(css = "input#alias")
	WebElement txtreference_name;
	@FindBy(css = "button#submitAccount")
	WebElement btnsubmitAccount;
	@FindBy(css = "a.logout")
	WebElement lnklogout;

	// -----------------------------------------------------------//
	// --------------Reusable method for login page---------------//
	// -----------------------------------------------------------//

	public String emailid() throws Exception {
		final int rannum = Utils.getRandom(100, 999);
		final String prefix = "bjsstest" + Integer.toString(rannum);
		final String emailid = prefix + "@bjss.com";
		System.out.println(emailid);
		return emailid;
	}

	public void Login(String emailid) throws Exception {
		BrowserActions.typeOnTextField(txtemailid_login, emailid, driver, "Emailid");
		BrowserActions.typeOnTextField(txtpassword_login, "BJSSTest", driver, "Login password");
		BrowserActions.clickOnElement(btnlogin, driver, "Login button");
		Utils.waitForElement(driver, radiogenderMr);
	}

	public void createAccount(String email) throws Exception {
		String emailid;
		if (email.isEmpty()) {
			emailid = emailid();
		} else {
			emailid = email;
		}
		BrowserActions.typeOnTextField(txtemailid_create, emailid, driver, "Email ID");
		// BrowserActions.scrollToView(btncreate_account, driver);
		BrowserActions.clickOnElement(btncreate_account, driver, "btncreate_account");
	}

	public void myPersonalDetails() throws Exception {

		BrowserActions.selectRadioOrCheckbox(radiogenderMr, "Yes");
		BrowserActions.typeOnTextField(txtcustomerfirstname, "QAFirstName", driver, "First Name");
		BrowserActions.typeOnTextField(txtcustomerlastname, "QALastName", driver, "Last Name");
		BrowserActions.typeOnTextField(txtpassword_login, "BJSSTest", driver, "Password");
		BrowserActions.typeOnTextField(txtaddress1, "1746 Bay St", driver, "Address 1");
		BrowserActions.typeOnTextField(txtcity, "San Francsico", driver, "City");
		Thread.sleep(5000);
		BrowserActions.selectFromComboBox(lststate, "5", driver, "state");
		BrowserActions.typeOnTextField(txtzipcode, "94123", driver, "Zipcode");
		BrowserActions.typeOnTextField(txtPhonenumber, "26027055240", driver, "Phone Number");
		BrowserActions.typeOnTextField(txtreference_name, "Home_address", driver, "Address alias");
		BrowserActions.clickOnElement(btnsubmitAccount, driver, "Register");

	}
}
