package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public final static By USERNAME = By.id("username");
    public final static By PASSWORD = By.id("password");
    public final static By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get("https://login.salesforce.com/");
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            wait.elementToBeVisible(LOGIN_BUTTON);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    public HomePage login(String userName, String password) {
        driver.findElement(USERNAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
