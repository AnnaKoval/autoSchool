package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface OrderedProducts extends AtlasWebElement<Rezult> {

    @FindBy("//span[@class=\"a-size-medium sc-product-title\"]")
    AtlasWebElement productName();
}