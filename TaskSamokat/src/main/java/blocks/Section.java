package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Section extends AtlasWebElement<Section> {
    @FindBy(".//img[contains(@alt, '{{ value }}')]//ancestor::a")
    HtmlElement selectSection(@Param("value") String value);
}
