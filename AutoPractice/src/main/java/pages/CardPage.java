package pages;

import blocks.OrderedProduct;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CardPage extends WebPage {
    @FindBy("//*[@id='order-detail-content']")
    ElementsCollection<OrderedProduct> orderedProducts();
}
