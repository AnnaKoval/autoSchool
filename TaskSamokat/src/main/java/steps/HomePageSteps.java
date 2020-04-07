package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps extends WebDriverSteps {

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePage onHomePage() {
        return onPage(HomePage.class);
    }

    @Step
    public void selectWomenCityBikes() {
        onHomePage().menu().selectMenu("/velosipedy/");
        onHomePage().menu().selectMenu("/gorodskie-velosipedy/").click();
    }
}