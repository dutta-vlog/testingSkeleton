package com.skeleton.config.testconfig;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.skeleton.config.settings.ApplicationPlatformSettings.MobileType;
import com.skeleton.config.settings.ApplicationPlatformSettings.PlatformType;
import com.skeleton.util.PropertyFile;


public class TestConfiguration {

	public static final ScriptController scriptController = new ScriptController();	
	public static final MobileType MOBILE_TYPE=MobileType.valueOf(PropertyFile.getInstance().getValueOf("mobile"));
	public static final PlatformType PLATFORM=PlatformType.valueOf(PropertyFile.getInstance().getValueOf("platform"));
	
	public ScriptController getScriptController() {
		return scriptController;
	}
	
	private void setUpTest() throws Exception {
		scriptController.launchDriver();
		scriptController.setScreenshotInstance();
		initiateExecution();
	}
	
	private void initiateExecution() {
		if(isMobileAppExecution())
			initiateMobileAPPExecution();
		else
			initiateWebExecution();
	}

	private boolean isMobileAppExecution() {
		if(PLATFORM==PlatformType.MOBILE && (MOBILE_TYPE ==MobileType.AndroidEmulatorNative|| MOBILE_TYPE ==MobileType.AndroidCloudNative))
			return true	;
		else
			return false;
	}

	private void initiateWebExecution() {
		scriptController.setWebDriverUtility();
		scriptController.openURL(PropertyFile.getInstance().getValueOf("url"));	
	}

	private void initiateMobileAPPExecution() {
		scriptController.setMobileDriverUtility();
	}

	@BeforeTest
	public void start() throws Exception {
		setUpTest();
	}

	@AfterTest
	public void tearDown() {
		scriptController.exit();
	}
	
	
	
}
