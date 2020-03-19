import blocks.OrderedProducts;
import blocks.Rezult;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

// не успела добавить параметризацию
public class BaseTest {

    private WebDriverSteps webDriverSteps;
    private AmazonMainPageSteps amazonMainPageSteps;
    private SearchPageSteps searchPageSteps;
    private String strForAmazonPage = "puzzle";
    String url = "https://www.amazon.com";
    ProductPageSteps productPageSteps;
    CardPageSteps cardPageSteps;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        webDriverSteps = new WebDriverSteps();
        amazonMainPageSteps = new AmazonMainPageSteps();
        searchPageSteps = new SearchPageSteps();
        productPageSteps = new ProductPageSteps();
    }

    @Test
    public void testAmazon() {
        SearchPageSteps searchPageSteps = amazonMainPageSteps.selectCategory(url);
        searchPageSteps.searchStr(strForAmazonPage);
        assertThat(searchPageSteps.onSearchPage().title().getText(), containsString(strForAmazonPage));

        ElementsCollection<Rezult> elements = searchPageSteps.onSearchPage().rezults();
        java.util.Iterator<Rezult> i = elements.iterator();
        while (i.hasNext()) {
            Rezult element = i.next();
            if (element.isDisplayed()) {
                assertThat(element.rezultName().getText(), containsString(strForAmazonPage));
            }
        }
        String firstElementName = searchPageSteps.onSearchPage().firstElementName().getText();
        String firstElementPrice = searchPageSteps.onSearchPage().firstElementPrice().getText();

        productPageSteps = searchPageSteps.selectProduct();
        productPageSteps.onProductPage().addToCardButton();
        cardPageSteps = productPageSteps.goToCard();

        ElementsCollection<OrderedProducts> orderedProducts = cardPageSteps.onCardPage().listOfOrgeredProducts();

        assertThat(orderedProducts.size(), equalTo(1));
        assertThat(orderedProducts.get(0).productName().getText(), equalTo(firstElementName));
        assertThat(cardPageSteps.onCardPage().firstProductQuantity().getText(), equalTo("1"));
        assertThat(cardPageSteps.onCardPage().productPriceSubtotal().getText(), equalTo(firstElementPrice));
    }

    @After
    public void stopDriver() {
        webDriverSteps.driver.quit();
    }
}
