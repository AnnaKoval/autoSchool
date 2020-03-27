package blocks;

import html.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result {
    @FindBy(".//a/span[contains(@class, 'a-size-base-plus')]")
    HtmlElement resultName();

    @FindBy(".//h2/a[contains(@class, 'a-text-normal')]")
    HtmlElement resultLink();

    @FindBy(".//span[contains(@class, 'a-offscreen')]")
    HtmlElement resultPrice();
}
