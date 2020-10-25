package pages;

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

    public AccountDetailsPage validateAccount(String accountName, String website, String type, String phone,
                                              String description, String industry, String employees, String billingStreet,
                                              String billingCity, String billingState, String billingZip,
                                              String billingCountry, String shippingStreet, String shippingCity,
                                              String shippingState, String shippingZip, String shippingCountry) {
        wait.elementToBeClickable(DETAILS);
        driver.findElement(DETAILS).click();
        assertEquals(getPoleText("Account Name"), accountName, "Account Name should be " + accountName);
        assertEquals(getPoleText("Website"), website, "Website should be " + accountName);
        assertEquals(getPoleText("Type"), type, "Type should be " + accountName);
        assertEquals(getPoleText("Phone"), phone, "Phone should be " + accountName);
        assertEquals(getPoleText("Description"), description, "Description should be " + accountName);
        assertEquals(getPoleText("Industry"), industry, "Industry should be " + accountName);
        assertEquals(getPoleText("Employees"), employees, "Employees should be " + accountName);
        String billingAddress = addressConstructor(billingStreet, billingCity, billingState, billingZip, billingCountry);
        assertEquals(getAddressPoleText("Billing"), billingAddress, "Billing address should be " +
                billingAddress);
        String shippingAddress = addressConstructor(shippingStreet, shippingCity, shippingState, shippingZip, shippingCountry);
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