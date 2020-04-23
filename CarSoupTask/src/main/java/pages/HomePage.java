package pages;

import layout.FiltersBlock;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithMenu;

public interface HomePage extends WebPage, WithMenu, FiltersBlock {
    @FindBy("//button[contains(@class, 'advanced-search-btn')]")
    HtmlElement searchButton();
}
