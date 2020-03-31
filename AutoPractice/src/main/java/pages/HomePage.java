package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface HomePage extends WebPage, WithHeader {
    @FindBy("//li[contains(@class, 'ajax_block_product')]")
    ElementsCollection<Result> results();
}
