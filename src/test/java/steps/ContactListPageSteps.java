package steps;

import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactListPage;

public class ContactListPageSteps {
    private ContactListPage contactListPage;

    public ContactListPageSteps(WebDriver driver) {
        contactListPage = new ContactListPage(driver);
    }

    @Step("Create new contact")
    public ContactListPageSteps createNewContact(Contact contact) {
        contactListPage
                .openPage()
                .isPageOpened()
                .clickNew()
                .isPageOpened()
                .create(contact)
                .clickSave()
                .openContactDetails();
        return this;
    }

    @Step("Delete contact '{contactName}'")
    public ContactListPageSteps deleteContact(String contactName) {
        int initialNumberOfContacts = contactListPage
                .openPage()
                .isPageOpened()
                .getNumberOfContacts();
        contactListPage
                .openContact(contactName)
                .isPageOpened()
                .deleteContact()
                .isPageOpened()
                .confirmDeletion();
        contactListPage
                .openPage()
                .isPageOpened()
                .verifyNumberOfContactsAfterDeletion(initialNumberOfContacts);
        return this;
    }
}