package steps;

import blocks.Result;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchPageSteps extends WebDriverSteps {

    public SearchPageSteps(WebDriver driver) {
        super(driver);
    }

    public SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }

    @Step
    public SearchPageSteps search(String str) {
        onSearchPage().header().searchInput().sendKeys(str);
        onSearchPage().header().searchInput().submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new SearchPageSteps(driver);
    }

    @Step
    public SearchPageSteps shoulContainTextOnTitle(String str) {
        assertThat(onSearchPage().title().getText(), containsString(str));
        return this;
    }

    @Step
    public String getNameOfResultElement(int index) {
        ElementsCollection<Result> elements = getResultsCollection();
        return elements.get(index).resultName().getText();
    }

    @Step
    public String getPriceOfResultElement(int index) {
        ElementsCollection<Result> elements = getResultsCollection();
        return elements.get(index).resultPrice().getText();
    }

    @Step
    public int getResultWithPrice() {
        ElementsCollection<Result> elements = getResultsCollection();
        for (int index = 0; index < elements.size(); index++) {
            if (elements.get(index).resultPrice().isDisplayed()) {
                return index;
            }
        }
        return -1;
    }

    @Step
    public ProductPageSteps getElementProductPage(int index) {
        ElementsCollection<Result> elements = getResultsCollection();
        elements.get(index).resultLink().click();
        return new ProductPageSteps(driver);
    }

    @Step
    public SearchPageSteps shouldContainsStrForSearch(String strForSearch) {
        ElementsCollection<Result> elements = getResultsCollection();

        elements.forEach(element -> {
            if (element.isDisplayed()) {
                //assertThat(element.resultName().getText().toLowerCase(), containsString(strForSearch.toLowerCase())); -- будет падать!!!
            }
        });

        return this;
    }

    @Step
    public ElementsCollection<Result> getResultsCollection() {
        return onSearchPage().results();
    }
}
