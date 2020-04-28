package steps;

import elem.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static matchers.IsDisplayedMatcher.isDisplayed;

public class LoginPageSteps extends WebDriverSteps {

    public LoginPageSteps(WebDriver driver) {
        super(driver, "users/login");
    }

    public LoginPage onLoginPage() {
        return onPage(LoginPage.class);
    }

    @Step
    public ProjectsPageSteps login(String login, String password) {
        HtmlElement loginField = onLoginPage().login();
        loginField.clear();
        loginField.sendKeys(login);
        HtmlElement passwordField=onLoginPage().password();
        passwordField.clear();
        passwordField.sendKeys(password);
        onLoginPage().loginButton().should(isDisplayed()).click();
        return new ProjectsPageSteps(driver);
    }
}