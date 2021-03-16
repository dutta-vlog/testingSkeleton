package selenium.page;

import org.openqa.selenium.By;

import com.skeleton.config.testconfig.ScriptController;

public class PersonalPage extends MasterPage{

	public PersonalPage(ScriptController scriptController) {
		this.driver = scriptController.getWebDriver();
		this.webDriverUtility = scriptController.getWebDriverUtility();
	}

	public void clickOnCardMenu() {
		By xpath = null;
		if(isMobileExecution()) {
			expandSideMobileMenu();
			xpath = createXpathForMobileSideMenu("Cards");
		}else {
			xpath = createXpathForNavBarMenu("Cards");
		}
		webDriverUtility.clickElement(xpath);
	}

	

}
