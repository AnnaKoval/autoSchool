import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazon.site.AmazonSite;

public class SiteBaseTest {

    private Atlas atlas;
    private WebDriver driver;

    @Before
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver, "https://www.amazon.com"));
    }

    @Test
    public void simpleAmazonTest() {
        onSite().onAmazonMainPage().open();
        onSite().onAmazonMainPage().category().click();
    }

    private AmazonSite onSite() {
        return atlas.create(driver, AmazonSite.class);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }

}
