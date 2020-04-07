package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Sort extends AtlasWebElement<Sort> {
    @FindBy(".//a[@href='{{ value }}']")
    HtmlElement selectSort(@Param("value") String value);
}
