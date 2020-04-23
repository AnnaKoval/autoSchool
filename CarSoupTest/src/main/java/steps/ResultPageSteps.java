package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

import static matchers.ContainsSubstringArrayMatcher.containsArray;
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
    public ResultPageSteps shouldSeeSelectedBrandFilter(String brand) {
        onResultPage().filter("{\"brand\":\""+brand+"\"}")
                .should(isDisplayed());
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeSelectedModelFilter(String model) {
        onResultPage().filter("{\"model\":\""+model+"\"}")
                .should(isDisplayed());
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeSelectedColorFilter(String color) {
        onResultPage().filter("{\"exterior_color_simple\":\""+color+"\"}")
                .should(isDisplayed());
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeSelectedCylinderFilter(int cylinder) {
        onResultPage().filter("{\"engine_cylinders\":\""+cylinder+"\"}")
                .should(isDisplayed());
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProductManufacturer(String... manufacturers) {
        onResultPage().resultRroducts()
                .extract(result -> result.name())
                .should(everyItem(hasText(containsArray(manufacturers))));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProductModel(String... models) {
        onResultPage().resultRroducts()
                .extract(result -> result.name())
                .should(everyItem(hasText(containsArray(models))));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProductColor(String... colors) {
        onResultPage().resultRroducts()
                .extract(result -> result.color())
                .should(everyItem(hasText(containsArray(colors))));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeFilteredProductCylinders(String... cylinders) {
        onResultPage().resultRroducts()
                .extract(result -> result.cylinderCount())
                .should(everyItem(hasText(containsArray(cylinders))));
        return this;
    }

    @Step
    public ResultPageSteps shouldSeeResultList() {
        onResultPage().resultRroducts().should(hasSize(greaterThan(0)));
        return this;
    }
}