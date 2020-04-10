package steps;

import elem.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

import static matchers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static matchers.HasIntegerMatcher.hasInteger;
import static matchers.HasTextMatcher.hasText;
import static matchers.IsCollectionSorted.isSorted;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ResultPageSteps extends WebDriverSteps {

    public ResultPageSteps(WebDriver driver) {
        super(driver);
    }

    public ResultPage onResultPage() {
        return onPage(ResultPage.class);
    }

    @Step
    public ResultPageSteps shouldSeeResultList() {
        onResultPage().resultRroducts().should(hasSize(greaterThan(0)));
        return this;
    }

    @Step
    public ResultPageSteps selectSortPriceAscending() {
        onResultPage().sortLink().should(isDisplayed()).click();
        onResultPage().sort().selectSort("/catalog/zhenskie-gorodskie-velosipedy/?sort=price").should(isDisplayed()).click();
        return this;
    }

    @Step
    public ResultPageSteps selectFilter(String filterName, String filterOption) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onResultPage().optionsBlock(filterName).option(filterOption).findElement(By.xpath("self::*")));
        return this;
    }

    @Step
    public ResultPageSteps selectMake(String filterOption) {
        selectFilter("Производитель:", filterOption);
        return this;
    }

    @Step
    public ResultPageSteps selectWheel(String filterOption) {
        selectFilter("Диаметр колеса (дюймов):", filterOption);
        return this;
    }

    @Step
    public ResultPageSteps resultsShouldBeSortedByPrice() {
        onResultPage().resultRroducts()
                .filter(result -> result.isAvailable().should(isDisplayed()).getText().contains("Есть в наличии"))
                .extract(result -> Integer.valueOf(result.price().getText().replace(" ", "")))
                .should(isSorted());
        return this;
    }

    @Step
    public ResultPageSteps inputPriceFilter(int priceMin, int priceMax) {
        HtmlElement inputMinPrice = onResultPage().filterPrice().priceMin();
        HtmlElement inputMaxPrice = onResultPage().filterPrice().priceMax();
        inputMinPrice.clear();
        inputMinPrice.sendKeys(String.valueOf(priceMin));
        inputMaxPrice.clear();
        inputMaxPrice.sendKeys(String.valueOf(priceMax));
        onResultPage().filterPrice().submitButton().should(isDisplayed()).click();
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProducts(String manufacturer, String wheel, int priceMin, int priceMax) {
        onResultPage().resultRroducts()
                .extract(result -> result.name())
                .should(everyItem(hasText(containsIgnoringCase(manufacturer))))
                .should(everyItem(hasText(containsIgnoringCase("Велосипед " + wheel))));
        onResultPage().resultRroducts()
                .extract(result -> result.price())
                .should(everyItem(hasInteger(greaterThanOrEqualTo(priceMin))))
                .should(everyItem(hasInteger(lessThanOrEqualTo(priceMax))));
        return this;
    }
}