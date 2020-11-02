package tests;

import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CreateNewContactTest extends BaseTest {
    Contact contact;

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(LOGIN, PASSWORD);
        contact = Contact.newBuilder()
                .setSalutation("Mr.")
                .setFirstName("Ivan")
                .setMiddleName("Ivanovich")
                .setLastName("Ivanov")
                .setSuffix("suffix")
                .setAccountName("Account")
                .setTitle("title")
                .setDepartment("department")
                .setEmail("email@mail.com")
                .setFax("123")
                .setPhone("12345678")
                .setMobile("12345678")
                .setMailingStreet("ul. Pushkina")
                .setMailingCity("Minsk")
                .setMailingState("Minsk")
                .setMailingZip("220140")
                .setMailingCountry("Belarus")
                .build();
    }

    @Test
    public void newContactShouldBeCreated() {
        contactListPage
                .openPage()
                .isPageOpened()
                .clickNew();
        newContactModal
                .isPageOpened()
                .create(contact)
                .clickSave();
        contactDetailPage
                .isPageOpened()
                .validateContact(contact)
                .deleteContact();
        deleteContactModal
                .confirmContactDeletion();
    }
}