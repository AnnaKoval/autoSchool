package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class WebDriverSteps {
    public Atlas atlas;
    public WebDriver driver;
    protected String url = "https://staffload.nixsolutions.com/ru/";

    public WebDriverSteps(WebDriver driver, String url) {
        this.driver = driver;
        atlas = new Atlas(new WebDriverConfiguration(this.driver));
        this.url+=url;
        driver.get(this.url);
    }

    public <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
