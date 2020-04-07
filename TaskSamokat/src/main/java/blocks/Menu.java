package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Menu extends AtlasWebElement<Menu> {
    @FindBy(".//*[contains(@href, '{{ value }}')]")
    HtmlElement selectMenu(@Param("value") String value);
}
