package steps;

import blocks.HtmlElement;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class SearchPageSteps extends WebDriverSteps {

    public SearchPageSteps(WebDriver driver) {
        super(driver);
    }

    public SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }

    @Step
    public SearchPageSteps search(String str) {
        HtmlElement searchInput = onSearchPage().header().searchInput().should(isDisplayed());
        searchInput.sendKeys(str);
        searchInput.submit();
        return new SearchPageSteps(driver);
    }


}
