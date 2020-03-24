package steps;

import blocks.OrderedProducts;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.CardPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
    public CardPageSteps verifyOneProductOrdered() {
        assertThat(this.getProductQuantity(), equalTo("1"));
        return this;
    }

    @Step
    public CardPageSteps verifyProductPrice(String firstElementPriceWhole, String firstElementPriceFraction) {
        assertThat(this.getProductPrice(), equalTo("$" + firstElementPriceWhole + "." + firstElementPriceFraction));
        return this;
    }

    @Step
    public CardPageSteps verifyElementName(String elementName, ElementsCollection<OrderedProducts> orderedProducts) {
        assertThat(orderedProducts.get(0).productName().getText(), equalTo(elementName));
        return this;
    }
}
