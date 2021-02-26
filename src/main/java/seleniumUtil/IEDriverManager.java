package seleniumUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager {


	    public WebDriver createDriver() {

			String path = PropertyFile.getInstance().getValueOf("ieDriverPath");
		  	System.setProperty("webdriver.ie.driver",System.getProperty( "user.dir" )+path);					
	        return new InternetExplorerDriver();
	    }


}
