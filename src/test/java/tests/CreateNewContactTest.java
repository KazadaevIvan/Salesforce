package tests;

import models.Contact;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CreateNewContactTest extends BaseTest {
    Contact contact;

    @BeforeMethod(description = "Login")
    public void login() {
        loginPageSteps
                .login(LOGIN, PASSWORD);
        contact = Contact.builder()
                .salutation("Mr.")
                .firstName("Ivan")
                .middleName("Ivanovich")
                .lastName("Ivanov")
                .suffix("suffix")
                .accountName("Account")
                .title("title")
                .department("department")
                .email("email@mail.com")
                .fax("123")
                .phone("12345678")
                .mobile("12345678")
                .mailingStreet("ul. Pushkina")
                .mailingCity("Minsk")
                .mailingState("Minsk")
                .mailingZip("220140")
                .mailingCountry("Belarus")
                .build();
    }

    @Test(description = "Verify that user could create new contact")
    public void newContactShouldBeCreated() {
        contactListPageSteps
                .createNewContact(contact);
        contactDetailsPageSteps
                .validateContact(contact);
    }

    @AfterMethod(description = "Delete contact")
    public void deleteContact() {
        contactListPageSteps
                .deleteContact(contact.getFirstName());
    }
}