package seleniumUtil;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public int globalWait = Integer.parseInt(PropertyFile.getInstance().getValueOf("globalWait"));
	private WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	// Click on By element
	public boolean clickElement(By identifier) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globalWait).until(ExpectedConditions.elementToBeClickable(identifier));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	// enter text at By element
	public String enterTextAt(By identifier, String text) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return text;
	}

	// verify if the element is displaying - wait for the defined time
	public boolean isDisplayed(By identifier, int wait) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, wait).until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// verify if the element is displaying - wait for the standard time
	public boolean isDisplayed(By identifier) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isDisplayed();
		} catch (Exception e) {
			System.out.println(identifier+" element is not displayed, waited for "+globalWait + " Seconds");
		}
		return flag;
	}

	// verify if the element is Enabled - wait for the defined time
	public boolean isEnabled(By identifier) {
		WebElement element = null;
		boolean flag = false;
		try {
			element = new WebDriverWait(driver, globalWait)
					.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			flag = element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// verify if the element is Selected - wait for the defined time
	public boolean isSelected(By identifier) {
		boolean flag = false;
		try {
			flag = new WebDriverWait(driver, globalWait).until(ExpectedConditions.elementToBeSelected(identifier));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	// switch To frame
	public void switchToFrame(By identifier) {
		try {
			new WebDriverWait(driver, globalWait).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(identifier));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// switch To frame - by name
	public void switchToFrame(String frameName) {
		try {
			new WebDriverWait(driver, globalWait).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Click on  element
		public boolean clickElementWithJavascript(By identifier) {
			try {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				isDisplayed(identifier);
				js.executeScript("arguments[0].click()", driver.findElement(identifier));
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return true;
		}
		
		public boolean scrollIntoView(By identifier) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				isDisplayed(identifier);
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(identifier));
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return true;
		}

		public List<String> getAllValues(By identifier) {
			List<WebElement> elements = null;
			try {
				new WebDriverWait(driver, globalWait)
						.until(ExpectedConditions.visibilityOfElementLocated(identifier));
				elements = driver.findElements(identifier);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<String> values = getAllValuesOf(elements);
			return values;
		}

		private List<String> getAllValuesOf(List<WebElement> elements) {
			List<String> values = new ArrayList<String> ();
			for(WebElement element : elements) {
				String value = null;
				try {
					value = element.getText().trim();
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(value != null || value !="")
					values.add(value);
			}
			return values;
		}

}
