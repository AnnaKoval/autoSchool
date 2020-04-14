package steps;

import blocks.HtmlElement;
import blocks.Suggestions;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPageSteps(WebDriver driver) {
        super(driver);
    }

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public AmazonMainPageSteps selectCategory(String category) {
        onAmazonMainPage().categories().selectByVisibleText(category);
        return this;
    }

    @Step
    public AmazonMainPageSteps input(String str) {
        HtmlElement searchInput = onAmazonMainPage().header().searchInput().should(isDisplayed());
        searchInput.sendKeys(str);
        return this;
    }

    @Step
    public ElementsCollection<Suggestions> getSuggestionsCollection() {
        ElementsCollection<Suggestions> suggestions = onAmazonMainPage().suggestions();
              //  .should(isDisplayed())
              //  .should(hasSize(greaterThan(0)));

        return suggestions;
    }
}
