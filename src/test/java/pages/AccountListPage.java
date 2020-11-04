package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AccountListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static String URL = "https://wow4.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static By ALL_ACCOUNTS = By.xpath("//th[@scope='row']");
    public final static String ACCOUNT = "//*[contains(@title,'%s')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    public NewAccountModal clickNew() {
        wait.elementToBeClickable(NEW_BUTTON);
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }

    public int getNumberOfAccounts() {
        wait.elementToBeVisible(ALL_ACCOUNTS);
        List<WebElement> list = driver.findElements(ALL_ACCOUNTS);
        return list.size();
    }

    public AccountDetailsPage openAccount(String name) {
        wait.elementToBeClickable(By.xpath(String.format(ACCOUNT, name)));
        driver.findElement(By.xpath(String.format(ACCOUNT, name))).click();
        return new AccountDetailsPage(driver);
    }

    public AccountListPage numberOfAccountsAfterDeletionShouldBeLessThan(int numberOfAccounts) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.numberOfElementsToBeLessThan(ALL_ACCOUNTS, numberOfAccounts));
        return this;
    }
}