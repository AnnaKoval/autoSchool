import org.testng.annotations.Test;
import product.Product;
import steps.CardPageSteps;
import steps.ProductPageSteps;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        ProductPageSteps productPageSteps = storeHomePageSteps
                .search(searchDress)
                .selectProduct(0)
                .selectQuantity(dressQuantity);
        //.selectSize(dressSize);

        String name = productPageSteps.onProductPage().name().getText();
        String price = productPageSteps.onProductPage().price().getText();
        Product product1 = new Product(name, dressQuantity, price, dressSize);

        productPageSteps.addToCard()
                .shouldContainProductName(name)
                .shouldContainProductQuantity(dressQuantity, quantityAttribute)
                .shouldContainProductSize(dressSize)
                .shouldContainTotalProductPrice(price, Integer.parseInt(dressQuantity))
                .continueShopping()
                .search(searchBlouse)
                .selectProduct(0);
        //.selectSize(blouseSize);

        String blouseName = productPageSteps.onProductPage().name().getText();
        String blousePrice = productPageSteps.onProductPage().price().getText();
        String blouseQuantity = productPageSteps.getQuantity(quantityAttribute);
        Product product2 = new Product(blouseName, blouseQuantity,
                blousePrice, productPageSteps.getProductSize());

        CardPageSteps cardPageSteps = productPageSteps.addToCard()
                .shouldContainProductName(blouseName)
                .shouldContainProductQuantity(blouseQuantity, quantityAttribute)
                .shouldContainProductSize(blouseSize)
                .shouldContainTotalProductPrice(blousePrice, Integer.parseInt(blouseQuantity))
                .continueShopping()
                .openShoppingCard()
                .shouldContainProductList()
                .shouldContainProductInfo(product1, 0)
                .shouldContainProductInfo(product2, 1)
                .removeProduct(searchDress)
                .shouldNotContainDeletedProduct(searchDress)
                .shouldContainProduct(searchBlouse, 0);
    }
}