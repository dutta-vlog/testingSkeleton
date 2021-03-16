package com.skeleton.config.mobiledriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skeleton.util.PropertyFile;

public class MobileDriverUtility {

	public int globalWait = Integer.parseInt(PropertyFile.getInstance().getValueOf("globalWait"));
	private WebDriver driver;

	public MobileDriverUtility(WebDriver driver) {
		this.driver = driver;
	}

	// Click on By element
	public boolean clickElement(By identifier) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globalWait).until(ExpectedConditions.elementToBeClickable(identifier));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	// enter text at By element
	public String enterTextAt(By identifier, String text) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return text;
	}

	// verify if the element is displaying - wait for the defined time
	public boolean isDisplayed(By identifier, int wait) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, wait).until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// verify if the element is displaying - wait for the standard time
	public boolean isDisplayed(By identifier) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isDisplayed();
		} catch (Exception e) {
			System.out.println(identifier + " element is not displayed, waited for " + globalWait + " Seconds");
		}
		return flag;
	}

	// verify if the element is Enabled - wait for the defined time
	public boolean isEnabled(By identifier) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
