package pages;

import blocks.Select;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AmazonMainPage extends WebPage {
    @FindBy("//*[@id='searchDropdownBox']")
    Select categories();
}
