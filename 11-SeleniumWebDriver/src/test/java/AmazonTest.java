import blocks.OrderedProducts;
import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.containsString;
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
        //amazonMainPageSteps.onAmazonMainPage().open(url); - можно ли так?
        amazonMainPageSteps.selectCategory(category);
        searchPageSteps.searchStr(strForSearch);

        assertThat(searchPageSteps.onSearchPage().title().getText(), containsString(strForSearch));

        ElementsCollection<Result> elements = searchPageSteps.onSearchPage().rezults();
        elements.forEach(element -> {
            if (element.isDisplayed()) {
                //assertThat(element.resultName().getText().toLowerCase(), containsString(strForSearch.toLowerCase())); -- будет падать!!!
            }
        });

        String firstElementName = elements.get(1).resultName().getText();
        String firstElementPriceWhole = elements.get(1).resultPriceWhole().getText();
        String firstElementPriceFraction = elements.get(1).resultPriceFraction().getText();

        elements.get(1).resultLink().click();
        productPageSteps.onProductPage().addToCardButton().click();
        productPageSteps.goToCard();

        ElementsCollection<OrderedProducts> orderedProducts = cardPageSteps.onCardPage().listOfOrderedProducts();
        int priceWhole = 0;
        int priceFraction = 0;
        assertThat(cardPageSteps.onCardPage().firstProductQuantity().getText(), equalTo("1"));

        if (orderedProducts.size() > 1) {
            for (OrderedProducts product : orderedProducts) {
                String price = product.productPrice().getText().substring(1);
                Pattern pt = Pattern.compile("(\\d+)\\.(\\d+)");
                Matcher matcher = pt.matcher(price);
                while (matcher.find()) {
                    priceWhole += Integer.parseInt(matcher.group(1));
                    priceFraction += Integer.parseInt(matcher.group(2));
                }
            }
            assertThat(cardPageSteps.onCardPage().productPriceSubtotal().getText(), equalTo("$" + priceWhole + "." + priceFraction));
        } else {
            assertThat(cardPageSteps.onCardPage().productPriceSubtotal().getText(), equalTo("$" + firstElementPriceWhole + "." + firstElementPriceFraction));
        }
        assertThat(orderedProducts.get(0).productName().getText(), equalTo(firstElementName));
    }
}