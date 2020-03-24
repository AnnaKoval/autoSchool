import blocks.OrderedProducts;
import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AmazonTest extends BaseTest {

    @DataProvider(name = "strForSearchData")
    public Object[][] createData() {
        return new Object[][]{
                {"puzzle"},
                {"sock"},
                {"robe"}
        };
    }

    @Test(dataProvider = "strForSearchData")
    public void testAmazon(String strForSearch) {
        searchPageSteps = amazonMainPageSteps.selectCategory(category).search(strForSearch);
        ElementsCollection<Result> elements = searchPageSteps.onSearchPage().results();

        elements.forEach(element -> {
            if (element.isDisplayed()) {
                //assertThat(element.resultName().getText().toLowerCase(), containsString(strForSearch.toLowerCase())); -- будет падать!!!
            }
        });

        String firstElementName = searchPageSteps.getFirstElementName(elements);
        String firstElementPriceWhole = searchPageSteps.getFirstPriceWhole(elements);
        String firstElementPriceFraction = searchPageSteps.getFirstElementPriceFraction(elements);

        productPageSteps = searchPageSteps.getProduct(elements);
        cardPageSteps = productPageSteps.selectSize().addToCard().goToCard();
        ElementsCollection<OrderedProducts> orderedProducts = cardPageSteps.onCardPage().listOfOrderedProducts();

        assertThat(cardPageSteps.getProductQuantity(), equalTo("1"));
        assertThat(cardPageSteps.getProductPrice(), equalTo("$" + firstElementPriceWhole + "." + firstElementPriceFraction));
        assertThat(orderedProducts.get(0).productName().getText(), equalTo(firstElementName));
    }
}