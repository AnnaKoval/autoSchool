package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface FilterPrice extends AtlasWebElement<FilterPrice> {
    @FindBy(". //*[@id='price_min']")
    HtmlElement priceMin();

    @FindBy(". //*[@id='price_max']")
    HtmlElement priceMax();

    @FindBy(". //input[contains(@class, 'button')]")
    HtmlElement submitButton();
}