package pages;

import blocks.Result;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
public interface ResultPage extends WebPage {

    @FindBy("//ul[contains(@class, 'product')]/li")
    ElementsCollection<Result> resultRroducts();

}
