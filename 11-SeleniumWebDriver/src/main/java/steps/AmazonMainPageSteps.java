package steps;

import static matchers.IsDisplayedMatcher.isDisplayedMatcher;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void isCategoriesDisplayed() {
        assertThat(onAmazonMainPage().categories(), isDisplayedMatcher());
    }

    @Step
    public SearchPageSteps selectCategory(String category) {
        isCategoriesDisplayed();
        onAmazonMainPage().categories().selectByVisibleText(category);
        return new SearchPageSteps(driver);
    }
}
