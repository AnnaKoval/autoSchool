import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.*;

import java.util.concurrent.TimeUnit;

public class srcBaseTest {

    protected WebDriverSteps webDriverSteps;
    protected AmazonMainPageSteps amazonMainPageSteps;
    protected SearchPageSteps searchPageSteps;
    protected String strForAmazonPage = "puzzle";
    protected String url = "https://www.amazon.com";
    protected ProductPageSteps productPageSteps;
    protected CardPageSteps cardPageSteps;
    protected String category = "Baby";
    protected WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        webDriverSteps = new WebDriverSteps(driver);
        amazonMainPageSteps = new AmazonMainPageSteps(driver);
        searchPageSteps = new SearchPageSteps(driver);
        productPageSteps = new ProductPageSteps(driver);
        cardPageSteps = new CardPageSteps(driver);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}
