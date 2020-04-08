package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

import static matchers.IsDisplayedMatcher.isDisplayed;
import static matchers.HasTextMatcher.*;
import static matchers.CaseInsensitiveSubstringMatcher.*;
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
    public ResultPageSteps selectFilter(String filterStr) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                onResultPage().filterOptions().selectOption(filterStr).findElement(By.xpath("self::*")));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeSortedPrice() {
        for (int i = 0; i < onResultPage().resultRroducts().size() - 1; i++) {
            if (isAvailable(i + 1)) {
                if (convertPriceToInt(onResultPage().resultRroducts().get(i).price().should(isDisplayed()).getText())
                        <= convertPriceToInt(onResultPage().resultRroducts().get(i + 1).price().should(isDisplayed()).getText())) {
                    System.out.println("Price is sorted");
                } else {
                    Assert.fail("Price is not sorted");
                }
            } else {
                return this;
            }
        }
        return this;
    }

    public int convertPriceToInt(String strPrice) {
        return Integer.valueOf(strPrice.replace(" ", ""));
    }

    @Step
    public boolean isAvailable(int index) {
        return onResultPage().resultRroducts().get(index).isAvailable().should(isDisplayed()).getText().contains("Есть в наличии");
    }

    @Step
    public ResultPageSteps shouldSeeManufacturer(int index, String manufacturer) {
        onResultPage().resultRroducts().get(index).name().should(isDisplayed()).should(hasText(containsIgnoringCase(manufacturer)));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeWheel(int index, String wheel) {
        onResultPage().resultRroducts().get(index).name().should(isDisplayed()).should(hasText(containsIgnoringCase("Велосипед " + wheel)));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeePrice(int index, int priceMin, int priceMax) {
        if (isAvailable(index)) {
            if (convertPriceToInt(onResultPage().resultRroducts().get(index).price().should(isDisplayed()).getText()) >= priceMin &&
                    priceMax >= convertPriceToInt(onResultPage().resultRroducts().get(index).price().should(isDisplayed()).getText())) {
                System.out.println("Price is filtered");
            } else {
                Assert.fail("Price is not filtered");
            }
        }
        return this;
    }

    @Step
    public ResultPageSteps inputPriceFilter(String priceMin, String priceMax) {
        onResultPage().filterOptions().priceMin().should(isDisplayed()).clear();
        onResultPage().filterOptions().priceMin().should(isDisplayed()).sendKeys(priceMin);
        onResultPage().filterOptions().priceMax().should(isDisplayed()).clear();
        onResultPage().filterOptions().priceMax().should(isDisplayed()).sendKeys(priceMax);
        onResultPage().filterOptions().submitButton().click();
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProducts(String manufacturer, String wheel, int priceMin, int priceMax) {
        for (int i = 0; i < onResultPage().resultRroducts().size(); i++) {
            shouldSeeManufacturer(i, manufacturer);
            shouldSeeWheel(i, wheel);
            shouldSeePrice(i, priceMin, priceMax);
        }
        return this;
    }

}
