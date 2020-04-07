package layout;

import blocks.Sort;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithSort {
    @FindBy("//ul[contains(@class, 'dropboxSort')]")
    Sort sort();

    @FindBy("//*[@id='content']/div[2]/a")
    HtmlElement sortLink();
}
