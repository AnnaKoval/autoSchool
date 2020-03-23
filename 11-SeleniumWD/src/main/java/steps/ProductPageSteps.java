package steps;

import org.openqa.selenium.WebDriver;
import pages.ProductPage;

public class ProductPageSteps extends WebDriverSteps {

    public ProductPageSteps(WebDriver driver) {
        super(driver);
    }

    public ProductPage onProductPage() {
        return onPage(ProductPage.class);
    }

    public void goToCard() {
        onProductPage().header().cardButton().click();
    }
}
