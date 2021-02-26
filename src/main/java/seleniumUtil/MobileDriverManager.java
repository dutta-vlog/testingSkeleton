package seleniumUtil;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import seleniumUtil.ApplicationPlatformSettings.MobileType;

public class MobileDriverManager extends DriverManager{

	@Override
	protected WebDriver createDriver() throws Exception {
		MobileType mobile=MobileType.valueOf(PropertyFile.getInstance().getValueOf("mobile"));
		AndroidDriver<MobileElement> driver = null;
		
		switch(mobile) {
		case AndroidWEB:
			DesiredCapabilities capabilities = new DesiredCapabilities();
			String driverPath = PropertyFile.getInstance().getValueOf("mobileChromeDriverPath");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.VERSION, "10.0");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			capabilities.setCapability("chromedriverExecutable", System.getProperty( "user.dir" )+driverPath);
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			break;
			
		default :
			throw new CustomException("Mobile Type : "+mobile+" does not supported");
		
		}
		return driver;
	}

}
