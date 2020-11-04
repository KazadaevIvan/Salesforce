package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ContactListPage extends BasePage {
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static String URL = "https://wow4.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static By ALL_CONTACTS = By.xpath("//th[@scope='row']");
    public final static String CONTACT = "//*[contains(@title,'%s')]";

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
            Assert.fail("The page has not been loaded. Button not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    public NewContactModal clickNew() {
        wait.elementToBeClickable(NEW_BUTTON);
        driver.findElement(NEW_BUTTON).click();
        return new NewContactModal(driver);
    }

    public int getNumberOfContacts() {
        wait.elementToBeVisible(ALL_CONTACTS);
        List<WebElement> list = driver.findElements(ALL_CONTACTS);
        return list.size();
    }

    public ContactDetailsPage openContact(String name) {
        wait.elementToBeClickable(By.xpath(String.format(CONTACT, name)));
        driver.findElement(By.xpath(String.format(CONTACT, name))).click();
        return new ContactDetailsPage(driver);
    }

    public ContactListPage numberOfContactsAfterDeletionShouldBeLessThan(int numberOfContacts) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.numberOfElementsToBeLessThan(ALL_CONTACTS, numberOfContacts));
        return this;
    }
}