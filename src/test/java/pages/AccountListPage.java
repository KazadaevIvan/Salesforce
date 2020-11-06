package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccountListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static String URL = "https://wow4.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static By ALL_ACCOUNTS = By.xpath("//th[@scope='row']");
    public final static String ACCOUNT = "//*[contains(@title,'%s')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Account List page is opened")
    @Override
    public AccountListPage isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    @Step("Open Account List page")
    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Click New button")
    public NewAccountModal clickNew() {
        wait.elementToBeClickable(NEW_BUTTON);
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }

    @Step("Get number of accounts")
    public int getNumberOfAccounts() {
        wait.elementToBeVisible(ALL_ACCOUNTS);
        List<WebElement> list = driver.findElements(ALL_ACCOUNTS);
        return list.size();
    }

    @Step("Open account '{name}'")
    public AccountDetailsPage openAccount(String name) {
        wait.elementToBeClickable(By.xpath(String.format(ACCOUNT, name)));
        driver.findElement(By.xpath(String.format(ACCOUNT, name))).click();
        return new AccountDetailsPage(driver);
    }

    @Step("Verify account is deleted. Number of accounts should be less than '{numberOfAccounts}'")
    public AccountListPage verifyNumberOfAccountsAfterDeletion(int numberOfAccounts) {
        assertEquals(getNumberOfAccounts(), (numberOfAccounts-1));
        return this;
    }
}