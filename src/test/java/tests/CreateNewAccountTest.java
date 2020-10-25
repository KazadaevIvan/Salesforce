package tests;

import models.Account;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {
    Account account;

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("", "");
        account = new Account("Account", "website", "Analyst", "12345678",
                "description", "Banking", "20", "ul. Lenina",
                "Minsk", "Minsk", "220140", "Belarus",
                "ul. Pushkina", "Minsk", "Minsk", "220018",
                "Belarus");
    }

    @Test
    public void newAccountShouldBeCreated() {
        accountListPage
                .openPage()
                .clickNew();
        newAccountModal
                .isPageOpened()
                .create(account)
                .clickSave();
        accountDetailsPage
                .isPageOpened()
                .validateAccount("Account", "website", "Analyst", "12345678",
                        "description", "Banking", "20", "ul. Lenina",
                        "Minsk", "Minsk", "220140", "Belarus",
                        "ul. Pushkina", "Minsk", "Minsk", "220018",
                        "Belarus");
    }
}