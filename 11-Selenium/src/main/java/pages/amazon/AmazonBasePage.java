package pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class AmazonBasePage implements Page {

    private String PAGE_URL = "https://www.amazon.com/";
    private WebDriver driver;
    private AmazonSerchArrow amazonSerchArrow;

    public AmazonBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public void openPage() {
        driver.get(PAGE_URL);
    }

    @Override
    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public void searchAmazon(String request) {
        amazonSerchArrow.search(request);
    }
}
