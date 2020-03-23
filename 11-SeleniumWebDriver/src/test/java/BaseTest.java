import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriverSteps webDriverSteps;
    protected AmazonMainPageSteps amazonMainPageSteps;
    protected SearchPageSteps searchPageSteps;
    protected String url = "https://www.amazon.com";
    protected ProductPageSteps productPageSteps;
    protected CardPageSteps cardPageSteps;
    protected String category = "Baby";
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
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

    @AfterTest
    public void stopDriver() {
        driver.quit();
    }
}
