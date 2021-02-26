package seleniumUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import seleniumUtil.ApplicationPlatformSettings.*;

public class Utility {

	public int globalWait = Integer.parseInt(PropertyFile.getInstance().getValueOf("globalWait"));
	public BrowserType browser=BrowserType.valueOf(PropertyFile.getInstance().getValueOf("browser"));
	public PlatformType platform=PlatformType.valueOf(PropertyFile.getInstance().getValueOf("platform"));
	public WebDriver driver;
	public WebDriverUtility webDriverUtility;
	
	
	public boolean isMobileExecution() {
		if(browser == BrowserType.EMULATOR || platform==PlatformType.MOBILE)
			return true	;
		else
			return false;
	}

	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,1000)");
	}
	
}
