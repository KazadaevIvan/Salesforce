package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateNewAccountTest extends BaseTest {

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("", "");
    }

    @Test
    public void newAccountShouldBeCreated() {
        homePage
                .isPageOpened();
        tab
                .openTab("Accounts")
                .isTabOpened("Accounts")
                .clickCreateNew();

        String accountName = "Account for testing";

        modal
                .isModalOpened("Accounts")
                .inputWithSearchSendKeys("Account Name", accountName)
                .selectOption("Type", "Investor")
                .inputSendKeys("Website", "123@mail.ru")
                .inputSendKeys("Phone", "12345678")
                .selectOption("Industry", "Apparel")
                .inputSendKeys("Employees", "4")
                .textAreaSendKeys("Description", "abcsadkjgsf")
                .textAreaSendKeys("Billing Street", "Lenina street")
                .textAreaSendKeys("Shipping Street", "Octiabrskaya street")
                .inputSendKeys("Billing City", "Minsk")
                .inputSendKeys("Billing State/Province", "Minsk")
                .inputSendKeys("Billing Zip/Postal Code", "220-118")
                .inputSendKeys("Billing Country", "Belarus")
                .inputSendKeys("Shipping City", "Minsk")
                .inputSendKeys("Shipping State/Province", "Minsk")
                .inputSendKeys("Shipping Zip/Postal Code", "220-109")
                .inputSendKeys("Shipping Country", "Belarus")
                .submitForm();
        homePage
                .isPageOpened();
        tab
                .openTab("Accounts")
                .isTabOpened("Accounts");
        assertEquals(tab.getFirstName(), accountName, "Account name should be '" +
                accountName + "'");
    }
}