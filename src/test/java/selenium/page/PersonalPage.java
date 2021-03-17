package selenium.page;

import org.openqa.selenium.By;

public class PersonalPage extends MasterPage{

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
