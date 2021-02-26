package seleniumUtil;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestConfiguration {

	public final static ScriptController scriptController = new ScriptController();	
	
	public ScriptController getScriptController() {
		return scriptController;
	}
	
	private void setUpTest() throws Exception {
		scriptController.launchDriver();
		scriptController.setWebDriverUtility(scriptController.getWebDriver());
		scriptController.setScreenshotInstance(scriptController.getWebDriver());
		scriptController.openURL(PropertyFile.getInstance().getValueOf("url"));
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
