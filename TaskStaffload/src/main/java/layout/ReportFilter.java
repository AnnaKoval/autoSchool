package layout;

import blocks.Option;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ReportFilter {
    @FindBy("//*[@id='shift']")
    Option optionsFilter();
}
