package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonMainPage;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPageSteps(WebDriver driver) {
        super(driver);
    }

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public SearchPageSteps selectCategory(String category) {
        Select select = new Select(onAmazonMainPage().categories());
        select.selectByVisibleText(category);
        return new SearchPageSteps(driver);
    }
}
