package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface ProductPage extends WebPage, WithHeader {
    @FindBy("//*[@id='add-to-cart-button']")
    AtlasWebElement addToCardButton();

    @FindBy("//*[@id='dropdown_selected_size_name']/span")
    AtlasWebElement selectButton();

    @FindBy("//li[contains(@class,'dropdownAvailable')]/a")
    AtlasWebElement sizeButton();

    @FindBy("//*[@id='buybox-see-all-buying-choices-announce']/..")
    AtlasWebElement buyingOptionsButton();

    @FindBy("//input[contains(@name, 'submit.addToCart')]")
    AtlasWebElement addToCardOptionButton();
}
