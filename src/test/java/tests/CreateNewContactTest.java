package tests;

import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class CreateNewContactTest extends BaseTest {
    Contact contact;

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(LOGIN, PASSWORD);
        contact = new Contact("Mr.", "Ivan", "Ivanovich", "Ivanov", "suffix",
                "Account", "title", "department", "email@mail.com", "123",
                "12345678", "12345678", "ul. Pushkina", "Minsk", "Minsk",
                "220140", "Belarus");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
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
                .validateContact(contact);
    }
}