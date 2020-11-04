package steps;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountDetailsPage;

import static org.testng.Assert.assertEquals;

public class AccountDetailsPageSteps {
    private AccountDetailsPage accountDetailsPage;

    public AccountDetailsPageSteps(WebDriver driver) {
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @Step("Validate account")
    public AccountDetailsPageSteps validateAccount(Account account) {
        assertEquals(accountDetailsPage.getPoleText("Account Name"), account.getAccountName(),
                "Account Name should be " + account.getAccountName());
        assertEquals(accountDetailsPage.getPoleText("Website"), account.getWebsite(),
                "Website should be " + account.getWebsite());
        assertEquals(accountDetailsPage.getPoleText("Type"), account.getType(),
                "Type should be " + account.getType());
        assertEquals(accountDetailsPage.getPoleText("Phone"), account.getPhone(),
                "Phone should be " + account.getPhone());
        assertEquals(accountDetailsPage.getPoleText("Description"), account.getDescription(),
                "Description should be " + account.getDescription());
        assertEquals(accountDetailsPage.getPoleText("Industry"), account.getIndustry(),
                "Industry should be " + account.getIndustry());
        assertEquals(accountDetailsPage.getPoleText("Employees"), account.getEmployees(),
                "Employees should be " + account.getEmployees());
        assertEquals(accountDetailsPage.getAddressPoleText("Billing"), account.billingAddressConstructor(),
                "Billing address should be " + account.billingAddressConstructor());
        assertEquals(accountDetailsPage.getAddressPoleText("Shipping"), account.shippingAddressConstructor(),
                "Shipping address should be " + account.shippingAddressConstructor());
        return this;
    }
}
