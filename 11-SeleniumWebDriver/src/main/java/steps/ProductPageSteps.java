package steps;

import pages.ProductPage;

public class ProductPageSteps extends WebDriverSteps {

    public ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

    public ProductPageSteps addToCard() {
        this.onProductPage().addToCardButton().click();
//        onProductPage().productName()
//                .should("Product is not found", WebElement::isDisplayed);--добавить вейтеры везде
        return this;
    }

    public CardPageSteps goToCard() {
        this.onProductPage().header().cardButton().click();
        return new CardPageSteps();
    }
}
