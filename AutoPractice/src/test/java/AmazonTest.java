import org.testng.annotations.Test;
import product.Product;
import steps.CardPageSteps;
import steps.ProductPageSteps;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() throws Exception {
        ProductPageSteps productPageSteps = storeHomePageSteps
                .search(searchDress)
                .selectProduct(0)
                .selectQuantity(dressQuantity);
                //.selectSize(dressSize);                                      //?????????????????????????????????????????
        String name = productPageSteps.onProductPage().name().getText();
        String price = productPageSteps.onProductPage().price().getText();

        Product product1 = new Product(name, dressQuantity, price, dressSize);

        productPageSteps.addToCard()
                .shouldContainProductName(name)
                .shouldContainProductQuantity(dressQuantity)
                .shouldContainProductSize(dressSize)
                .shouldContainTotalProductPrice(price)
                .continueShopping()
                .search(searchBlouse)
                .selectProduct(0);
        //.selectSize(blouseSize);

        String blouseName = productPageSteps.onProductPage().name().getText();
        String blousePrice = productPageSteps.onProductPage().price().getText();
        String blouseQuantity = productPageSteps.onProductPage().quantity().getAttribute("value");

        Product product2 = new Product(blouseName, blouseQuantity,
                blousePrice, productPageSteps.getProductSize());

        CardPageSteps cardPageSteps = productPageSteps.addToCard()
                .shouldContainProductName(blouseName)
                .shouldContainProductQuantity(blouseQuantity)
                .shouldContainProductSize(blouseSize)
                .shouldContainTotalProductPrice(blousePrice)
                .continueShopping()
                .openShoppingCard()
                .shouldContainProductInfo(product1, 0)
                .shouldContainProductInfo(product2, 1);

        cardPageSteps.removeProduct(searchDress)
                .shouldNotContainDeletedProduct(searchDress)
                .shouldContainProduct(searchBlouse, 0);
    }
}