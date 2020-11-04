package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login with login '{login}' and password '{password}'")
    public LoginPageSteps login(String login, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(login, password);
        return this;
    }
}
