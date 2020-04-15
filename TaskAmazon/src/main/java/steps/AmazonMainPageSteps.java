package steps;

import ListResource.AmazonResponse;
import ListResource.SuggestionsList;
import blocks.HtmlElement;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import pages.AmazonMainPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.jayway.restassured.RestAssured.given;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AmazonMainPageSteps extends WebDriverSteps {

    public static RequestSpecification spec;

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

    @Step
    public void setRequestSpecification() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY))
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS))
                .build();
    }

    @Step
    public AmazonResponse getResponseAPI() {
        return given()
                .spec(spec)
                .when()
                .get("https://completion.amazon.com/api/2017/suggestions?session-id=133-1119860-3142414&customer-id=&request-id=5AZ2JXX655H87RMY0EGB&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=baby-products-intl-ship&b2b=0&fresh=0&ks=86&prefix=puzz&event=onKeyPress&limit=11&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1586854203092")
                .then()
                .statusCode(200)
                .extract().as(AmazonResponse.class);
    }
}
