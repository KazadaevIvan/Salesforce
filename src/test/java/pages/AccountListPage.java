package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[contains(text(),'Sort')]/following-sibling::" +
            "span[contains(text(),'Account Name')]");
    String URL = "https://wow4.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    By newButton = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Table not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    public NewAccountModal clickNew() {
        wait.elementToBeClickable(newButton);
        driver.findElement(newButton).click();
        return new NewAccountModal(driver);
    }
}