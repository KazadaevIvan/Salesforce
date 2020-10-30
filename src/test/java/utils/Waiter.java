package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    WebDriver driver;
    int seconds;

    public Waiter(WebDriver driver, int seconds) {
        this.driver = driver;
        this.seconds = seconds;
    }

    public void elementToBeVisible(By by) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void elementToBeClickable(By by) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .until(driver -> driver.findElement(by));
    }
}