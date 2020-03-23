package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement {

    @FindBy(".//*[@id='navbar']//input[@id='twotabsearchtextbox']")
    AtlasWebElement searchInput();

    @FindBy(".//*[@id='navbar']//span[@id='nav-cart-count']")
    AtlasWebElement cardButton();
}
