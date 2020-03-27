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
                .shouldContainTextOnTitle(strForSearch)
                .shouldContainsStrForSearch(strForSearch);

        int index = searchPageSteps.getResultWithPrice();
        String elementName = searchPageSteps.getNameOfResultElement(index);
        String elementPrice = searchPageSteps.getPriceOfResultElement(index);

        searchPageSteps
                .getElementProductPage(index)
                .selectSize()
                .addToCard()
                .goToCard()
                .shouldContainProductPrice(elementPrice)
                .shouldContainElementName(elementName)
                .shouldContainOneProductOrdered();
    }
}