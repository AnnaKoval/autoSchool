package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface ProductPage extends WebPage, WithHeader {
    @FindBy("//*[@id=\"productTitle\"]")
    AtlasWebElement productName();

    @FindBy("//*[@id=\"priceblock_ourprice\"]")
    AtlasWebElement productPrice();

    @FindBy("//*[@id=\"add-to-cart-button\"]")
    AtlasWebElement addToCardButton();
}
