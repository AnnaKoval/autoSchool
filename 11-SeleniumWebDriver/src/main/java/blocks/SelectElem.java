package blocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface SelectElem extends AtlasWebElement<SelectElem> {
//    @FindBy("//a[@aria-label='{{ category }}']")
//    AtlasWebElement category(@Param("category") String text);

    @FindBy("//*[@id='searchDropdownBox']")
    AtlasWebElement categories();

    default void selectItem(String category) {
        WebElement selectElem = categories();
        Select select = new Select(selectElem);
        select.selectByVisibleText(category);
    }
}

