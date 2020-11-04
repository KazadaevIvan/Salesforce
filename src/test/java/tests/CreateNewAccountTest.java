package tests;

import models.Account;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CreateNewAccountTest extends BaseTest {
    Account account;

    @BeforeMethod(description = "Login")
    public void login() {
        loginPageSteps
                .login(LOGIN, PASSWORD);
        account = Account.newBuilder()
                .setAccountName("Account for testing")
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

    @Test(description = "Verify that user could create new account")
    public void newAccountShouldBeCreated() {
        accountListPageSteps
                .createNewAccount(account);
        accountDetailsPageSteps
                .validateAccount(account);
    }

    @AfterMethod(description = "Delete account")
    public void deleteAccount() {
        accountListPageSteps
                .deleteAccount(account.getAccountName());
    }
}