package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement<Header> {
    @FindBy(".//*[@id='search_query_top']")
    HtmlElement searchInput();

    @FindBy(".//a[contains(@title, 'shopping cart')]")
    HtmlElement shoppingCart();
}
