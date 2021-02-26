package seleniumUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {

	    public WebDriver createDriver() {
			String path = PropertyFile.getInstance().getValueOf("chromeDriverPath");
		  	System.setProperty("webdriver.chrome.driver",System.getProperty( "user.dir" )+path);					
		    ChromeOptions options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        return new ChromeDriver(options);
	    }

}
