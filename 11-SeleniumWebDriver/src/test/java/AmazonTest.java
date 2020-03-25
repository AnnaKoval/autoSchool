import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
        SearchPageSteps searchPageSteps = amazonMainPageSteps
                .selectCategory(category)
                .search(strForSearch)
                .shoulContainTextOnTitle(strForSearch)
                .shouldContainsStrForSearch(strForSearch);

        ElementsCollection<Result> elements = searchPageSteps.getResultsCollection();
        String elementName = searchPageSteps.getNameOfResultElement(elements);
        String elementPrice = searchPageSteps.getPriceOfResultElement(elements);

        searchPageSteps
                .getResultWithPrice(elements)
                .selectSize()
                .addToCard()
                .goToCard()
                .shouldContainProductPrice(elementPrice)
                .shoulContainElementName(elementName)
                .shouldContainOneProductOrdered();
    }
}