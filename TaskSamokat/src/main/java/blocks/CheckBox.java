package blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface CheckBox {
    @FindBy("//a[contains(text(),'{{ value }}')]/parent::div")
    Option optionsBlock(@Param("value") String value);
}