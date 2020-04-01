package steps;

import blocks.Ordered;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CardPage;
import product.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static matchers.HasAttributeMatcher.hasAttribute;
import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

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
    public CardPageSteps shouldContainProductInfo(Product p, int index, String value) {
        return shouldContainName(p, index)
                .shouldContainPrice(p, index)
                .shouldContainSize(p, index)
                .shouldContainQuantity(p, index, value);
    }

    @Step
    public CardPageSteps shouldContainName(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productName().should(isDisplayed()).should(hasText(p.getName()));
        return this;
    }

    @Step
    public CardPageSteps shouldContainQuantity(Product p, int index, String attribute) {
        onCardPage().orderedProducts().get(index).quantity().should(isDisplayed()).should(hasAttribute(attribute, p.getQuantity()));
        return this;
    }

    @Step
    public CardPageSteps shouldContainSize(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productSize()
                .should(isDisplayed())
                .should(hasText(containsString(p.getSize())));
        return this;
    }

    @Step
    public CardPageSteps shouldContainPrice(Product p, int index) {
        onCardPage().orderedProducts().get(index).productPrice().should(isDisplayed()).should(hasText(p.getPrice()));
        return this;
    }

    @Step
    public CardPageSteps removeProduct(String str1, String str2) {
        Collection<Ordered> orderedProducts = onCardPage().orderedProducts();
        List<Ordered> list = orderedProducts.stream()
                .filter(orderedProduct -> orderedProduct.description().productName().getText().contains(str1)
                        && orderedProduct.description().productName().getText().contains(str2))
                .collect(Collectors.toList());
        list.forEach(orderedProduct -> orderedProduct.deleteButton().should(isDisplayed()).click());
        return this;
    }

    public CardPageSteps shouldNotContainDeletedProduct(String str1, String str2) {
        assertThat(onCardPage().orderedProducts().stream()
                .filter(orderedProduct ->
                        orderedProduct.description().productName().getText().contains(str1)
                                && orderedProduct.description().productName().getText().contains(str2))
                .count(), equalTo(0));
        return this;
    }

    public CardPageSteps shouldContainProduct(String name) {
        assertThat(onCardPage().orderedProducts().stream()
                .filter(orderedProduct -> orderedProduct.description().productName().getText().contains(name)).findAny(), notNullValue());
        return this;
    }
}
