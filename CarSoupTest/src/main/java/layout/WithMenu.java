package layout;

import blocks.MenuForSearch;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithMenu {
    @FindBy("//div[contains(@class, 'main-search-block-inner')]")
    MenuForSearch menuForSearch();
}
