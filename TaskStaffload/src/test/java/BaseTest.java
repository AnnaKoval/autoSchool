import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.LoginPageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected LoginPageSteps homePageSteps;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePageSteps = new LoginPageSteps(driver);
    }

    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }
}
