package layout;

import blocks.Option;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface FiltersBlock {
    @FindBy("//span[contains(text(), '{{ value }}')]//following-sibling::div")
    Option optionsBlock(@Param("value") String value);
}
