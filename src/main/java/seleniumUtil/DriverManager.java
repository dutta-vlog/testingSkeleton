package seleniumUtil;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract WebDriver createDriver() throws Exception;

}