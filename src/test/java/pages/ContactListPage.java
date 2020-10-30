package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[contains(text(),'Sort')]/following-sibling::" +
            "span[contains(text(),'Account Name')]");
    String URL = "https://wow4.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    By newButton = By.cssSelector("[title=New]");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage() {
        driver.get(URL);
        return this;
    }

    @Override
    public ContactListPage isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Table not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    public NewContactModal clickNew() {
        wait.elementToBeClickable(newButton);
        driver.findElement(newButton).click();
        return new NewContactModal(driver);
    }
}