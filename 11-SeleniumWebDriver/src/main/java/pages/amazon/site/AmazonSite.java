package pages.amazon.site;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.*;
import pages.amazon.AmazonMainPage;

/**
 * Point of testing WebSite.
 */
public interface AmazonSite extends WebSite {

    @Page
    AmazonMainPage onAmazonMainPage();

}
