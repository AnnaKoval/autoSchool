package steps;

import blocks.Result;
import elem.HtmlElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

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
    public ResultPageSteps selectFilter(String filterTitle, String filterOption) {
        ((JavascriptExecutor) driver).executeScript("arguments[0]",
                onResultPage().checkboxOptions().selectOption().title(filterTitle).findElement(By.xpath("self::*")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onResultPage().checkboxOptions().selectOption().selectOption(filterOption).findElement(By.xpath("self::*")));
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
                .waitUntil(not(empty()))
                .filter(resultProduct -> resultProduct.name().should(isDisplayed()).getText().toLowerCase().contains(manufacturer))
                .filter(resultProduct -> resultProduct.name().should(isDisplayed()).getText().contains("Велосипед " + wheel))
                .filter(resultProduct -> shouldSeePrice(resultProduct, priceMin, priceMax))
                .should(hasSize(greaterThan(0)));
        return this;
    }
}

