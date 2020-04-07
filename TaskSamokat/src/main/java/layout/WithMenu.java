package layout;

import blocks.Menu;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithMenu {
    @FindBy("//*[@id='left']")
    Menu menu();
}
