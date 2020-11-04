package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utils.CapabilitiesGenerator;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String LOGIN = System.getenv().getOrDefault("login", PropertyReader.getProperty("login"));
    public static final String PASSWORD = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
    public WebDriver driver;
    protected LoginPage loginPage;
    protected AccountListPage accountListPage;
    protected NewAccountModal newAccountModal;
    protected AccountDetailsPage accountDetailsPage;
    protected ContactListPage contactListPage;
    protected NewContactModal newContactModal;
    protected ContactDetailsPage contactDetailsPage;
    protected DeleteModal deleteModal;
    protected ContactListPageSteps contactListPageSteps;
    protected ContactDetailsPageSteps contactDetailsPageSteps;
    protected LoginPageSteps loginPageSteps;
    protected AccountListPageSteps accountListPageSteps;
    protected AccountDetailsPageSteps accountDetailsPageSteps;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        accountListPage = new AccountListPage(driver);
        newAccountModal = new NewAccountModal(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        deleteModal = new DeleteModal(driver);
        contactListPageSteps = new ContactListPageSteps(driver);
        contactDetailsPageSteps = new ContactDetailsPageSteps(driver);
        loginPageSteps = new LoginPageSteps(driver);
        accountListPageSteps = new AccountListPageSteps(driver);
        accountDetailsPageSteps = new AccountDetailsPageSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}