package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithFilter;
import layout.WithSort;

public interface ResultPage extends WebPage, WithSort, WithFilter {
    @FindBy("//ul[@class='products']/li")
    ElementsCollection<Result> resultRroducts();
}
