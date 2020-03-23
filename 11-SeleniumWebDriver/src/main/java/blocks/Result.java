package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result extends AtlasWebElement<Result> {
    @FindBy(".//div[contains(@class,'a-section')]//span[contains(@class, 'a-size-base-plus')]")
    AtlasWebElement resultName();

    @FindBy(".//div[contains(@class,'a-section')]//h2/a[contains(@class, 'a-text-normal')]")
    AtlasWebElement resultLink();

    @FindBy(".//div[contains(@class,'a-section')]//span[contains(@class, 'a-price-whole')]")
    AtlasWebElement resultPriceWhole();

    @FindBy(".//div[contains(@class,'a-section')]//span[contains(@class, 'a-price-fraction')]")
    AtlasWebElement resultPriceFraction();
}
