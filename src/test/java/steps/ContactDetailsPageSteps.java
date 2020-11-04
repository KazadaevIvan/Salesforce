package steps;

import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactDetailsPage;

import static org.testng.Assert.assertEquals;

public class ContactDetailsPageSteps {
    private ContactDetailsPage contactDetailsPage;

    public ContactDetailsPageSteps(WebDriver driver) {
        contactDetailsPage = new ContactDetailsPage(driver);
    }

    @Step("Validate contact")
    public ContactDetailsPageSteps validateContact(Contact contact) {
        assertEquals(contactDetailsPage.getFullName(), contact.fullNameConstructor(),
                "Name should be " + contact.fullNameConstructor());
        assertEquals(contactDetailsPage.getAccountName("Account Name"), contact.getAccountName()
                , "Account Name should be " + contact.getAccountName());
        assertEquals(contactDetailsPage.getPoleText("Title"), contact.getTitle(), "Title should be "
                + contact.getTitle());
        assertEquals(contactDetailsPage.getPoleText("Department"), contact.getDepartment(),
                "Department should be " + contact.getDepartment());
        assertEquals(contactDetailsPage.getPoleText("Email"), contact.getEmail(), "Email should be "
                + contact.getEmail());
        assertEquals(contactDetailsPage.getPoleText("Fax"), contact.getFax(), "Fax should be " + contact.getFax());
        assertEquals(contactDetailsPage.getPoleText("Phone"), contact.getPhone(), "Phone should be "
                + contact.getPhone());
        assertEquals(contactDetailsPage.getPoleText("Mobile"), contact.getMobile(), "Mobile should be "
                + contact.getMobile());
        assertEquals(contactDetailsPage.getAddressPoleText("Mailing"), contact.addressConstructor(),
                "Shipping address should be " + contact.addressConstructor());
        return this;
    }
}
