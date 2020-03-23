package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface AmazonMainPage extends WebPage {
    @FindBy("//a[@aria-label='{{ category }}']")
    AtlasWebElement category(@Param("category") String text);
}
