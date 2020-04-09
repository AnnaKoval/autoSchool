package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface CheckBoxOptions extends AtlasWebElement<CheckBoxOptions> {
    @FindBy("./div[contains(@class, '{{ value }}')]")
    Option selectOption(@Param("value") String value);
}