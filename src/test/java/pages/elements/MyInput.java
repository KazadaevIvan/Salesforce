package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInput {
    public final static String inputLocatorWithSearch = "//*[contains(text(),'%s')]/parent::label/following-sibling::div/descendant::input";
    public final static String inputLocatorWithSearchOption = "//a[@role='option']/descendant::div[@title='%s']";
    public final static String inputLocator = "//*[contains(text(),'%s')]/parent::label/following-sibling::input";
    public final static String textAreaLocator = "//*[contains(text(),'%s')]/parent::label/following-sibling::textarea";

    WebDriver driver;

    public MyInput(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findInputWithSearch(String inputName) {
        return driver.findElement(By.xpath(String.format(inputLocatorWithSearch, inputName)));
    }

    public WebElement findInput(String inputName) {
        return driver.findElement(By.xpath(String.format(inputLocator, inputName)));
    }

    public WebElement findTextArea(String inputName) {
        return driver.findElement(By.xpath(String.format(textAreaLocator, inputName)));
    }

    public WebElement findInputWithSearchOption(String option) {
        return driver.findElement(By.xpath(String.format(inputLocatorWithSearchOption, option)));
    }
}