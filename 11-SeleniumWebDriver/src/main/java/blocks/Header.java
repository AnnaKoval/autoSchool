package blocks;

import html.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header {
    @FindBy(".//input[@id='twotabsearchtextbox']")
    HtmlElement searchInput();

    @FindBy(".//span[@id='nav-cart-count']")
    HtmlElement cardButton();
}
