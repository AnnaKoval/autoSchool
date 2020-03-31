package steps;

import elem.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class StoreHomePageSteps extends WebDriverSteps {

    public StoreHomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePage onStoreHomePage() {
        return onPage(HomePage.class);
    }

    @Step
    public StoreHomePageSteps search(String str) {
        HtmlElement inputSearch=onStoreHomePage().header().searchInput();
        inputSearch.clear();
        inputSearch.sendKeys(str);
        inputSearch.submit();
        return new StoreHomePageSteps(driver);
    }

    @Step
    public ProductPageSteps selectProduct(int index) {
        onStoreHomePage().results().get(index).resultLink().click();
        return new ProductPageSteps(driver);
    }
}
