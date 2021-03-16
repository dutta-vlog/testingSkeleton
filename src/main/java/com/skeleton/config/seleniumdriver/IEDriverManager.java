package com.skeleton.config.seleniumdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.skeleton.util.PropertyFile;

public class IEDriverManager {


	    public WebDriver createDriver() {

			String path = PropertyFile.getInstance().getValueOf("ieDriverPath");
		  	System.setProperty("webdriver.ie.driver",System.getProperty( "user.dir" )+path);					
	        return new InternetExplorerDriver();
	    }


}
