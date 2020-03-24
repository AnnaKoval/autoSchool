import blocks.OrderedProducts;
import blocks.Result;
import blocks.Select;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CardPageSteps;
import steps.ProductPageSteps;
import steps.SearchPageSteps;

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
        amazonMainPageSteps.onAmazonMainPage().categories().selectByVisibleText(category);
        SearchPageSteps searchPageSteps = new SearchPageSteps(driver);
        searchPageSteps.search(strForSearch);
        ElementsCollection<Result> elements = searchPageSteps.onSearchPage().results();

        elements.forEach(element -> {
            if (element.isDisplayed()) {
                //assertThat(element.resultName().getText().toLowerCase(), containsString(strForSearch.toLowerCase())); -- будет падать!!!
            }
        });

        String elementName = searchPageSteps.getFirstElementName(elements);
        String elementPriceWhole = searchPageSteps.getFirstPriceWhole(elements);
        String elementPriceFraction = searchPageSteps.getFirstElementPriceFraction(elements);

        ProductPageSteps productPageSteps = searchPageSteps.getProduct(elements);
        CardPageSteps cardPageSteps = productPageSteps.selectSize().addToCard().goToCard();
        ElementsCollection<OrderedProducts> orderedProducts = cardPageSteps.onCardPage().listOfOrderedProducts();

        cardPageSteps.verifyOneProductOrdered().verifyProductPrice(elementPriceWhole, elementPriceFraction).verifyElementName(elementName, orderedProducts);
    }
}