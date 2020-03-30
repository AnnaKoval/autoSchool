package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static matchers.IsDisplayedMatcher.isDisplayed;

public class StoreHomePageSteps extends WebDriverSteps {

    public StoreHomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePage onStoreHomePage() {
        return onPage(HomePage.class);
    }

    @Step
    public StoreHomePageSteps search(String str) {
        onStoreHomePage().header().searchInput().should(isDisplayed()).clear();
        onStoreHomePage().header().searchInput().sendKeys(str);
        onStoreHomePage().header().searchInput().submit();
        return new StoreHomePageSteps(driver);
    }

    @Step
    public ProductPageSteps selectProduct(int index) {
        onStoreHomePage().results().get(index).resultLink().click();
        return new ProductPageSteps(driver);
    }
}
