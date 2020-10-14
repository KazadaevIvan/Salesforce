package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    public final static String TAB = "//a/span[text()='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isPageOpened() {
        try {
            wait.elementToBeVisible(By.xpath(String.format(TAB, "Home")));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + By.xpath(String.format(TAB, "Home")));
        }
        return this;
    }

}