package html;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public interface ProductHtmlElement extends AtlasWebElement<HtmlElement> {
    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span[contains(@class, 'a-size-medium')]")
    public HtmlElement productPriceSubtotal = new HtmlElement();

    @FindBy(xpath = "//*[@id='a-autoid-0-announce']/span[@class='a-dropdown-prompt']")
    public HtmlElement firstProductQuantity= new HtmlElement();

    @FindBy(xpath = "//span[contains(@class, 'sc-product-title')]")
    public HtmlElement productName= new HtmlElement();
}
