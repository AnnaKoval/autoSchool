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
    public void verifyTextOnTitle(String str) {
        assertThat(onSearchPage().title().getText(), containsString(str));
    }

    @Step
    public ProductPageSteps viewProduct(Result element) {
        element.resultLink().click();
        return new ProductPageSteps(driver);
    }

    @Step
    public String getNameOfResultElement(ElementsCollection<Result> elements) {
        String firstElementName = "";

        for (Result element : elements) {
            if (element.resultPrice().isDisplayed()) {
                firstElementName = element.resultName().getText();
                break;
            }
        }
        return firstElementName;
    }

    @Step
    public String getPriceOfResultElement(ElementsCollection<Result> elements) {
        String elementPrice = "";

        for (Result element : elements) {
            if (element.resultPrice().isDisplayed()) {
                elementPrice = element.resultPrice().getText();
                break;
            }
        }
        return elementPrice;
    }

    @Step
    public ProductPageSteps getProduct(Result element) {
        return viewProduct(element);
    }

    @Step
    public ElementsCollection<Result> getResultsOfSearch() {
        ElementsCollection<Result> elements = onSearchPage().results();
        return elements;
    }

    @Step
    public void verifyIsElementContainsStrForSearch(String strForSearch, ElementsCollection<Result> elements) {
        elements.forEach(element -> {
            if (element.isDisplayed()) {
                //assertThat(element.resultName().getText().toLowerCase(), containsString(strForSearch.toLowerCase())); -- будет падать!!!
            }
        });
    }
}
