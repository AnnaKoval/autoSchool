import blocks.OrderedProducts;
import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AmazonTest extends BaseTest {
    @ValueSource(strings = {"puzzle", "sock", "robe"})
    @ParameterizedTest
    public void testAmazon(String strForSerch) {
        //amazonMainPageSteps.onAmazonMainPage().open(url); - можно ли так?
        amazonMainPageSteps.selectCategory(category);
        searchPageSteps.searchStr(strForSerch);

        assertThat(searchPageSteps.onSearchPage().title().getText(), containsString(strForSerch));

        ElementsCollection<Result> elements = searchPageSteps.onSearchPage().rezults();

        for (Result element:  elements) {
            if (element.isDisplayed()) {
                assertThat(element.resultName().getText(), containsString(strForAmazonPage));
            }
        }

        String firstElementName = elements.get(0).resultName().getText();
        String firstElementPrice = elements.get(0).resultPrice().getText();

        elements.get(0).resultLink().click();
        productPageSteps.onProductPage().addToCardButton().click();
        productPageSteps.goToCard();

        ElementsCollection<OrderedProducts> orderedProducts = cardPageSteps.onCardPage().listOfOrderedProducts();

        assertThat(orderedProducts.size(), equalTo(1));
        assertThat(orderedProducts.get(0).productName().getText(), equalTo(firstElementName));
        assertThat(cardPageSteps.onCardPage().firstProductQuantity().getText(), equalTo("1"));
        assertThat(cardPageSteps.onCardPage().productPriceSubtotal().getText(), equalTo(firstElementPrice));
    }
}