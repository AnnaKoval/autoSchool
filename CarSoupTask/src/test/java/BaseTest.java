import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.HomePageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected HomePageSteps homePageSteps;
    protected String url = "https://www.carsoup.com/?address=Young+America+MN";
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        homePageSteps = new HomePageSteps(driver);
    }

    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }
}
