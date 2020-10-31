package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteContactModal extends BasePage {
    public static final By DELETE_BUTTON = By.xpath("//span[contains(text(),'Delete')]");

    public DeleteContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public DeleteContactModal isPageOpened() {
        try {
            wait.elementToBeClickable(DELETE_BUTTON);
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Pole not found by locator " + DELETE_BUTTON);
        }
        return this;
    }
    public void confirmContactDeletion() {
        driver.findElement(DELETE_BUTTON).click();
        wait.elementToBeVisible(By.cssSelector(".toastIcon"));
    }
}
