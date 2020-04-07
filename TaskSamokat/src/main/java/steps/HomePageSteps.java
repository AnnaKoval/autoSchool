package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static matchers.IsDisplayedMatcher.isDisplayed;

public class HomePageSteps extends WebDriverSteps {

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePage onHomePage() {
        return onPage(HomePage.class);
    }

    @Step
    public ResultPageSteps selectWomenCityBikes() {
        onHomePage().menu().selectMenu("/velosipedy/").should(isDisplayed()).click();
        onHomePage().menu().selectMenu("/gorodskie-velosipedy/").should(isDisplayed()).click();
        onHomePage().menu().selectMenu("/zhenskie-gorodskie-velosipedy/").should(isDisplayed()).click();
        return new ResultPageSteps(driver);
    }
}