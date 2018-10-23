package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.bjss.pages.CartPage;
import com.test.bjss.pages.HomePage;
import com.test.bjss.pages.LoginPage;
import com.test.bjss.pages.MyAccountDetails;
import com.test.bjss.pages.PLPPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition {
	WebDriver driver = null;
	HomePage homepage;
	LoginPage loginpage;
	PLPPage plppage;
	CartPage cartpage;
	MyAccountDetails myaccount;

	@When("^I navigate to home page$")
	public void I_navigate_to_home_page() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"F:\\eclipse_Java_with_plugin\\workspace\\cucumber-selenium\\src\\main\\resources\\driverexe\\chromedriver.exe");
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application");
		// chromeoptions.addArguments("start-maximized");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
		homepage.navigate_to_login();
	}

	@When("^Create an \"([^\"]*)\" user$")
	public void create_an_user(String arg1) throws Exception {
		loginpage = new LoginPage(driver);
		loginpage.createAccount(arg1);
		loginpage.myPersonalDetails();
	}

	@When("^Search a product$")
	public void Search_a_product() throws Exception {
		plppage = new PLPPage(driver);
		plppage = (PLPPage) homepage.search_product();

	}

	@When("^Add \"([^\"]*)\" product with \"([^\"]*)\" quantity to cart from quickview$")
	public void add_a_product_to_cart_from_quickview(int index, String qty) throws Exception {
		plppage = new PLPPage(driver);
		plppage.openQuickView(index);
		plppage.addTocartQuickview(qty);
	}

	@When("^I navigate to shoppingcart$")
	public void i_navigate_to_shoppingcart() throws Exception {
		homepage = new HomePage(driver);
		homepage.navigateto_shoppingcart();
	}

	@When("^I navigate to checkoutpage$")
	public void i_navigate_to_checkoutpage() throws Exception {
		cartpage = new CartPage(driver);
		cartpage.navigatetocheckout();
	}

	@When("^I Submit the order$")
	public void i_navigate_to_delivery_details_page() throws Exception {
		cartpage = new CartPage(driver);
		cartpage.navigatettodeliverydetails();
		cartpage.navigatetocarrier();
		cartpage.choosepayment();
		cartpage.navigatetosubmitorder();
	}

	@Then("^I should see the Order confirmation messsage$")
	public void i_should_see_the_order_confirmation_message() {
		cartpage = new CartPage(driver);
		cartpage.verifyorderconfirmation();
	}

	@When("^Login as \"([^\"]*)\" user$")
	public void login_as_user(String arg1) throws Exception {
		loginpage = new LoginPage(driver);
		loginpage.Login(arg1);
	}

	@When("^Add review comments in order details$")
	public void add_commments_in_order_details(String arg1) throws Exception {
		myaccount = new MyAccountDetails(driver);
		myaccount.openorderhistory();
		myaccount.openorderdetails();
		myaccount.addmessage("4");
	}

	@When("^I should see the review comments$")
	public void i_should_see_the_review_comments() {
		myaccount = new MyAccountDetails(driver);

		myaccount.verifyreviewcommennts();

	}

	@When("^I should see the product details in order details$")
	public void i_should_see_the_product_details_in_order_details() throws Exception {
		myaccount = new MyAccountDetails(driver);

		myaccount.verifyproductdetails();
	}

	@When("^I open the order details$")
	public void i_open_the_order_details() throws Exception {
		myaccount = new MyAccountDetails(driver);
		myaccount.openorderhistory();
		myaccount.openorderdetails();
	}

	@cucumber.api.java.After
	public void tearDown() {
		driver.quit();
	}
}
