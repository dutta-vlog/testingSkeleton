package seleniumUtil;

import org.openqa.selenium.WebDriver;

public class ScriptController {

	private static DriverManager driverManager;
	private static WebDriver driver;
	private static WebDriverUtility webDriverUtility;
	private static Screenshot screenshotInstace;
	private static final Reports report = new Reports();
	private static final Log4j log4j = new Log4j();

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
	
	public void setWebDriverUtility(WebDriver webDriver) {
		webDriverUtility = new WebDriverUtility(webDriver);
	}
	
	public void setScreenshotInstance(WebDriver webDriver) {
		screenshotInstace=new Screenshot(webDriver);;
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
