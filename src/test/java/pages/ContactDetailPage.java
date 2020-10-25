package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactDetailPage extends BasePage {
    public final static By DETAILS = By.xpath("(//*[@title='Details'])[1]/a");
    public final static String detailLocator = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::*";
    public final static String baseInfo = "[@data-output-element-id='output-field']";
    public final static String addressInfo = "[@class='slds-truncate']";
    public final static String accountName = "/descendant::a/span";

    public ContactDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactDetailPage isPageOpened() {
        try {
            wait.elementToBeVisible(DETAILS);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Pole not found by locator " + DETAILS);
        }
        return this;
    }

    public ContactDetailPage validateContact(String salutation, String firstName, String middleName, String lastName,
                                             String suffix, String accountName, String title, String department,
                                             String email, String fax, String phone, String mobile, String mailingStreet,
                                             String mailingCity, String mailingState, String mailingZip,
                                             String mailingCountry) {
        wait.elementToBeClickable(DETAILS);
        driver.findElement(DETAILS).click();
        assertEquals(getFullName(), fullNameConstructor(salutation, firstName, middleName, lastName, suffix),
                "Name should be " + fullNameConstructor(salutation, firstName, middleName, lastName, suffix));
        assertEquals(getAccountName("Account Name"), accountName, "Account Name should be " + accountName);
        assertEquals(getPoleText("Title"), title, "Title should be " + title);
        assertEquals(getPoleText("Department"), department, "Department should be " + department);
        assertEquals(getPoleText("Email"), email, "Email should be " + email);
        assertEquals(getPoleText("Fax"), fax, "Fax should be " + fax);
        assertEquals(getPoleText("Phone"), phone, "Phone should be " + phone);
        assertEquals(getPoleText("Mobile"), mobile, "Mobile should be " + mobile);
        String mailingAddress = addressConstructor(mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry);
        assertEquals(getAddressPoleText("Mailing"), mailingAddress, "Shipping address should be " +
                mailingAddress);
        return this;
    }

    public String getFullName() {
        return driver.findElement(By.xpath(String.format("(" + detailLocator + baseInfo + ")[1]", "Name"))).getText();
    }

    public String fullNameConstructor(String salutation, String firstName, String middleName, String lastName,
                                      String suffix) {
        return salutation + " " + firstName + " " + middleName + " " + lastName + " " + suffix;
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

    public String getAccountName(String poleName) {
        return driver.findElement(By.xpath(String.format(detailLocator + baseInfo + accountName, poleName))).getText();
    }
}