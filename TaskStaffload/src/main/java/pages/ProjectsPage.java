package pages;

import elem.HtmlElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import layout.ReportFilter;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProjectsPage extends WebPage, ReportFilter {
    @FindBy("//th[contains(text(), '2020')]")
    ElementsCollection<HtmlElement> data();

    @FindBy("//th/span[@data-decimal-hours]")
    ElementsCollection<HtmlElement> hours();
}