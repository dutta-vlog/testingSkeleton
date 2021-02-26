package selenium.page;

import java.util.List;
import org.openqa.selenium.By;
import seleniumUtil.ScriptController;

public class CardsPage extends MasterPage{

	private By cardCompareButton = By.xpath("//button[@id='cardCompareBtn']");

	public CardsPage(ScriptController scriptController) {
		this.driver = scriptController.getWebDriver();
		this.webDriverUtility = scriptController.getWebDriverUtility();
	}

	private By createXpathForCheckBoxCompareForCard(String cardName) {
		return By.xpath("//div[text()='"+cardName+"']//ancestor::div[@class='cardContainer']//label[@class='compare-label']");
	}
	private By createXpathForDataAtComparedPage(String cardName) {
		return By.xpath("//div[text()='"+cardName+"']/parent::div/following-sibling::div[@class='section-seperator']//div[@class='sub-header']");
	}

	
	
	public void clickOnCreditCard() {
		By xpath = createXpathForNavBarMenu("Credit Cards");
		webDriverUtility.clickElement(xpath);
	}

	public void clickCompareBoxForCard(String cardName) {
		By xpath = createXpathForCheckBoxCompareForCard(cardName);
		webDriverUtility.scrollIntoView(xpath);
		webDriverUtility.clickElementWithJavascript(xpath);
	}

	public void clickOnCompareButton() {
		webDriverUtility.clickElement(cardCompareButton );
	}

	public List<String> getAllComparedDataOfCard(String cardName) {
		By xpath = createXpathForDataAtComparedPage(cardName);
		List<String> allDataValues = webDriverUtility.getAllValues(xpath);
		return allDataValues;
	}

	
	
	
}
