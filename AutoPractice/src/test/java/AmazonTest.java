import org.testng.annotations.Test;
import product.Product;
import steps.ProductPageSteps;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        ProductPageSteps productPageSteps = storeHomePageSteps
                .search(searchDress)
                .selectProduct(0)
                .selectQuantity(dressQuantity)
                .selectSize(dressSize);

        String name = productPageSteps.onProductPage().name().getText();
        String price = productPageSteps.onProductPage().price().getText();
        Product product1 = new Product(name, dressQuantity, price, dressSize);

        productPageSteps.addToCard()
                .shouldContainProductName(name)
                .shouldContainProductQuantity(dressQuantity)
                .shouldContainProductSize(dressSize)
                .shouldContainTotalProductPrice(price, Integer.parseInt(dressQuantity))
                .continueShopping()
                .search(searchBlouse)
                .selectProduct(0)
                .selectSize(blouseSize);

        String blouseName = productPageSteps.onProductPage().name().getText();
        String blousePrice = productPageSteps.onProductPage().price().getText();
        String blouseQuantity = productPageSteps.getQuantity(quantityAttribute);
        Product product2 = new Product(blouseName, blouseQuantity,
                blousePrice, blouseSize);

        productPageSteps.addToCard()
                .shouldContainProductName(blouseName)
                .shouldContainProductQuantity(blouseQuantity)
                .shouldContainProductSize(blouseSize)
                .shouldContainTotalProductPrice(blousePrice, Integer.parseInt(blouseQuantity))
                .continueShopping()
                .openShoppingCard()
                .shouldContainProductList()
                .shouldContainProductInfo(product1, 0, quantityAttribute)
                .shouldContainProductInfo(product2, 1, quantityAttribute)
                .removeProduct(printedStr, dressStr)
                //.shouldNotContainDeletedProduct(printedStr, dressStr)
                .shouldContainProduct(searchBlouse);
    }
}