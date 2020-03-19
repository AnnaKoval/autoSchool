package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Rezult extends AtlasWebElement<Rezult> {

    @FindBy("//title[contains(text(), 'Amazon')]")
    AtlasWebElement title();

    @FindBy("//title[contains(text(), 'Amazon')]")
    AtlasWebElement rezultName();
}
