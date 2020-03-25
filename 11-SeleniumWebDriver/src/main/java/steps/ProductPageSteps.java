package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class ProductPageSteps extends WebDriverSteps {

    public ProductPageSteps(WebDriver driver) {
        super(driver);
    }

    public ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

    @Step
    public CardPageSteps goToCard() {
        onProductPage().header().cardButton().click();
        return new CardPageSteps(driver);
    }

    @Step
    public ProductPageSteps selectSize() {
        try {
            if (onProductPage().selectButton().isDisplayed()) {
                onProductPage().selectButton().click();
                onProductPage().sizeButton().click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
            onProductPage().buyingOptionsButton().click();
            onProductPage().addToCardOptionButton().click();
        }
        return this;
    }
}
