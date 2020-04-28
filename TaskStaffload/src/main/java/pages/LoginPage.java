package pages;

import layout.ReportFilter;
import elem.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface LoginPage extends WebPage, ReportFilter {
    @FindBy("//*[@id='user_login']")
    HtmlElement login();

    @FindBy("//*[@id='user_pass']")
    HtmlElement password();

    @FindBy("//*[@id='loginButton']")
    HtmlElement loginButton();
}
