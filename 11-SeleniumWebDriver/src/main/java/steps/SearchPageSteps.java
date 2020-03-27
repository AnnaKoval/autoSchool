package steps;

import blocks.HtmlElement;
import blocks.Result;
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

    @Step
    public SearchPageSteps shouldContainTextOnTitle(String str) {
        onSearchPage().title().should(isDisplayed()).should(hasText(containsString(str)));
        return this;
    }

    @Step
    public String getNameOfResultElement(int index) {
        return getResultsCollection().get(index).resultName().should(isDisplayed()).getText();
    }

    @Step
    public String getPriceOfResultElement(int index) {
        return getResultsCollection().get(index).resultPrice().should(isDisplayed()).getText();
    }

    @Step
    public int getResultWithPrice() {
        ElementsCollection<Result> elements = getResultsCollection();
        for (int index = 0; index < elements.size(); index++) {
            if (elements.get(index).resultPrice().isDisplayed()) {
                return index;
            }
        }
        Assert.fail("Result has no product with price");
        return -1;
    }

    @Step
    public ProductPageSteps getElementProductPage(int index) {
        getResultsCollection().get(index).resultLink().should(isDisplayed()).click();
        return new ProductPageSteps(driver);
    }

    @Step
    public SearchPageSteps shouldContainsStrForSearch(String strForSearch) {
        ElementsCollection<Result> elements = getResultsCollection();

        elements.forEach(element -> {
            element.resultName()
                    .should(isDisplayed()).
                    should(element.resultName().getText().toLowerCase(), hasText(containsString(strForSearch.toLowerCase())));
        });
        return this;
    }

    @Step
    public ElementsCollection<Result> getResultsCollection() {
        ElementsCollection<Result> results = onSearchPage().results().should(hasSize(greaterThan(0)));
        return results;
    }
}
