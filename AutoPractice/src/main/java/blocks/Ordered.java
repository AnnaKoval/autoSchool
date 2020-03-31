package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Ordered extends AtlasWebElement<Ordered> {
    @FindBy(".//span[contains(@class, 'price')]//span")
    HtmlElement productPrice();

    @FindBy(".//td[contains(@class, 'cart_description')]")
    Description description();

    @FindBy(".//a[contains(@title, 'Delete')]")
    HtmlElement deleteButton();

    @FindBy(".//input[contains(@class, 'cart_quantity_input')]")
    HtmlElement quantity();
}
