package html;

import blocks.Select;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CardHtml extends WebPage {
    @FindBy("//*[@data-asin='B00XKDBD6O']")
    ProductHtmlElement orderedProducts();
}

