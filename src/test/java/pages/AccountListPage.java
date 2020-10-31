package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[contains(text(),'Sort')]/following-sibling::" +
            "span[contains(text(),'Account Name')]");
    public final static String URL = "https://wow4.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            wait.elementToBeVisible(NEW_BUTTON);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + NEW_BUTTON);
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
}