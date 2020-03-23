package pages;

import blocks.OrderedProducts;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CardPage extends WebPage {

    @FindBy("//*[@id='activeCartViewForm']/div[2]")
    ElementsCollection<OrderedProducts> listOfOrderedProducts();

    @FindBy("//span[@id='sc-subtotal-amount-activecart']/span[contains(@class, 'a-size-medium')]")
    AtlasWebElement productPriceSubtotal();

    @FindBy("//*[@id='a-autoid-0-announce']/span[@class='a-dropdown-prompt']")
    AtlasWebElement firstProductQuantity();
}
