package layout;

import blocks.FilterPrice;
import blocks.LeftSection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface LeftSectionBlock {
    @FindBy("//li[contains(@style, 'margin-left:5px')]")
    LeftSection leftSection();
}
