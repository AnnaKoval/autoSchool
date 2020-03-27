package layout;

import blocks.Popup;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WthPopup {
    @FindBy("//*[@id='layer_cart']")
    Popup popup();
}
