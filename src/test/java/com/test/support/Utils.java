package com.test.support;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		int maxwait = 10;
		boolean statusOfElement = false;
		WebDriverWait wait = new WebDriverWait(driver, maxwait);
		try {
			WebElement waitElement =	wait.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElement = true;
			}
		} catch (Exception e) {
			System.out.println("Element is not loaded" + e);
		}
		return statusOfElement;
	}

	public static boolean waitForElement(WebDriver driver, WebElement element, int maxwait) {
		boolean statusOfElement = false;
		WebDriverWait wait = new WebDriverWait(driver, maxwait);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));

			if (element.isDisplayed() && element.isEnabled()) {
				statusOfElement = true;
			}
		} catch (Exception e) {
			System.out.println("Element is not loaded" + e);
		}
		return statusOfElement;
	}
	
	public static boolean waitUntilElementDisapper(WebElement element,WebDriver driver) {
		boolean waituntil = new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated((By) element));
		return waituntil;

	}
	
	public static int getRandom(int min, int max) throws Exception {
		Random random = new Random();
		int rand;
		if (min == 0)
			rand = random.nextInt(max);
		else
			rand = ThreadLocalRandom.current().nextInt(min, max);

		return rand;
	}
	
    public static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
        }
    }
}
