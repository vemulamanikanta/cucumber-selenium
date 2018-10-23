package com.test.bjss.pages;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.support.BrowserActions;
import com.test.support.Utils;

public class PLPPage {

	private WebDriver driver;
	public final LinkedHashMap<String, String> productdetails = new LinkedHashMap<String, String>();

	public PLPPage(WebDriver driver) {
		this.driver = driver;
		Utils.waitForPageLoaded(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#search_query_top")
	WebElement searchtextbox;
	@FindBy(css = "button[name='submit_search']")
	WebElement btnsearch;
	@FindBy(css = "ul[class~='product_list'] li[class~='ajax_block_product']")
	WebElement searchresults;
	@FindBy(css = "a.quick-view")
	WebElement btnquickview;
	// ---------------iFrame locators----------------------
	@FindBy(css = ".fancybox-iframe")
	WebElement iframe;
	@FindBy(css = "iframe[id~='fancybox-frames']")
	WebElement iframes;

	@FindBy(css = "div[class='pb-center-column col-xs-12 col-sm-4'] h1")
	WebElement q_productname;
	@FindBy(css = "span[itemprop='sku']")
	WebElement q_model;
	@FindBy(css = "#color_to_pick_list")
	WebElement q_color;
	@FindBy(css = "#color_to_pick_list li[class='selected'] a")
	WebElement q_color_selected;
	@FindBy(css = "#group_1")
	WebElement q_size;
	@FindBy(css = "#uniform-group_1 option[selected='selected']")
	WebElement q_selected_size;
	@FindBy(css = "button.exclusive")
	WebElement q_addtocart;
	@FindBy(css = "#quantity_wanted")
	WebElement q_quantity;
	@FindBy(css = "a[title='Close']")
	WebElement close;

	@FindBy(css = "div[class='button-container'] span[title='Continue shopping']")
	WebElement continue_shopping;

	public int countNumberofProducts() {
		int noofproducts = searchresults.findElements(By.xpath("//div[class='product-container']")).size();
		return noofproducts;
	}

	public void openQuickView(int index) throws Exception {

		List<WebElement> lstofproduct = searchresults
				.findElements(By.xpath("//div[@class='product-container']/div[@class='left-block']"));
		WebElement element = lstofproduct.get(index).findElement(By.cssSelector("a.product_img_link"));
		boolean status = element.isDisplayed();
		System.out.println(status);
		BrowserActions.mouseHover(driver, element);

		WebElement btnquick = lstofproduct.get(index).findElement(By.xpath("//div[@class='product-container']"));

		BrowserActions.clickOnElement(btnquick, driver, "select any product");
		WebElement btnquickview = lstofproduct.get(index).findElement(By.cssSelector("a.quick-view"));

		BrowserActions.javascriptClick(btnquickview, driver, "quickview");
		Utils.waitForElement(driver, iframe);
	}

	public void addTocartQuickview(String size) throws Exception {
		int noframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of iframes " + noframe);
		try {
			driver.switchTo().frame(iframe);
		} catch (Exception e) {
			driver.switchTo().activeElement();
		}
		BrowserActions.selectFromComboBox(q_size, size, driver, "Quick view Size");
		productDetails();
		try {
			BrowserActions.clickOnElement(q_addtocart, driver, "add to cart");

		} catch (Exception e) {
			BrowserActions.javascriptClick(q_addtocart, driver, "add to cart");

		}
		Thread.sleep(3000);
		// BrowserActions.clickOnElement(close, driver, "Quick view close button");
		driver.switchTo().defaultContent();
		Utils.waitForElement(driver, continue_shopping);
		BrowserActions.clickOnElement(continue_shopping, driver, "Continue shopping");

	}

	public LinkedList<LinkedHashMap<String, String>> productDetails() {
		LinkedList<LinkedHashMap<String, String>> productDetails = new LinkedList<LinkedHashMap<String, String>>();

		LinkedHashMap<String, String> productinfo = new LinkedHashMap<String, String>();

		productinfo.put("productname", (q_productname.getText().trim()));
		productinfo.put("SKU", (q_model.getText().trim()));
		productinfo.put("Color", (q_color_selected.getText().trim()));
		productinfo.put("size", (q_selected_size.getText().trim()));
		productinfo.put("quantity", (q_quantity.getAttribute("value")).trim());

		productDetails.add(productinfo);
		System.out.println(productDetails);
		return productDetails;

	}
}
