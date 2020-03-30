package pages;

import elem.HtmlElement;
import elem.Select;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;
import layout.WithPopup;

public interface ProductPage extends WebPage, WithHeader, WithPopup {
    @FindBy("//h1[contains(@itemprop, 'name')]")
    HtmlElement name();

    @FindBy("//input[@id='quantity_wanted']")
    HtmlElement quantity();

    @FindBy("//div[@id='uniform-group_1']")
    Select size();

    @FindBy("//button[@name='Submit']")
    HtmlElement addToCard();

    @FindBy("//*[@id='our_price_display']")
    HtmlElement price();
}
