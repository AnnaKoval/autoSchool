package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CheckBoxOptions extends AtlasWebElement<CheckBoxOptions> {
    @FindBy(".//div[contains(@class, 'filter_box')]")
    Option selectOption();
}