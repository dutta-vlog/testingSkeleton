package seleniumUtil;

import seleniumUtil.ApplicationPlatformSettings.PlatformType;

public class DriverFactory {

	public static DriverManager driverManager = null;
	
	public static DriverManager createDriverManager() throws CustomException {

		PlatformType platform=PlatformType.valueOf(PropertyFile.getInstance().getValueOf("platform"));

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
