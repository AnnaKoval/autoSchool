package layout;

import blocks.FilterPrice;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface FeatureForm {
    @FindBy("//div[@id='features']")
    FilterPrice filterPrice();
}
