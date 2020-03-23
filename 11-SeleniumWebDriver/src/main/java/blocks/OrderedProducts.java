package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface OrderedProducts extends AtlasWebElement<Result> {
    @FindBy("//*[@id='activeCartViewForm']//span[@class='a-list-item']/a/span")
    AtlasWebElement productName();

    @FindBy(".//div[contains(@class, 'sc-list-item')]//span[contains(@class, 'sc-product-price')]")
    AtlasWebElement productPrice();
}