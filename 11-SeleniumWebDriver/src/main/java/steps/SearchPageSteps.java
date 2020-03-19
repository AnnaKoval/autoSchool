package steps;

import io.qameta.allure.Step;
import pages.SearchPage;

public class SearchPageSteps extends WebDriverSteps {

    public SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }

    @Step
    public SearchPageSteps searchStr(String str) {
        this.onSearchPage().header().searchInput().sendKeys(str);
        this.onSearchPage().header().searchInput().submit();
        return this;
    }

    @Step
    public ProductPageSteps selectProduct() {
        this.onSearchPage().firstProduct().click();
        return new ProductPageSteps();
    }
}
