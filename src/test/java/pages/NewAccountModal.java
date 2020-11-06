package pages;

import elements.DropDown;
import elements.Input;
import elements.InputWithSearch;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewAccountModal extends BasePage {
    public final static By ACCOUNT_NAME_POLE = By.xpath("//span[contains(text(),'Sort')]/following-sibling::" +
            "span[contains(text(),'Account Name')]");
    public final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Verify New Account modal is opened")
    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.elementToBeVisible(ACCOUNT_NAME_POLE);
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Pole not found by locator " + ACCOUNT_NAME_POLE);
        }
        return this;
    }

    @Step("Create new account")
    public NewAccountModal create(Account account) {
        new InputWithSearch(driver, "Account Name").write(account.getAccountName());
        new DropDown(driver, "Type").selectOption(account.getType());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Phone").write(account.getPhone());
        new TextArea(driver, "Description").write(account.getDescription());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State").write(account.getBillingState());
        new Input(driver, "Billing Zip").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State").write(account.getShippingState());
        new Input(driver, "Shipping Zip").write(account.getShippingZip());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        return this;
    }

    @Step("Click Save button")
    public AccountDetailsPage clickSave() {
        wait.elementToBeClickable(SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}