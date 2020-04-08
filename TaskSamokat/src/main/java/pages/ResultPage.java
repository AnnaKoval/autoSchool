package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.FeatureForm;
import layout.WithSort;

public interface ResultPage extends WebPage, WithSort, FeatureForm {
    @FindBy("//ul[@class='products']/li")
    ElementsCollection<Result> resultRroducts();
}
