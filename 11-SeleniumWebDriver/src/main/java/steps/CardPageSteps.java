package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CardPage;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;

public class CardPageSteps extends WebDriverSteps {

    public CardPageSteps(WebDriver driver) {
        super(driver);
    }

    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }

    @Step
    public CardPageSteps shouldContainOneProductOrdered() {
        onCardPage().firstProductQuantity().should(isDisplayed()).should(hasText("1"));
        return this;
    }

    @Step
    public CardPageSteps shouldContainProductPrice(String elementPrice) {
        onCardPage().productPriceSubtotal().should(isDisplayed()).should(hasText(elementPrice));
        return this;
    }

    @Step
    public CardPageSteps shouldContainElementName(String elementName) {
        onCardPage().productName().should(isDisplayed()).should(hasText(elementName));
        return this;
    }
}
