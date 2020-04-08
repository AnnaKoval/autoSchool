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
    public ResultPageSteps shouldSeeSpeed(int index, String speed) {
        //onResultPage().resultRroducts().get(index).name().should(isDisplayed()).should(hasText()); ?
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProducts(String manufacturer, String wheel, String speed) {
        for (int i = 0; i < onResultPage().resultRroducts().size(); i++) {
            shouldSeeManufacturer(i, manufacturer);
            //shouldSeeWheel(i, wheel);
            //shouldSeeSpeed(i, speed);
        }
        return this;
    }
}
