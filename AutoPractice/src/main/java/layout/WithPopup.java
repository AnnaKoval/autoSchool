package layout;

import blocks.Popup;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithPopup {
    @FindBy("//*[@id='layer_cart']")
    Popup popup();
}
