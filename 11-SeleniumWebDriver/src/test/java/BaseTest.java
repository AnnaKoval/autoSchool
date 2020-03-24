import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        amazonMainPageSteps = new AmazonMainPageSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void stopDriver() {
        driver.quit();
    }
}
