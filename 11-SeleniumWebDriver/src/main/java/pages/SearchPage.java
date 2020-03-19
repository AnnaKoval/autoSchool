package pages;

import blocks.Rezult;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface SearchPage extends WebPage, WithHeader {

    @FindBy("//div[@data-index and @class='sg-col-4-of-24 sg-col-4-of-12 sg-col-4-of-36 s-result-item sg-col-4-of-28 sg-col-4-of-16 sg-col sg-col-4-of-20 sg-col-4-of-32']")
    ElementsCollection<Rezult> rezults();

    @FindBy(".//span[@class='a-size-base-plus a-color-base a-text-normal']")
    AtlasWebElement title();

    @FindBy(".//div[@data-cel-widget='search_result_0']//a[@class='a-link-normal a-text-normal']")
    AtlasWebElement firstProduct();

    @FindBy(".//div[@data-cel-widget='search_result_0']//span[@class='a-offscreen']")
    AtlasWebElement firstElementPrice();

    @FindBy(".//div[@data-cel-widget='search_result_0']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    AtlasWebElement firstElementName();


}
