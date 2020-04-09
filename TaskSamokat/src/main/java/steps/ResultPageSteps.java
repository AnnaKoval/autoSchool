package steps;

import blocks.Result;
import elem.HtmlElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

import java.util.List;
import java.util.stream.Collectors;

import static matchers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static matchers.HasTextMatcher.hasText;
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
    public ResultPageSteps selectMake(String filterOption) {
        selectFilter("brands_filter_wrap", filterOption);
        return this;
    }

    @Step
    public ResultPageSteps selectWheel(String filterOption) {
        selectFilter("filter_wrap_options", filterOption);
        return this;
    }

    @Step
    public ResultPageSteps selectFilter(String filter, String filterOption) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onResultPage().checkboxOptions().selectOption(filter).selectOption(filterOption).findElement(By.xpath("self::*")));
        return this;
    }

    public int convertPriceToInt(String strPrice) {
        return Integer.valueOf(strPrice.replace(" ", ""));
    }

    @Step
    public boolean isAvailable(Result product) {
        return product.isAvailable().should(isDisplayed()).getText().contains("Есть в наличии");
    }

    @Step
    public ResultPageSteps shouldSortedByPrice() {
        for (int i = 0; i < onResultPage().resultRroducts().size() - 1; i++) {
            if (isAvailable(onResultPage().resultRroducts().get(i + 1))) {
                if (convertPriceToInt(onResultPage().resultRroducts().get(i).price().should(isDisplayed()).getText())
                        <= convertPriceToInt(onResultPage().resultRroducts().get(i + 1).price().should(isDisplayed()).getText())) {
                    System.out.println("Price is sorted");
                } else {
                    Assert.fail("Price is not sorted");
                }
            }
        }
        return this;
    }

    @Step
    public boolean shouldSeePrice(Result product, int priceMin, int priceMax) {
        if (isAvailable(product)) {
            if (convertPriceToInt(product.price().should(isDisplayed()).getText()) >= priceMin &&
                    priceMax >= convertPriceToInt(product.price().should(isDisplayed()).getText())) {
                return true;
            } else {
                Assert.fail("Price is not filtered");
            }
        }
        return false;
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
                .stream().collect(Collectors.toList())
                .forEach(resultProduct -> shouldSeePrice(resultProduct, priceMin, priceMax));
        onResultPage().resultRroducts()
                .stream().collect(Collectors.toList())
                .forEach(resultProduct -> resultProduct.name().should(isDisplayed()).should(hasText(containsIgnoringCase(manufacturer))));
        //onResultPage().resultRroducts().stream().collect(Collectors.toList())
           //     .forEach(resultProduct -> resultProduct.name().should(isDisplayed()).should(hasText(containsIgnoringCase("Велосипед " + wheel))));
        return this;
    }
}

