package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    public final static String textAreaLocator = "//*[contains(text(),'%s')]/parent::label/following-sibling::textarea";
    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textAreaLocator, label))).sendKeys(text);
    }
}