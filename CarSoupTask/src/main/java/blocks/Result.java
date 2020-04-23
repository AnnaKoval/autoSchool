package blocks;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Result extends AtlasWebElement<Result> {
    @FindBy(".//i[contains(@class, 'icon-engine')]/parent::li")
    HtmlElement cylinderCount();

    @FindBy(".//span[contains(@class, 'tracked-srp-card-title')]")
    HtmlElement name();

    @FindBy(".//i[contains(@class, 'icon-exterior')]/parent::li")
    HtmlElement color();
}
