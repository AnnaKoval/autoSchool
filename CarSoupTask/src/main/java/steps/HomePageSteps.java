package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public HomePageSteps selectAdvancedSearch() {
        onHomePage().menuForSearch().selectMenu("icon-advanced-search").should(isDisplayed()).click();
        return this;
    }

    @Step
    public HomePageSteps selectFilter(String filterName, String filterOption) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onHomePage().optionsBlock(filterName).option(filterOption).findElement(By.xpath("self::*")));
        return this;
    }

    @Step
    public HomePageSteps selectMakes(String filterOption) {
        selectFilter("Makes", filterOption);
        return this;
    }

    @Step
    public HomePageSteps selectModels(String filterOption) {
        selectFilter("Models", filterOption);
        return this;
    }

    @Step
    public HomePageSteps selectColor(String filterOption) {
        selectFilter("Exterior Color", filterOption);
        return this;
    }

    @Step
    public HomePageSteps selectCylinderCount(String filterOption) {
        selectFilter("Cylinder Count", filterOption);
        return this;
    }

    @Step
    public ResultPageSteps advancedSearch() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onHomePage().searchButton().should(isDisplayed()).findElement(By.xpath("self::*")));
        return new ResultPageSteps(driver);
    }
}