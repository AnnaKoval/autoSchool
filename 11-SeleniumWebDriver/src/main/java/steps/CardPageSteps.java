package steps;

import org.openqa.selenium.WebDriver;
import pages.CardPage;

public class CardPageSteps extends WebDriverSteps {
    public CardPageSteps(WebDriver driver) {
        super(driver);
    }

    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }
}
