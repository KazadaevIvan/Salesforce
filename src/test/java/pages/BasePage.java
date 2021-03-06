package pages;

import org.openqa.selenium.WebDriver;
import utils.Waiter;

abstract public class BasePage {
    WebDriver driver;
    Waiter wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver, 10);
    }

    abstract public BasePage isPageOpened();
}