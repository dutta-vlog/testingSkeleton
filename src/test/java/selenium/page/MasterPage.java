package selenium.page;

import org.openqa.selenium.By;

import seleniumUtil.Utility;

public class MasterPage extends Utility{


	public By createXpathForText(String text) {
		return By.xpath("//*[text()='"+text+"']");
	}
	
	public By createXpathForPartialText(String partialText){
		return By.xpath("//*[contains(text(),'"+partialText+"')]");
	}
	
	public By createXpathForNavBarMenu(String menuText) {
		return By.xpath("(//div[contains(@class,'navbar')]//li/a[text()='"+menuText+"'])[1]");
	}
	
	public By createXpathForMobileSideMenu(String menuText){
		return By.xpath("//div[contains(@class,'mobile-slideleft')]//li/a[text()='"+menuText+"']");
	}
	
	
}
