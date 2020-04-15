package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Suggestions extends AtlasWebElement<Suggestions> {
    @FindBy("//div[@id='suggestions']/div[@data-keyword]")
    ElementsCollection<HtmlElement> suggestion();
}