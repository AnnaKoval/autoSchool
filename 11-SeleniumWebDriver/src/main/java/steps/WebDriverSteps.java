package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;

import org.openqa.selenium.WebDriver;

//????????????????????????????
public class WebDriverSteps {
    public Atlas atlas;
    public WebDriver driver;
    private WebPage page;

    public WebDriverSteps() {
        this.driver=driver;
        this.atlas = new Atlas(new WebDriverConfiguration(this.driver));
    }

    public <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
