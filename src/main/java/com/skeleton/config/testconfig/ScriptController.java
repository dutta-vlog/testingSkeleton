package com.skeleton.config.testconfig;

import org.openqa.selenium.WebDriver;

import com.skeleton.config.mobiledriver.MobileDriverUtility;
import com.skeleton.config.seleniumdriver.WebDriverUtility;
import com.skeleton.reports.Log4j;
import com.skeleton.reports.Reports;
import com.skeleton.reports.Screenshot;

public class ScriptController {

	private static DriverManager driverManager;
	private static WebDriver driver;
	private static WebDriverUtility webDriverUtility;
	private static Screenshot screenshotInstace;
	private static final Reports report = new Reports();
	private static final Log4j log4j = new Log4j();
	private static MobileDriverUtility mobileDriverUtility;

	public void launchDriver() throws Exception {
		driverManager = DriverFactory.createDriverManager();
		driver = driverManager.createDriver();
	}
	
	public void openURL(String url) {
		driver.get(url);
	}

	public WebDriverUtility getWebDriverUtility() {
		return webDriverUtility;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public Screenshot getScreenshotInstance() {
		return screenshotInstace;
	}
	
	public void setWebDriverUtility() {
		webDriverUtility = new WebDriverUtility(driver);
	}
	
	public void setScreenshotInstance() {
		screenshotInstace=new Screenshot(driver);;
	}
	
	public void setMobileDriverUtility() {
		mobileDriverUtility = new MobileDriverUtility(driver);
	}
	
	public MobileDriverUtility getMobileDriverUtility() {
		return mobileDriverUtility;
	}
	
	public Reports getReport() {
		return report;
	}
	
	public Log4j getLog4j() {
		return log4j;
	}

	public void exit() {
		driver.quit();
		driver=null;
	}

}
