package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactDetailPage extends BasePage {
    public final static By DETAILS = By.xpath("(//*[@title='Details'])[1]/a");
    public final static By DELETE_BUTTON = By.xpath("//*[@name='Delete']");
    public final static String detailLocator = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::*";
    public final static String baseInfo = "[@data-output-element-id='output-field']";
    public final static String addressInfo = "[@class='slds-truncate']";
    public final static String accountName = "/descendant::a/span";

    public ContactDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactDetailPage isPageOpened() {
        try {
            wait.elementToBeVisible(DETAILS);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Pole not found by locator " + DETAILS);
        }
        return this;
    }

    public ContactDetailPage validateContact(Contact contact) {
        wait.elementToBeClickable(DETAILS);
        driver.findElement(DETAILS).click();
        assertEquals(getFullName(), fullNameConstructor(contact.getSalutation(), contact.getFirstName(),
                contact.getMiddleName(), contact.getLastName(), contact.getSuffix()),
                "Name should be " + fullNameConstructor(contact.getSalutation(), contact.getFirstName(),
                        contact.getMiddleName(), contact.getLastName(), contact.getSuffix()));
        assertEquals(getAccountName("Account Name"), contact.getAccountName(), "Account Name should be "
                + contact.getAccountName());
        assertEquals(getPoleText("Title"), contact.getTitle(), "Title should be " + contact.getTitle());
        assertEquals(getPoleText("Department"), contact.getDepartment(), "Department should be "
                + contact.getDepartment());
        assertEquals(getPoleText("Email"), contact.getEmail(), "Email should be " + contact.getEmail());
        assertEquals(getPoleText("Fax"), contact.getFax(), "Fax should be " + contact.getFax());
        assertEquals(getPoleText("Phone"), contact.getPhone(), "Phone should be " + contact.getPhone());
        assertEquals(getPoleText("Mobile"), contact.getMobile(), "Mobile should be " + contact.getMobile());
        String mailingAddress = addressConstructor(contact.getMailingStreet(), contact.getMailingCity(), contact.getMailingState(),
                contact.getMailingZip(), contact.getMailingCountry());
        assertEquals(getAddressPoleText("Mailing"), mailingAddress, "Shipping address should be " +
                mailingAddress);
        return this;
    }

    public String getFullName() {
        return driver.findElement(By.xpath(String.format("(" + detailLocator + baseInfo + ")[1]", "Name"))).getText();
    }

    public String fullNameConstructor(String salutation, String firstName, String middleName, String lastName,
                                      String suffix) {
        return salutation + " " + firstName + " " + middleName + " " + lastName + " " + suffix;
    }

    public String getPoleText(String poleName) {
        return driver.findElement(By.xpath(String.format(detailLocator + baseInfo, poleName))).getText();
    }

    public String getAddressPoleText(String addressType) {
        StringBuilder address = new StringBuilder();
        List<WebElement> list = driver.findElements(By.xpath(String.format(detailLocator + addressInfo, addressType)));
        for (WebElement line : list) {
            address.append(line.getText()).append("\n");
        }
        return String.valueOf(address);
    }

    public String addressConstructor(String street, String city, String state,
                                     String zip, String country) {
        return street + "\n" + city + ", " + state +
                " " + zip + "\n" + country + "\n";
    }

    public String getAccountName(String poleName) {
        return driver.findElement(By.xpath(String.format(detailLocator + baseInfo + accountName, poleName))).getText();
    }

    public DeleteContactModal deleteContact() {
        wait.elementToBeClickable(DELETE_BUTTON);
        driver.findElement(DELETE_BUTTON).click();
        return new DeleteContactModal(driver);
    }
}