package pages;

import blocks.Select;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface AmazonMainPage extends WebPage, WithHeader {
    @FindBy("//*[@id='searchDropdownBox']")
    Select categories();
}
