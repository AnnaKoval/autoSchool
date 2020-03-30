package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Popup extends AtlasWebElement<Popup> {
    @FindBy(".//*[@id='layer_cart_product_title']")
    HtmlElement name();

    @FindBy(".//*[@id='layer_cart_product_attributes']")
    HtmlElement size();

    @FindBy(".//*[@id='layer_cart_product_quantity']")
    HtmlElement quantity();

    @FindBy(".//*[@id='layer_cart_product_price']")
    HtmlElement price();

    @FindBy(".//span[contains(@class, 'continue')]")
    HtmlElement continueButton();
}
