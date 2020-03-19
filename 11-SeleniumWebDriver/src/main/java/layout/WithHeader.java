package layout;

import blocks.Header;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {

    @FindBy("//header[contains(@class,'nav-opt-sprite nav-locale-us nav-lang-en nav-ssl nav-unrec')]")
    Header header();

}
