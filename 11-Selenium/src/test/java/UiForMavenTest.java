import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazon.AmazonBasePage;
import pages.pnPage.PnBasePage;

public class UiForMavenTest {

    private WebDriver webDriver;
    private AmazonBasePage amazonBasePage;
    private PnBasePage pnBasePage;
    private String strForAmazonPage = "puzzle";
    private String strForTitleOnPnPage = "Apple";
    private String getStrForRezultsTitleOnPnPage = "Apple iPhone";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        amazonBasePage = new AmazonBasePage(webDriver);
        pnBasePage = new PnBasePage(webDriver);
    }

    @Test
    public void testAmazon() {
        amazonBasePage.openPage();
        amazonBasePage.searchAmazon(strForAmazonPage);

        assert (webDriver.getTitle().contains(strForAmazonPage));
    }

    @Test
    public void testApple() {
        pnBasePage.openPage();
        pnBasePage.findIphone();

        assert (webDriver.getTitle().contains(strForTitleOnPnPage));
        assert (pnBasePage.getTextSearchResultTitle().contains(getStrForRezultsTitleOnPnPage));
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }
}
