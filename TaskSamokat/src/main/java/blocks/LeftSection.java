package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface LeftSection extends AtlasWebElement<LeftSection> {
    @FindBy("./a")
    HtmlElement sectionName();

    @FindBy("//li[contains(@style, 'margin-left:5px')]//a[contains(@title, '{{ value }}')]")
    HtmlElement subSectionName(@Param("value") String value);
}