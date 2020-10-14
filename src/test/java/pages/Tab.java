package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.elements.MyInput;
import pages.elements.MySelect;

import java.util.List;

public class Tab {

    public final static String TAB = "//a/span[text()='%s']";
    public final static String IS_TAB_OPENED = "//li/span[contains(text(),'%s')]";
    public final static By CREATE_NEW = By.xpath("//a[@title='New']");
    public final static By FIRST_ACCOUNT_NAME = By.xpath("//th/span/a");
    int numberOfAccounts;
    int numberOfContacts;

    WebDriver driver;
    Waiter wait;
    MyInput input;
    MySelect select;

    public Tab(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver, 10);
        input = new MyInput(driver);
        select = new MySelect(driver);
    }

    public Tab openTab(String tabName) {
        try {
            wait.elementToBeClickable(By.xpath(String.format(TAB, tabName)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(TAB, tabName))));
        } catch (TimeoutException e) {
            Assert.fail("The tab has not been loaded. Tab not found by locator " + By.xpath(String.format(TAB, tabName)));
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(TAB, tabName))));
        return this;
    }

    public Tab isTabOpened(String tabName) {
        try {
            wait.elementToBeVisible(By.xpath(String.format(IS_TAB_OPENED, tabName)));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + By.xpath(String.format(IS_TAB_OPENED, tabName)));
        }
        numberOfAccounts = getList().size();
        return this;
    }

    public List<WebElement> getList() {
        return driver.findElements(FIRST_ACCOUNT_NAME);
    }

    public String getFirstName() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(FIRST_ACCOUNT_NAME, numberOfAccounts));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + FIRST_ACCOUNT_NAME +
                    " or number of contacts is " + numberOfContacts);
        }
        return getList().get(0).getText();
    }

    public void clickCreateNew() {
        try {
            wait.elementToBeClickable(CREATE_NEW);
            driver.findElement(CREATE_NEW).click();
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + CREATE_NEW);
        }
    }
}