package pages;

import blocks.Result;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.LeftSectionBlock;

public interface SectionPage extends WebPage, LeftSectionBlock {
    @FindBy("//*[@id='content']/h1")
    HtmlElement sectionHeader();

    @FindBy("//ul[@class='products']/li")
    ElementsCollection<Result> resultRroducts();
}
