package pages.pnPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PnBasePage implements pages.Page {

    private String PAGE_URL = "https://pn.com.ua";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='column-center']/section/div[2]/ul/li[1]/a")
    private WebElement cellPhone;

    @FindBy(xpath = "//*[@id='producers-filter-block']//a[text()='Apple']")
    private WebElement appleFilter;

    @FindBy(xpath = "//*[@id='column-center']/section/div[3]//div[@class='catalog-block-head']/a")
    private WebElement searchResultTitle;

    public PnBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(this.driver)), this);
    }

    @Override
    public void openPage() {
        driver.get(PAGE_URL);
    }

    @Override
    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public void findIphone() {
        cellPhone.click();
        appleFilter.click();
    }

    public String getTextSearchResultTitle() {
        return searchResultTitle.getText();
    }
}
