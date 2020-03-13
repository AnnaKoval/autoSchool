package pages.amazon;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(className = "nav-searchbar")
public class AmazonSerchArrow extends HtmlElement {
    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    private TextInput searchField;

    @FindBy(xpath = "//input[@value='Go']")
    private Button goButton;

    public void search(String str) {
        searchField.sendKeys(str);
        goButton.click();
    }
}
