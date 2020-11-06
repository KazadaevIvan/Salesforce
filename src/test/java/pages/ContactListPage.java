package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static String URL = "https://wow4.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static By ALL_CONTACTS = By.xpath("//th[@scope='row']");
    public final static String CONTACT = "//*[contains(@title,'%s')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Contact List page")
    public ContactListPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Verify Contact List page is opened")
    @Override
    public ContactListPage isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Button not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    @Step("Click New button")
    public NewContactModal clickNew() {
        wait.elementToBeClickable(NEW_BUTTON);
        driver.findElement(NEW_BUTTON).click();
        return new NewContactModal(driver);
    }

    @Step("Get number of contacts")
    public int getNumberOfContacts() {
        wait.elementToBeVisible(ALL_CONTACTS);
        List<WebElement> list = driver.findElements(ALL_CONTACTS);
        return list.size();
    }

    @Step("Open contact '{name}'")
    public ContactDetailsPage openContact(String name) {
        wait.elementToBeClickable(By.xpath(String.format(CONTACT, name)));
        driver.findElement(By.xpath(String.format(CONTACT, name))).click();
        return new ContactDetailsPage(driver);
    }

    @Step("Verify account is deleted. Number of account should be less than '{numberOfAccounts}'")
    public ContactListPage verifyNumberOfContactsAfterDeletion(int numberOfContacts) {
        assertEquals(getNumberOfContacts(), (numberOfContacts-1));
        return this;
    }
}