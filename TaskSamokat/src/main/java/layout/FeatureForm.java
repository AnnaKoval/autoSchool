package layout;

import blocks.CheckBoxOptions;
import blocks.FilterPrice;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface FeatureForm {
    @FindBy("//div[@id='features']")
    FilterPrice filterPrice();

    @FindBy("//*[@id='features-form']")
    CheckBoxOptions checkboxOptions();
}