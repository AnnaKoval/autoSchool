import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.StoreHomePageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected StoreHomePageSteps storeHomePageSteps;
    protected String url = "http://automationpractice.com";
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        storeHomePageSteps = new StoreHomePageSteps(driver);
    }

    @AfterTest
    public void stopDriver() {
        driver.quit();
    }
}
