package layout;

import blocks.FilterPrice;
import blocks.Section;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface SectionForm {
    @FindBy("//div[contains(@class, 'category_view_rozetka')]")
    Section sectionMenu();
}
