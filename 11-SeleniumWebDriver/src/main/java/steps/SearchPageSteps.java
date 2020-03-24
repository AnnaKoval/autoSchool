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

        assertThat(onSearchPage().title().getText(), containsString(str));
        return new SearchPageSteps(driver);
    }

    @Step
    public ProductPageSteps viewProduct(Result element) {
        element.resultLink().click();
        return new ProductPageSteps(driver);
    }

    @Step
    public String getFirstElementName(ElementsCollection<Result> elements) {
        String firstElementName = "";

        for (Result element : elements) {
            if (element.resultPriceWhole().isDisplayed()) {
                firstElementName = element.resultName().getText();
                break;
            }
        }
        return firstElementName;
    }

    @Step
    public String getFirstPriceWhole(ElementsCollection<Result> elements) {
        String firstElementPriceWhole = "";

        for (Result element : elements) {
            if (element.resultPriceWhole().isDisplayed()) {
                firstElementPriceWhole = element.resultPriceWhole().getText();
                break;
            }
        }
        return firstElementPriceWhole;
    }

    @Step
    public String getFirstElementPriceFraction(ElementsCollection<Result> elements) {
        String firstElementPriceFraction = "";

        for (Result element : elements) {
            if (element.resultPriceWhole().isDisplayed()) {
                firstElementPriceFraction = element.resultPriceFraction().getText();
                break;
            }
        }
        return firstElementPriceFraction;
    }

    @Step
    public ProductPageSteps getProduct(ElementsCollection<Result> elements) {
        for (Result element : elements) {
            if (element.resultPriceWhole().isDisplayed()) {
                return this.viewProduct(element);
            }
        }
        return new ProductPageSteps(driver);
    }
}
