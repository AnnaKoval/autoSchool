package steps;

import html.CardHtml;
import html.ProductHtmlElement;
import io.qameta.allure.Step;
import matchers.HasTextMatcher;
import org.openqa.selenium.WebDriver;
import pages.CardPage;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayedMatcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CardPageSteps extends WebDriverSteps {

    public CardPageSteps(WebDriver driver) {
        super(driver);
    }

    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }

    public CardHtml onCardPageHtml() {
        return onPage(CardHtml.class);
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
        assertThat(onCardPage().firstProductQuantity(), HasTextMatcher.hasText(containsString("1")));
        onCardPage().firstProductQuantity().should(hasText("1"));
        onCardPageHtml().orderedProducts().should(isDisplayedMatcher()).should(hasText("1");
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
