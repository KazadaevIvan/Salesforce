package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MySelect {
    public final static String selectLocator = "//*[contains(text(),'%s')]/parent::span/following-sibling::div/descendant::a";
    public final static String optionLocator = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";
    WebDriver driver;

    public MySelect(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findSelect(String selectName) {
        return driver.findElement(By.xpath(String.format(selectLocator, selectName)));
    }

    public WebElement findOption(String optionName) {
        return driver.findElement(By.xpath(String.format(optionLocator, optionName)));
    }
}
