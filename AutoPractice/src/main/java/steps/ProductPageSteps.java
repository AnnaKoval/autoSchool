package steps;

import elem.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import product.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

public class ProductPageSteps extends WebDriverSteps {

    public ProductPageSteps(WebDriver driver) {
        super(driver);
    }

    public ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

    @Step
    public ProductPageSteps selectSize(String size) {
        onProductPage().size().selectByVisibleText(size);
        return this;
    }

    @Step
    public ProductPageSteps inputQuantity(int quantity) {
        HtmlElement quan = onProductPage().quantity().should(isDisplayed());
        quan.clear();
        quan.sendKeys(String.valueOf(quantity));
        return this;
    }

    @Step
    public ProductPageSteps addToCard() {
        onProductPage().addToCard().should(isDisplayed()).click();
        return this;
    }

    @Step
    public ProductPageSteps shouldSeeProductSelected(Product product) {
        return shouldSeeProductName(product.getName())
                .shouldSeeProductQuantity(product.getQuantity())
                .shouldSeeProductSize(product.getSize());
    }

    @Step
    public ProductPageSteps shouldSeeProductName(String name) {
        onProductPage().popup().name().should(isDisplayed()).should(hasText(name));
        return this;
    }

    @Step
    public ProductPageSteps shouldSeeProductSize(String size) {
        String strWithSize = onProductPage().popup().size().should(isDisplayed()).getText();
        Pattern patt = Pattern.compile("(\\D*\\,\\s)(\\S)");
        Matcher match = patt.matcher(strWithSize);
        if (match.find())
            System.out.println("Its match!");
        assertThat(match.group(2), equalToIgnoringCase(size));
        return this;
    }

    @Step
    public ProductPageSteps shouldSeeProductQuantity(int quantity) {
        onProductPage().popup().quantity().should(isDisplayed()).should(hasText(String.valueOf(quantity)));
        return this;
    }

    @Step
    public String getTotalProductPrice(Product product) {
        if (product.getQuantity() == 1) {
            return product.getPrice();
        } else {
            Pattern patt = Pattern.compile("\\$(\\S*)");
            Matcher match = patt.matcher(product.getPrice());
            if (match.find())
                System.out.println("Its match!");
            double total = product.getQuantity() * Double.parseDouble(match.group(1));
            String totalStr = "$" + String.format("%.2f", total);
            return totalStr.replace(",", ".");
        }
    }

    @Step
    public ProductPageSteps continueShopping() {
        onProductPage().popup().continueButton().should(isDisplayed()).click();
        return new ProductPageSteps(driver);
    }

    @Step
    public StoreHomePageSteps search(String str) {
        HtmlElement inputSearch = onProductPage().header().searchInput().should(isDisplayed());
        inputSearch.clear();
        inputSearch.sendKeys(str);
        inputSearch.submit();
        return new StoreHomePageSteps(driver);
    }

    @Step
    public CardPageSteps openShoppingCard() {
        onProductPage().header().shoppingCard().should(isDisplayed()).click();
        return new CardPageSteps(driver);
    }

    @Step
    public String getProductName() {
        return onProductPage().name().should(isDisplayed()).getText();
    }

    @Step
    public int getQuantity(String attribute) {
        return Integer.parseInt(onProductPage().quantity().should(isDisplayed()).getAttribute(attribute));
    }

    @Step
    public String getProductSize() {
        return onProductPage().size().should(isDisplayed()).getText();
    }

    @Step
    public String getProductPrice() {
        return onProductPage().price().should(isDisplayed()).getText();
    }
}
