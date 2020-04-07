package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result extends AtlasWebElement<Result> {
    @FindBy(".//b")
    HtmlElement price();

    @FindBy(".//p")
    HtmlElement isAvailable();

    @FindBy(".//h3/a")
    HtmlElement name();
}
