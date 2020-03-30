package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Description extends AtlasWebElement<Description> {
    @FindBy("./p/a")
    HtmlElement productName();

    @FindBy(".//a[contains(text(), 'Size')]")
    HtmlElement productSize();
}
