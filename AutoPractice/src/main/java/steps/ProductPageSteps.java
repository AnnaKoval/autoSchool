package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;

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
    public ProductPageSteps selectQuantity(String quantity) {
        onProductPage().quantity().should(isDisplayed()).clear();
        onProductPage().quantity().sendKeys(quantity);
        return this;
    }

    @Step
    public ProductPageSteps addToCard() {
        onProductPage().addToCard().should(isDisplayed()).click();
        return this;
    }

    @Step
    public ProductPageSteps shouldContainProductName(String name) {
        onProductPage().popup().name().should(isDisplayed()).should(hasText(name));
        return this;
    }

    @Step
    public ProductPageSteps shouldContainProductSize(String size) {
        onProductPage().popup().size().should(isDisplayed()).should(hasText(size));
        return this;
    }

    @Step
    public ProductPageSteps shouldContainProductQuantity(String quantity) {
        onProductPage().popup().quantity().should(isDisplayed()).should(hasText(quantity));
        return this;
    }

    @Step
    public String getQuantity() {
        return onProductPage().popup().quantity().getText();
    }

    @Step
    public ProductPageSteps shouldContainTotalProductPrice(String price) {
        int quantity = Integer.parseInt(getQuantity());
        if (quantity == 1) {
            onProductPage().popup().price().should(isDisplayed()).should(hasText(price));
        } else {
            Pattern patt = Pattern.compile("\\$(\\d*)\\.(\\d+)");
            Matcher match = patt.matcher(price);
            if (match.find())
                System.out.println("Its match!");
            int total = quantity * Integer.parseInt(match.group(1));
            int part = quantity * Integer.parseInt(match.group(2));

            int remainder = part / 100;
            part = part - 100 * remainder;
            total = total + remainder;
            String priceStr = "$" + total + "." + part;
            onProductPage().popup().price().should(isDisplayed()).should(hasText(priceStr));
        }
        return this;
    }

    @Step
    public ProductPageSteps continueShopping() {
        onProductPage().popup().continueButton().click();
        return new ProductPageSteps(driver);
    }

    @Step
    public StoreHomePageSteps search(String str) {
        onProductPage().header().searchInput().should(isDisplayed()).clear();
        onProductPage().header().searchInput().sendKeys(str);
        onProductPage().header().searchInput().submit();
        return new StoreHomePageSteps(driver);
    }

    @Step
    public CardPageSteps openShoppingCard() {
        onProductPage().header().shoppingCard().should(isDisplayed());
        onProductPage().header().shoppingCard().click();
        return new CardPageSteps(driver);
    }

    @Step
    public String getProductName() {
        return onProductPage().name().getText();
    }

    @Step
    public String getProductQuantity() {
        return onProductPage().quantity().getAttribute("value");
    }

    @Step
    public String getProductSize() {
        return onProductPage().size().getText();
    }

    @Step
    public String getProductPrice() {
        return onProductPage().price().getText();
    }
}
