package pages;

import html.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CardPage extends WebPage {
    @FindBy("//span[@id='sc-subtotal-amount-activecart']/span[contains(@class, 'a-size-medium')]")
    HtmlElement productPriceSubtotal();

    @FindBy("//*[@id='a-autoid-0-announce']/span[@class='a-dropdown-prompt']")
    HtmlElement firstProductQuantity();

    @FindBy("//span[contains(@class, 'sc-product-title')]")
    HtmlElement productName();
}
