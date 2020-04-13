package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Page extends AtlasWebElement<Page> {
    @FindBy("./a[contains(text(), '{{ value }}')]")
    HtmlElement page(@Param("value") String value);
}
