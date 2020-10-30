package pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccountDetailsPage extends BasePage {
    public final static By DETAILS = By.xpath("(//*[@title='Details'])[1]/a");
    public final static String detailLocator = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::*";
    public final static String baseInfo = "[@data-output-element-id='output-field']";
    public final static String addressInfo = "[@class='slds-truncate']";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountDetailsPage isPageOpened() {
        try {
            wait.elementToBeVisible(DETAILS);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Pole not found by locator " + DETAILS);
        }
        return this;
    }

    public AccountDetailsPage validateAccount(Account account) {
        wait.elementToBeClickable(DETAILS);
        driver.findElement(DETAILS).click();
        assertEquals(getPoleText("Account Name"), account.getAccountName(), "Account Name should be "
                + account.getAccountName());
        assertEquals(getPoleText("Website"), account.getWebsite(), "Website should be "
                + account.getWebsite());
        assertEquals(getPoleText("Type"), account.getType(), "Type should be " + account.getType());
        assertEquals(getPoleText("Phone"), account.getPhone(), "Phone should be " + account.getPhone());
        assertEquals(getPoleText("Description"), account.getDescription(), "Description should be "
                + account.getDescription());
        assertEquals(getPoleText("Industry"), account.getIndustry(), "Industry should be "
                + account.getIndustry());
        assertEquals(getPoleText("Employees"), account.getEmployees(), "Employees should be "
                + account.getEmployees());
        String billingAddress = addressConstructor(account.getBillingStreet(), account.getBillingCity(),
                account.getBillingState(), account.getBillingZip(), account.getBillingCountry());
        assertEquals(getAddressPoleText("Billing"), billingAddress, "Billing address should be " +
                billingAddress);
        String shippingAddress = addressConstructor(account.getShippingStreet(), account.getShippingCity(),
                account.getShippingState(), account.getShippingZip(), account.getShippingCountry());
        assertEquals(getAddressPoleText("Shipping"), shippingAddress, "Shipping address should be " +
                shippingAddress);
        return this;
    }

    public String getPoleText(String poleName) {
        return driver.findElement(By.xpath(String.format(detailLocator + baseInfo, poleName))).getText();
    }

    public String getAddressPoleText(String addressType) {
        StringBuilder address = new StringBuilder();
        List<WebElement> list = driver.findElements(By.xpath(String.format(detailLocator + addressInfo, addressType)));
        for (WebElement line : list) {
            address.append(line.getText()).append("\n");
        }
        return String.valueOf(address);
    }

    public String addressConstructor(String street, String city, String state,
                                     String zip, String country) {
        return street + "\n" + city + ", " + state +
                " " + zip + "\n" + country + "\n";
    }
}