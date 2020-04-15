import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import steps.AmazonMainPageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AmazonMainPageSteps amazonMainPageSteps;
    protected String url = "https://www.amazon.com/";
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
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
