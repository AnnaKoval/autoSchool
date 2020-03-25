import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CardPageSteps;
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
        amazonMainPageSteps.selectCategory(category);
        SearchPageSteps searchPageSteps = new SearchPageSteps(driver);
        searchPageSteps.search(strForSearch).verifyTextOnTitle(strForSearch);

        ElementsCollection<Result> elements = searchPageSteps.getResultsOfSearch();
        searchPageSteps.verifyIsElementContainsStrForSearch(strForSearch, elements);
        String elementName = searchPageSteps.getNameOfResultElement(elements);
        String elementPrice = searchPageSteps.getPriceOfResultElement(elements);
        CardPageSteps cardPageSteps = new CardPageSteps(driver);

        for (int index = 0; index < elements.size(); index++) {
            if (elements.get(index).resultPrice().isDisplayed()) {
                cardPageSteps = searchPageSteps.getProduct(elements.get(index)).selectSize().addToCard().goToCard();
                break;
            }
        }

        cardPageSteps.verifyOneProductOrdered().verifyProductPrice(elementPrice).verifyElementName(elementName);
    }
}