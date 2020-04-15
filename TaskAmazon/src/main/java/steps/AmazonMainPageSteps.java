package steps;

import ListResource.SuggestionsList;
import blocks.HtmlElement;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.junit.Assert.assertTrue;

public class AmazonMainPageSteps extends WebDriverSteps {

    public AmazonMainPageSteps(WebDriver driver) {
        super(driver);
    }

    public AmazonMainPage onAmazonMainPage() {
        return onPage(AmazonMainPage.class);
    }

    @Step
    public AmazonMainPageSteps selectCategory(String category) {
        onAmazonMainPage().categories().selectByVisibleText(category);
        return this;
    }

    @Step
    public AmazonMainPageSteps input(String str) {
        HtmlElement searchInput = onAmazonMainPage().header().searchInput().should(isDisplayed());
        searchInput.sendKeys(str);
        return this;
    }

    @Step
    public void shouldSeeSuggestions(List<SuggestionsList> suggestionsLists) {
        List<String> keyWords = getKeyWordsList();
        List<String> values = getValuesList(suggestionsLists);
        assertTrue(keyWords.stream().collect(groupingBy(key -> key, counting()))
                .equals(values.stream().collect(groupingBy(val -> val, counting()))));
    }

    @Step
    public List<String> getKeyWordsList() {
        ElementsCollection<HtmlElement> suggestions = onAmazonMainPage().suggestion();
        List<String> keyWords = null;
        for (HtmlElement item : suggestions) {
            keyWords.add(item.getAttribute("data-keyword"));
            System.out.println(item.getAttribute("data-keyword"));
        }
        return keyWords;
    }

    @Step
    public List<String> getValuesList(List<SuggestionsList> suggestionsLists) {
        List<String> values = null;
        for (SuggestionsList item : suggestionsLists) {
            values.add(item.getValue());
        }
        return values;
    }
}
