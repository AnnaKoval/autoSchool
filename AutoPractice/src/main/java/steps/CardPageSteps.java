package steps;

import blocks.Ordered;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CardPage;
import product.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static matchers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
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
    public CardPageSteps shouldSeeProductList() {
        onCardPage().orderedProducts().should(hasSize(greaterThan(0)));
        return this;
    }

    @Step
    public CardPageSteps shouldSeeProduct(Product p, int index) {
        return shouldSeeName(p, index)
                .shouldSeePrice(p, index)
                .shouldSeeSize(p, index)
                .shouldSeeQuantity(p, index);
    }

    @Step
    public CardPageSteps shouldSeeName(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productName().should(isDisplayed()).should(hasText(p.getName()));
        return this;
    }

    @Step
    public CardPageSteps shouldSeeQuantity(Product p, int index) {
        onCardPage().orderedProducts().get(index).quantity()
                .should(isDisplayed())
                .should(hasAttribute("value", p.getQuantity()));
        return this;
    }

    @Step
    public CardPageSteps shouldSeeSize(Product p, int index) {
        onCardPage().orderedProducts().get(index).description().productSize()
                .should(isDisplayed()).should(hasText(containsString(": "+p.getSize())));
        return this;
    }

    @Step
    public CardPageSteps shouldSeePrice(Product p, int index) {
        onCardPage().orderedProducts().get(index).productPrice().should(isDisplayed()).should(hasText(p.getPrice()));
        return this;
    }

    @Step
    public CardPageSteps removeProduct(String str) {
        String[] parts = str.split(" ");
        onCardPage().orderedProducts().stream()
                .filter(orderedProduct -> orderedProduct.description().productName()
                        .should(isDisplayed()).getText().contains(parts[0])
                        && orderedProduct.description().productName()
                        .should(isDisplayed()).getText().contains(parts[1]))
                .forEach(orderedProduct -> orderedProduct.deleteButton()
                        .should(isDisplayed()).click());
        return this;
    }

    public CardPageSteps shouldNotContainDeletedProduct(String str) {
        String[] parts = str.split(" ");
        onCardPage().orderedProducts()
                .waitUntil(not(empty()))
                .filter(orderedProduct -> orderedProduct.description().productName().getText().contains(parts[0])
                        && orderedProduct.description().productName().getText().contains(parts[1]))
                .should(hasSize(0));
        return this;
    }

    public CardPageSteps shouldSeeProduct(String name) {
        onCardPage().orderedProducts()
                .waitUntil(not(empty()))
                .filter(orderedProduct -> orderedProduct.description().productName().getText().contains(name))
                .should(hasSize(greaterThan(0)));
        return this;
    }

    public CardPageSteps shouldSeeTotalPrice(Product product1, Product product2) {
        Pattern patt = Pattern.compile("\\$(\\S*)");
        Matcher match1 = patt.matcher(product1.getPrice());
        Matcher match2 = patt.matcher(product2.getPrice());
        if (match1.find() && match2.find())
            System.out.println("Its match!");
        double total = product1.getQuantity() * Double.parseDouble(match1.group(1)) +
                product2.getQuantity() * Double.parseDouble(match2.group(1));
        String totalStr = ("$" + String.format("%.2f", total)).replace(",", ".");
        assertThat(onCardPage().totalPrice().should(isDisplayed()), hasText(totalStr));
        return this;
    }
}
