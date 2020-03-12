import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiForMavenTest {

    @Test
    public void testAmazon() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        WebElement goButton = driver.findElement(By.xpath("//input[@value='Go']"));

        searchField.sendKeys("puzzle");
        goButton.click();

        assert (driver.getTitle().contains("puzzle"));
        driver.quit();
    }

    @Test
    public void testApple() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pn.com.ua");

        WebElement cellPhone = driver.findElement(By.xpath("//*[@id='column-center']/section/div[2]/ul/li[1]/a"));
        cellPhone.click();
        WebElement appleFilter = driver.findElement(By.xpath("//*[@id='producers-filter-block']//a[text()='Apple']"));
        appleFilter.click();
        WebElement searchResultTitle = driver.findElement(By.xpath("//*[@id='column-center']/section/div[3]//div[@class='catalog-block-head']/a"));

        assert (driver.getTitle().contains("Apple"));
        assert (searchResultTitle.getText().contains("Apple iPhone"));
        driver.quit();
    }
}
