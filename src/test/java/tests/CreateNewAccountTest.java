package tests;

import models.Account;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;
import utils.AllureUtils;

public class CreateNewAccountTest extends BaseTest {
    Account account;

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(LOGIN, PASSWORD);
        AllureUtils.takeScreenshot(driver);
        account = Account.newBuilder()
                .setAccountName("Account")
                .setWebsite("website")
                .setType("Analyst")
                .setDescription("description")
                .setPhone("12345678")
                .setIndustry("Banking")
                .setEmployees("20")
                .setBillingStreet("ul. Lenina")
                .setBillingCity("Minsk")
                .setBillingState("Minsk")
                .setBillingZip("220140")
                .setBillingCountry("Belarus")
                .setShippingStreet("ul. Pushkina")
                .setShippingCity("Minsk")
                .setShippingState("Minsk")
                .setShippingZip("220018")
                .setShippingCountry("Belarus")
                .build();
    }

    @Test
    public void newAccountShouldBeCreated() {
        accountListPage
                .openPage()
                .isPageOpened()
                .clickNew();
        newAccountModal
                .isPageOpened()
                .create(account)
                .clickSave();
        accountDetailsPage
                .isPageOpened()
                .validateAccount(account);
    }
}