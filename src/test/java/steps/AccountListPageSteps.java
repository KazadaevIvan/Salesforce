package steps;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountListPage;

public class AccountListPageSteps {
    private AccountListPage accountListPage;

    public AccountListPageSteps(WebDriver driver) {
        accountListPage = new AccountListPage(driver);
    }

    @Step("Create new account")
    public AccountListPageSteps createNewAccount(Account account) {
        accountListPage
                .openPage()
                .isPageOpened()
                .clickNew()
                .isPageOpened()
                .create(account)
                .clickSave()
                .openAccountDetails(account);
        return this;
    }

    @Step("Delete account '{accountName}'")
    public AccountListPageSteps deleteAccount(String accountName) {
        int initialNumberOfAccounts = accountListPage
                .openPage()
                .isPageOpened()
                .getNumberOfAccounts();
        accountListPage
                .openAccount(accountName)
                .isPageOpened()
                .deleteAccount()
                .isPageOpened()
                .confirmDeletion();
        accountListPage
                .openPage()
                .isPageOpened()
                .numberOfAccountsAfterDeletionShouldBeLessThan(initialNumberOfAccounts);
        return this;
    }
}
