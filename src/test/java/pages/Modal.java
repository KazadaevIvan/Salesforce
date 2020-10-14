package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.elements.MyInput;
import pages.elements.MySelect;

public class Modal {
    public final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    public final static String HEADER = "//h3/span[contains(text(),'%s')]";

    WebDriver driver;
    Waiter wait;
    MyInput input;
    MySelect select;

    public Modal(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver, 10);
        input = new MyInput(driver);
        select = new MySelect(driver);
    }

    public void submitForm() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public Modal isModalOpened(String modalName) {
        try {
            wait.elementToBeVisible(By.xpath(String.format(HEADER, modalName.substring(0, modalName.length() - 1))));
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Button not found by locator " + By.xpath(String.format(HEADER, modalName.substring(0, modalName.length() - 1))));
        }
        return this;
    }

    public Modal inputWithSearchSendKeys(String inputName, String sendKeys) {
        input.findInputWithSearch(inputName).sendKeys(sendKeys);
        return this;
    }

    public Modal inputSendKeys(String inputName, String sendKeys) {
        input.findInput(inputName).sendKeys(sendKeys);
        return this;
    }

    public Modal textAreaSendKeys(String textAreaName, String sendKeys) {
        input.findTextArea(textAreaName).sendKeys(sendKeys);
        return this;
    }

    public Modal selectOption(String selectName, String option) {
        select.findSelect(selectName).click();
        select.findOption(option).click();
        return this;
    }

    public Modal inputWithSearchChooseOption(String option) {
        input.findInputWithSearchOption(option).click();
        return this;
    }
}
