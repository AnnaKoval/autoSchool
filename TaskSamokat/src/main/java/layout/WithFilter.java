package layout;

import blocks.FilterOptions;
import io.qameta.atlas.webdriver.extension.FindBy;


public interface WithFilter {
    @FindBy("//div[contains(@class, 'filter_box')]")
    FilterOptions filterOptions();
}