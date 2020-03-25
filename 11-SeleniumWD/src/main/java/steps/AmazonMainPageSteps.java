package steps;

import static matchers.IsDisplayedMatcher.isDisplayedMatcher;
import static org.hamcrest.MatcherAssert.assertThat;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebElement categories=onAmazonMainPage().categories();
        assertThat(categories, isDisplayedMatcher());
    }

    @Step
    public void selectCategory(String category) {
        isCategoriesDisplayed();
        onAmazonMainPage().categories().selectByVisibleText(category);
    }
}
