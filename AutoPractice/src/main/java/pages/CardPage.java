package pages;

import blocks.Ordered;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CardPage extends WebPage {
    @FindBy("//tr[contains(@class, 'cart_item')]")
    ElementsCollection<Ordered> orderedProducts();

    @FindBy("//*[@id='total_product']")
    HtmlElement totalProductsPrice();

    @FindBy("//*[@id='total_price_container']")
    HtmlElement totalPrice();
}
