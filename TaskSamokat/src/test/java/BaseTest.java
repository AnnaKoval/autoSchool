import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.HomePageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected HomePageSteps homePageSteps;
    protected String url = "https://samokat.ua/";
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        homePageSteps = new HomePageSteps(driver);
    }

    @AfterTest
    public void stopDriver() {
        driver.quit();
    }
}
