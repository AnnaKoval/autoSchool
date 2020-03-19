package steps;

import io.qameta.allure.Step;
import pages.AmazonMainPage;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public SearchPageSteps selectCategory(String url) {
        this.onAmazonMainPage().open(url);
        this.onAmazonMainPage().category().click();
        return new SearchPageSteps();
    }
}
