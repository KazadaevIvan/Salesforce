package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    public final static String inputLocator = "//*[contains(text(),'%s')]/parent::label/following-sibling::input";
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }
}