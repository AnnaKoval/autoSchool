package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface FilterOptions extends AtlasWebElement<FilterOptions> {
    @FindBy(".//input[@value='{{ value }}']/following-sibling::span")
    HtmlElement selectOption(@Param("value") String value);

    @FindBy(". //*[@id='price_min']")
    HtmlElement priceMin();

    @FindBy(". //*[@id='price_max']")
    HtmlElement priceMax();

    @FindBy(". //input[contains(@class, 'button')]")
    HtmlElement submitButton();
}