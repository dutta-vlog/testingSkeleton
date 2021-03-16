package com.skeleton.config.mobiledriver;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.skeleton.config.settings.ApplicationPlatformSettings.MobileType;
import com.skeleton.config.testconfig.DriverManager;
import com.skeleton.exceptions.CustomException;
import com.skeleton.util.PropertyFile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static java.lang.String.format;

public class MobileDriverManager extends DriverManager{

    private static final String PLATFORM_VERSION = PropertyFile.getInstance().getValueOf("platformVersion");
    private static final String DEVICE_NAME = PropertyFile.getInstance().getValueOf("deviceName");
    private static final String MOBILE_CLOUD_API_KEY = PropertyFile.getInstance().getValueOf("MobileCloudApiKey");
    private static final String PROJECT_NAME = "EPM-TSTF";
    private static final String APPIUM_HUB = "mobilecloud.epam.com";
    private static final String APP_PACKAGE= PropertyFile.getInstance().getValueOf("appPackage");
    private static final String APP_ACTIVITY= PropertyFile.getInstance().getValueOf("appActivity");
	
	@Override
	protected WebDriver createDriver() throws Exception {
		MobileType mobile=MobileType.valueOf(PropertyFile.getInstance().getValueOf("mobile"));
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		switch(mobile) {
		case AndroidEmulatorWEB:
			String mobileDriverPath = PropertyFile.getInstance().getValueOf("mobileChromeDriverPath");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.VERSION, PLATFORM_VERSION);
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			capabilities.setCapability("chromedriverExecutable", System.getProperty( "user.dir" )+mobileDriverPath);
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			break;
			
		case AndroidCloudWeb:
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
	        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	        capabilities.setCapability("chromedriverExecutable", System.getProperty( "user.dir" )+"\\src\\test\\resources\\Driver\\chromedriver.exe");
	        
	       driver = new AndroidDriver<MobileElement>(
	                new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, MOBILE_CLOUD_API_KEY, APPIUM_HUB)), capabilities);
	       break;
	       
		case AndroidCloudNative:
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	        capabilities.setCapability("autoGrantPermissions", true);
	        capabilities.setCapability(MobileCapabilityType.ENABLE_PERFORMANCE_LOGGING, true);
	        capabilities.setCapability("appPackage", APP_PACKAGE);
	        capabilities.setCapability("appActivity", APP_ACTIVITY);
	        capabilities.setCapability("noReset", true);
	        
			driver = new AndroidDriver<MobileElement>(
		                new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, MOBILE_CLOUD_API_KEY, APPIUM_HUB)), capabilities);
			break;
		
		case AndroidEmulatorNative:
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.VERSION, PLATFORM_VERSION);
			capabilities.setCapability("autoGrantPermissions", true);
	        capabilities.setCapability(MobileCapabilityType.ENABLE_PERFORMANCE_LOGGING, true);
	        capabilities.setCapability("noReset", true);
	        capabilities.setCapability("appPackage", APP_PACKAGE);
	        capabilities.setCapability("appActivity", APP_ACTIVITY);
	        
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			break;
			
		case IOSCloudWEB:
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
	        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
	        capabilities.setCapability("autoGrantPermissions", true);
	        
			driver = new IOSDriver<MobileElement>(
		                new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, MOBILE_CLOUD_API_KEY, APPIUM_HUB)), capabilities);
			break;
			
		default :
			throw new CustomException("Mobile Type : "+mobile+" does not supported");
		
		}
		return driver;
	}

}
