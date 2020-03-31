package steps;

import blocks.Ordered;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.CardPage;
import product.Product;

import static junit.framework.TestCase.assertTrue;
import static matchers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class CardPageSteps extends WebDriverSteps {

    public CardPageSteps(WebDriver driver) {
        super(driver);
    }

    public CardPage onCardPage() {
        return onPage(CardPage.class);
    }

    @Step
    public CardPageSteps shouldContainProductList() {
        onCardPage().orderedProducts().should(hasSize(greaterThan(0)));
        return this;
    }

    @Step
    public CardPageSteps shouldContainProductInfo(Product p, int index) {
        return shouldContainName(p, index)
                .shouldContainPrice(p, index)
                //.shouldContainSize(p, index)
                .shouldContainQuantity(p, index);
    }

    @Step
    public CardPageSteps shouldContainName(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productName().should(isDisplayed()).should(hasText(p.getName()));
        return this;
    }

    @Step
    public CardPageSteps shouldContainQuantity(Product p, int index) {
        assertThat(onCardPage().orderedProducts().get(index).quantity().getAttribute("value"), equalTo(p.getQuantity()));
        return this;
    }

    @Step
    public CardPageSteps shouldContainSize(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productSize().should(isDisplayed()).should(hasText(p.getSize()));
        return this;
    }

    @Step
    public CardPageSteps shouldContainPrice(Product p, int index) {
        onCardPage().orderedProducts().get(index).productPrice().should(isDisplayed()).should(hasText(p.getPrice()));
        return this;
    }

    @Step
    public CardPageSteps removeProduct(String name) {
        ElementsCollection<Ordered> orderedProducts = onCardPage().orderedProducts();
        orderedProducts.stream()
                .filter(orderedProduct -> !orderedProduct.description().productName().getText().contains(name))
                .forEach(orderedProduct -> orderedProduct.deleteButton().should(isDisplayed()).click());
        return this;
    }

    public CardPageSteps shouldNotContainDeletedProduct(String name) {
        ElementsCollection<Ordered> orderedProducts = onCardPage().orderedProducts();
        assertTrue(!orderedProducts.stream()
                .anyMatch(orderedProduct ->
                        orderedProduct.description().productName().getText().contains(name)));
        return this;
    }

    public CardPageSteps shouldContainProduct(String name, int index) {
        onCardPage().orderedProducts().get(index).description().productName().should(isDisplayed()).should(hasText(containsIgnoringCase(name)));
        return this;
    }
}
