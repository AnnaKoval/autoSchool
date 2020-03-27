package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

import static matchers.IsDisplayedMatcher.isDisplayed;

public class ProductPageSteps extends WebDriverSteps {

    public ProductPageSteps(WebDriver driver) {
        super(driver);
    }

    public ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

    @Step
    public CardPageSteps goToCard() {
        onProductPage().header().cardButton().should(isDisplayed()).click();
        return new CardPageSteps(driver);
    }

    @Step
    public ProductPageSteps selectSize() {
        try {
            if (onProductPage().selectButton().isDisplayed()) {
                onProductPage().selectButton().click();
                onProductPage().sizeButton().should(isDisplayed()).click();
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Catch NoSuchElementException");
        }
        return this;
    }

    @Step
    public ProductPageSteps addToCard() {
        try {
            if (onProductPage().addToCardButton().isDisplayed())
                onProductPage().addToCardButton().click();
        } catch (NoSuchElementException ex) {
            System.out.println("Catch NoSuchElementException");
            onProductPage().buyingOptionsButton().should(isDisplayed()).click();
            onProductPage().addToCardOptionButton().should(isDisplayed()).click();
        }
        return this;
    }
}
