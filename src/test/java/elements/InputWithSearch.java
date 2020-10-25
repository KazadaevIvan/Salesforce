package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

public class InputWithSearch {
    public final static String inputLocatorWithSearch = "//*[contains(text(),'%s')]/parent::label/following-sibling::div/descendant::input";
    public final static String optionLocator = "//a[@role='option']/descendant::div[@title='%s']";
    WebDriver driver;
    String label;
    Waiter wait;

    public InputWithSearch(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new Waiter(driver, 10);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocatorWithSearch, label))).sendKeys(text);
    }

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(inputLocatorWithSearch, label))).sendKeys(option);
        wait.elementToBeVisible(By.xpath(String.format(optionLocator, option)));
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}