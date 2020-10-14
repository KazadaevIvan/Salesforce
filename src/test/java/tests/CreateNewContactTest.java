package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateNewContactTest extends BaseTest {

    String accountName = "Account for testing";

    @BeforeMethod
    public void login() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("", "");
        homePage
                .isPageOpened();
        tab
                .openTab("Accounts")
                .isTabOpened("Accounts")
                .clickCreateNew();
        modal
                .isModalOpened("Accounts")
                .inputWithSearchSendKeys("Account Name", accountName)
                .submitForm();
        homePage
                .isPageOpened();
        tab
                .openTab("Accounts")
                .isTabOpened("Accounts");
        assertEquals(tab.getFirstName(), accountName, "Account name should be '" +
                accountName + "'");
    }

    @Test
    public void newContactShouldBeCreated() {
        homePage
                .isPageOpened();
        tab
                .openTab("Contacts")
                .isTabOpened("Contacts")
                .clickCreateNew();

        String lastName = "Ivanov";

        modal
                .isModalOpened("Contacts")
                .inputSendKeys("Phone", "124246")
                .selectOption("Salutation", "Mr.")
                .inputSendKeys("Last Name", lastName)
                .inputWithSearchSendKeys("Account Name", accountName)
                .inputWithSearchChooseOption(accountName)
                .submitForm();
        homePage
                .isPageOpened();
        tab
                .openTab("Contacts")
                .isTabOpened("Contacts");
        assertEquals(tab.getFirstName(), lastName, "Account name should be '" +
                lastName + "'");
    }
}