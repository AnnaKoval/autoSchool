package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import layout.FiltersBlock;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ResultPage extends WebPage, FiltersBlock {
    @FindBy("//div[contains(@data-params, '{{ value }}')]")
    HtmlElement filter(@Param("value") String value);

    @FindBy("//div[contains(@class, 'srp-card-list')]")
    ElementsCollection<Result> resultRroducts();
}