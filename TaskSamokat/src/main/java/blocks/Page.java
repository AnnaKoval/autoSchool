package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Page extends AtlasWebElement<Page> {
    @FindBy("./a[text()= '{{ value }}']")
    HtmlElement page(@Param("value") int value);

    @FindBy("./a[@class= 'next_page_link']")
    HtmlElement nextPage();

    @FindBy("./a[@class= 'prev_page_link']")
    HtmlElement previousPage();
}