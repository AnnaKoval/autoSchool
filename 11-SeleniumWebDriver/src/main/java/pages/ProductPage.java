package pages;

import blocks.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface ProductPage extends WebPage, WithHeader {
    @FindBy("//*[@id='add-to-cart-button']")
    HtmlElement addToCardButton();

    @FindBy("//*[@id='dropdown_selected_size_name']/span")
    HtmlElement selectButton();

    @FindBy("//li[contains(@class,'dropdownAvailable')]/a")
    HtmlElement sizeButton();

    @FindBy("//*[@id='buybox-see-all-buying-choices-announce']/..")
    HtmlElement buyingOptionsButton();

    @FindBy("//input[contains(@name, 'submit.addToCart')]")
    HtmlElement addToCardOptionButton();
}
