package pages;

import blocks.Select;
import blocks.Suggestions;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface AmazonMainPage extends WebPage, Suggestions, WithHeader {
    @FindBy("//*[@id='searchDropdownBox']")
    Select categories();
}
