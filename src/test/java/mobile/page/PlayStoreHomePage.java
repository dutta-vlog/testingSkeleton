package mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.skeleton.config.mobiledriver.MobileDriverUtility;
import com.skeleton.config.testconfig.ScriptController;

public class PlayStoreHomePage {

	public WebDriver driver;
	public MobileDriverUtility mobileDriverUtility;
	
	private By logoXpath =By.xpath("//android.widget.ImageView[contains(@resource-id,'resource_name_obfuscated')][2]");
	private By signinButton = By.xpath("//android.widget.Button[contains(@text,'Sign in')]");
	private By options3Dots = By.xpath("//*[@content-desc='Options']");
	
	

	private By createXpathForText(String text) {
		return By.xpath("//android.widget.TextView[@text=\""+text+"\"]");
	}
	private By createXpathForButton(String text) {
		return By.xpath("//android.widget.Button[@text='"+text+"']");
	}
	
	
	public PlayStoreHomePage(ScriptController scriptController) {
		this.driver = scriptController.getWebDriver();
		this.mobileDriverUtility = scriptController.getMobileDriverUtility();
	}


	public boolean verifyPlayStoreLogo() {
		return  mobileDriverUtility.isDisplayed(logoXpath);
	}
	
	public boolean verifySigninButton() {
		return mobileDriverUtility.isDisplayed(signinButton);
	}
	
	public void clickOn3DotsOption() {
		mobileDriverUtility.clickElement(options3Dots);
	}

	public void clickOnSigninButton() {
		mobileDriverUtility.clickElement(signinButton);
	}

	public boolean verifyText(String warningText) {
		By xpathText = createXpathForText(warningText);
		return  mobileDriverUtility.isDisplayed(xpathText);
	}

	public void clickOnOkButton() {
		By okButton = createXpathForButton("OK");
		mobileDriverUtility.clickElement(okButton);
	}
	
	public void clickOnPlayProtect() {
		clickOn3DotsOption();
		By xpathText = createXpathForText("Play Protect");
		mobileDriverUtility.clickElement(xpathText);
	}
	
	public boolean verifyPlayProtectScanningStatus() {
		By xpathText = createXpathForText("No problems found");
		return  mobileDriverUtility.isDisplayed(xpathText);
	}

}
