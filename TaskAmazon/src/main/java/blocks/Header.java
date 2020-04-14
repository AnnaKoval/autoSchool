package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement<Header> {
    @FindBy(".//input[@id='twotabsearchtextbox']")
    HtmlElement searchInput();

}
