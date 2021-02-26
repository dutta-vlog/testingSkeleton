package seleniumUtil;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import seleniumUtil.ApplicationPlatformSettings.BrowserType;

public class WebDriverManager extends DriverManager{

	@Override
	protected WebDriver createDriver() throws Exception {

		BrowserType browser=BrowserType.valueOf(PropertyFile.getInstance().getValueOf("browser"));
		String driverPath;
		WebDriver driver = null;
		
		switch(browser) {
		case CHROME:
			driverPath = PropertyFile.getInstance().getValueOf("chromeDriverPath");
		  	System.setProperty("webdriver.chrome.driver",System.getProperty( "user.dir" )+driverPath);					
		    ChromeOptions options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        driver= new ChromeDriver(options);
			break;
		
		case INTERNETEXPLORER:
			driverPath = PropertyFile.getInstance().getValueOf("ieDriverPath");
		  	System.setProperty("webdriver.ie.driver",System.getProperty( "user.dir" )+driverPath);					
		  	driver = new InternetExplorerDriver();
			break;
		
		case FIREFOX:
			throw new CustomException("BroserType : FIREFOX does not support");
		case SAFARI:
			throw new CustomException("BroserType : SAFARI does not support");
			
		case EMULATOR:
			Map<String, String> mobileEmulation = new HashMap<>();
			driverPath = PropertyFile.getInstance().getValueOf("chromeDriverPath");
		  	System.setProperty("webdriver.chrome.driver",System.getProperty( "user.dir" )+driverPath);		
			mobileEmulation.put("deviceName", "Pixel 2");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			break;
			
		default :
			throw new CustomException("BroserType didn't match");
		}
		
		return driver;
	}

}
