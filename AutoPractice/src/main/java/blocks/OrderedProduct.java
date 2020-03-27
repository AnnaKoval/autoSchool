package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface OrderedProduct extends AtlasWebElement<OrderedProduct> {
    @FindBy(".//td[contains(@class, 'cart_description')]/p/a")
    HtmlElement productName();

    @FindBy(".//span[contains(@class, 'price')]//span")
    HtmlElement productPrice();

    @FindBy(".//td[contains(@class, 'cart_description')]//a[contains(text(), 'Size')]")
    HtmlElement productSize();

    @FindBy(".//a[contains(@title, 'Delete')]")
    HtmlElement deleteButton();
}
