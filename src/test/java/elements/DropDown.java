package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

public class DropDown {
    public final static String selectLocator = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInputSelect')]//a";
    public final static String optionLocator = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";
    WebDriver driver;
    String label;
    Waiter wait;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new Waiter(driver, 10);
    }

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(selectLocator, label))).click();
        wait.elementToBeVisible(By.xpath(String.format(optionLocator, option)));
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}