package com.skeleton.config.testconfig;

import com.skeleton.config.mobiledriver.MobileDriverManager;
import com.skeleton.config.seleniumdriver.WebDriverManager;
import com.skeleton.config.settings.ApplicationPlatformSettings.PlatformType;
import com.skeleton.exceptions.CustomException;
import com.skeleton.util.PropertyFile;

public class DriverFactory {
    
    private DriverFactory() {
    }

	public static DriverManager createDriverManager() throws CustomException {

		PlatformType platform=PlatformType.valueOf(PropertyFile.getInstance().getValueOf("platform"));
		DriverManager driverManager ;

		switch(platform) {
		case WEB:
			driverManager = new WebDriverManager();
			break;
		case MOBILE:
			driverManager = new MobileDriverManager();
			break;
		default:
			throw new CustomException("Choose the platform as WEB of MOBILE");
		}
		return driverManager;
	}
}
