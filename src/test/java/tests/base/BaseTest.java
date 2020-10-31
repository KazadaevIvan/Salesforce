package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
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
    protected ContactDetailPage contactDetailPage;
    protected DeleteContactModal deleteContactModal;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
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
        contactDetailPage = new ContactDetailPage(driver);
        deleteContactModal = new DeleteContactModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}