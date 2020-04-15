package steps;

import ListResource.SuggestionsList;
import blocks.HtmlElement;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

import java.util.List;
import java.util.stream.Collectors;

import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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
        assertThat(getKeyWordsList(), equalTo(getValuesList(suggestionsLists)));
    }

    @Step
    public ElementsCollection<String> getKeyWordsList() {
        return onAmazonMainPage().suggestion().extract(key -> key.getAttribute("data-keyword"));
    }

    @Step
    public List<String> getValuesList(List<SuggestionsList> suggestionsLists) {
        return suggestionsLists.stream().map(item -> item.getValue()).collect(Collectors.toList());
    }
}
