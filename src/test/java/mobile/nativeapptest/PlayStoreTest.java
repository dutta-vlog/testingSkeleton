package mobile.nativeapptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.skeleton.config.testconfig.TestConfiguration;

import mobile.page.PlayStoreHomePage;



public class PlayStoreTest extends TestConfiguration {

	boolean flag;
	PlayStoreHomePage playStoeHomePage;

	@Test(priority = 0)
	public void verifyPlayStorePage() {
		playStoeHomePage = new PlayStoreHomePage(scriptController);
		//flag = playStoeHomePage.verifyPlayStoreLogo();
		//Assert.assertTrue(flag, "Playstore logo is not visible");

		flag = playStoeHomePage.verifySigninButton();
		Assert.assertTrue(flag, "Playstore sign in Button is not visible");
	}

	@Test(priority = 1, enabled=false)
	public void signInMessage() {
		String warningText = "This change isn't allowed by your administrator";
		playStoeHomePage.clickOnSigninButton();
		flag = playStoeHomePage.verifyText(warningText);
		playStoeHomePage.clickOnOkButton();
		Assert.assertTrue(flag, warningText + " Text is not visible");
	}

	@Test(priority = 3)
	public void verifyPlayProtect() {
		playStoeHomePage.clickOnPlayProtect();
		flag = playStoeHomePage.verifyPlayProtectScanningStatus();
		Assert.assertTrue(flag, "Play protect scanning is not on");
	}
}
