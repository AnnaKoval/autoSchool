package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result extends AtlasWebElement<Result> {
    @FindBy(".//a/span[contains(@class, 'a-size-base-plus')]")
    AtlasWebElement resultName();

    @FindBy(".//h2/a[contains(@class, 'a-text-normal')]")
    AtlasWebElement resultLink();

    @FindBy(".//span[contains(@class, 'a-price-whole')]")
    AtlasWebElement resultPriceWhole();

    @FindBy(".//span[contains(@class, 'a-price-fraction')]")
    AtlasWebElement resultPriceFraction();
}
