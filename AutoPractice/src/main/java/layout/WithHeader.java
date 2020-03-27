package layout;

import blocks.Header;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {
    @FindBy("//header[@id='header']")
    Header header();
}
