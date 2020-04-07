package steps;

import org.openqa.selenium.WebDriver;
import pages.ResultPage;

public class ResultPageSteps extends WebDriverSteps {

    public ResultPageSteps(WebDriver driver) {
        super(driver);
    }

    public ResultPage onResultPage() {
        return onPage(ResultPage.class);
    }

}
