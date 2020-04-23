package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Option extends AtlasWebElement<Option> {
    @FindBy(".//span[contains(text(), '{{ value }}')]//preceding-sibling::span")
    HtmlElement option(@Param("value") String value);
}