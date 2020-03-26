package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CardPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import matchers.HasTextMatcher.hasTextMatcher;

public class CardPageSteps extends WebDriverSteps {

    public CardPageSteps(WebDriver driver) {
        super(driver);
    }

    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }

    @Step
    public String getProductQuantity() {
        return onCardPage().firstProductQuantity().getText();
    }

    @Step
    public String getProductPrice() {
        return onCardPage().productPriceSubtotal().getText();
    }

    @Step
    public String getProductName() {
        return onCardPage().productName().getText();
    }

    @Step
    public CardPageSteps shouldContainOneProductOrdered() {
        assertThat(onCardPage().firstProductQuantity(), hasTextMatcher("1"));
        return this;
    }

    @Step
    public CardPageSteps shouldContainProductPrice(String elementPrice) {
        assertThat(getProductPrice(), equalTo(elementPrice));
        return this;
    }

    @Step
    public CardPageSteps shoulContainElementName(String elementName) {
        assertThat(getProductName(), equalTo(elementName));
        return this;
    }
}
