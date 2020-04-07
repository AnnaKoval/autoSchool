package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result extends AtlasWebElement<Result> {
    @FindBy("./div[contains(@class,'product_info')]//a[contains(@title, 'Велосипед')]")
    HtmlElement resultName();

    @FindBy(".//b")
    HtmlElement resultPrice();

}
