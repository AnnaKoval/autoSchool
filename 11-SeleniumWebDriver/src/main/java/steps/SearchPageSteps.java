package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchPageSteps extends WebDriverSteps {

    public SearchPageSteps(WebDriver driver) {
        super(driver);
    }

    public SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }

    @Step
    public void searchStr(String str) {
        onSearchPage().header().searchInput().sendKeys(str);
        onSearchPage().header().searchInput().submit();
    }
}
