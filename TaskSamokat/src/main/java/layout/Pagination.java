package layout;

import blocks.Page;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Pagination {
    @FindBy("//div[contains(@class, 'pagination')]")
    Page pagination();
}
