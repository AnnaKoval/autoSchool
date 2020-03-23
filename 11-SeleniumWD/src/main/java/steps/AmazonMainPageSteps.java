package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPageSteps(WebDriver driver) {
        super(driver);
    }

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public void selectCategory(String category) {
        onAmazonMainPage().category(category).click();
    }
}
