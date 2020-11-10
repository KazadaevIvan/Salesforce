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
        account = Account.builder()
                .accountName("Account for testing")
                .website("website")
                .type("Analyst")
                .description("description")
                .phone("12345678")
                .industry("Banking")
                .employees("20")
                .billingStreet("ul. Lenina")
                .billingCity("Minsk")
                .billingState("Minsk")
                .billingZip("220140")
                .billingCountry("Belarus")
                .shippingStreet("ul. Pushkina")
                .shippingCity("Minsk")
                .shippingState("Minsk")
                .shippingZip("220018")
                .shippingCountry("Belarus")
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