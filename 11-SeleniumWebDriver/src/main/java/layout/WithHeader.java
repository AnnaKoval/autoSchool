package layout;

import blocks.Header;
import blocks.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {
    @FindBy("//header[contains(@class,'nav-opt-sprite')]")
    Header header();

    @FindBy("//div[contains(@class, 'a-section')]/span[contains(@class,'a-color-state')]")
    HtmlElement title();
}
