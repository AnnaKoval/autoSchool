package steps;

import static matchers.IsDisplayedMatcher.isDisplayed;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPageSteps(WebDriver driver) {
        super(driver);
    }

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public SearchPageSteps selectCategory(String category) {
        onAmazonMainPage().categories().should(isDisplayed()).selectByVisibleText(category);
        return new SearchPageSteps(driver);
    }
}
