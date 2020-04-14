package layout;

import blocks.Header;
import blocks.HtmlElement;
import blocks.Suggestions;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

import java.util.List;

public interface WithHeader {
    @FindBy("//header[contains(@class,'nav-opt-sprite')]")
    Header header();

    @FindBy("//div[@id='suggestions']")
    ElementsCollection<Suggestions> suggestions();
}
