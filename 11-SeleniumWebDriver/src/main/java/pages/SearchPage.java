package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy("//div[@data-index]")
    ElementsCollection<Result> results();
}
