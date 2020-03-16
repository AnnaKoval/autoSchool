import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazon.AmazonMainPage;
import io.qameta.atlas.webdriver.extension.PageExtension;
import io.qameta.atlas.webdriver.AtlasWebElement;

public class BaseTest {

    private WebDriver driver;
    private Atlas atlas;
    private String strForAmazonPage = "puzzle";
    private AmazonMainPage amazonMainPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    @Test
    public void testAmazon() {
        onAmazonMainPage().open("https://www.amazon.com");
        onAmazonMainPage().category().click();
    }

    @After
    public void stopDriver() {
        this.driver.quit();
    }

    private AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
