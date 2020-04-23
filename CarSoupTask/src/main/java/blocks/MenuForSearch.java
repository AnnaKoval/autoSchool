package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface MenuForSearch extends AtlasWebElement<MenuForSearch> {
    @FindBy(".//span[contains(@class, '{{ value }}')]")
    HtmlElement selectMenu(@Param("value") String value);
}