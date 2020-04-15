import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import steps.AmazonMainPageSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static RequestSpecification spec;
    protected AmazonMainPageSteps amazonMainPageSteps;
    protected String url = "https://www.amazon.com";
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.HTML)
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY))
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS))
                .build();

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
