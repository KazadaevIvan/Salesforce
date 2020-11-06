package pages;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AccountDetailsPage extends BasePage {
    public final static By DETAILS = By.xpath("(//*[@title='Details'])[1]/a");
    public final static By DELETE_BUTTON = By.xpath("//*[@name='Delete']");
    public final static String detailLocator = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::*";
    public final static String baseInfo = "[@data-output-element-id='output-field']";
    public final static String addressInfo = "[@class='slds-truncate']";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Account Details page is opened")
    @Override
    public AccountDetailsPage isPageOpened() {
        try {
            wait.elementToBeVisible(DETAILS);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Pole not found by locator " + DETAILS);
        }
        return this;
    }

    @Step("Open Account Details page")
    public AccountDetailsPage openAccountDetails(Account account) {
        wait.elementToBeClickable(DETAILS);
        driver.findElement(DETAILS).click();
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

    @Step("Click Delete button")
    public DeleteModal deleteAccount() {
        wait.elementToBeClickable(DELETE_BUTTON);
        driver.findElement(DELETE_BUTTON).click();
        return new DeleteModal(driver);
    }
}