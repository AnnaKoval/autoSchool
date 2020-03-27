package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface HomePage extends WebPage {
    @FindBy("//ul[contains(@class,'product_list')]")
    ElementsCollection<Result> results();
}
