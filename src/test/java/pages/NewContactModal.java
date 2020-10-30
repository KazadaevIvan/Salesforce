package pages;

import elements.DropDown;
import elements.Input;
import elements.InputWithSearch;
import elements.TextArea;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewContactModal extends BasePage {
    public final static By NAME_POLE = By.xpath("//legend/span[contains(text(),'Name')]");
    public final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal isPageOpened() {
        try {
            wait.elementToBeVisible(NAME_POLE);
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Pole not found by locator " + NAME_POLE);
        }
        return this;
    }

    public NewContactModal create(Contact contact) {
        new DropDown(driver, "Salutation").selectOption(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new InputWithSearch(driver, "Account Name").selectOption(contact.getAccountName());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing State").write(contact.getMailingState());
        new Input(driver, "Mailing Zip").write(contact.getMailingZip());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        return this;
    }

    public ContactListPage clickSave() {
        wait.elementToBeClickable(SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
        return new ContactListPage(driver);
    }
}
