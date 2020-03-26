package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;

public interface Select extends AtlasWebElement<Select> {
    default void selectByVisibleText(String text) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        select.selectByVisibleText(text);
    }
}

