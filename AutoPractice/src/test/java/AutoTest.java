import org.testng.annotations.Test;
import product.Product;
import steps.ProductPageSteps;

public class AutoTest extends BaseTest {

    @Test
    public void autoTest() throws InterruptedException {
        String searchDress = "Printed Dress", searchBlouse = "blouse";
        String dressSize = "M", blouseSize = "S";
        int dressQuantity = 10;

        ProductPageSteps productPageSteps = storeHomePageSteps
                .search(searchDress)
                .selectProduct(0)
                .inputQuantity(dressQuantity)
                .selectSize(dressSize);

        String name = productPageSteps.onProductPage().name().getText();
        String price = productPageSteps.onProductPage().price().getText();
        Product product1 = new Product(name, dressQuantity, price, dressSize);

        productPageSteps.addToCard()
                .shouldSeeProductSelected(product1)
                .continueShopping()
                .search(searchBlouse)
                .selectProduct(0)
                .selectSize(blouseSize);

        String blouseName = productPageSteps.onProductPage().name().getText();
        String blousePrice = productPageSteps.onProductPage().price().getText();

        Product product2 = new Product(blouseName, 1, blousePrice, blouseSize);

        productPageSteps.addToCard()
                .shouldSeeProductSelected(product2)
                .continueShopping()
                .openShoppingCard()
                .shouldSeeProductList()
                .shouldSeeProduct(product1, 0)
                .shouldSeeProduct(product2, 1)
                .shouldSeeTotalPrice(product1, product2)
                .removeProduct(searchDress)
                .shouldSeeProduct(searchBlouse)
                .shouldNotContainDeletedProduct(searchDress);
    }
}