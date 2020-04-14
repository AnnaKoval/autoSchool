import ListResource.AmazonResponse;
import ListResource.SuggestionsList;
import blocks.Suggestions;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static matchers.HasTextMatcher.hasText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        ElementsCollection<Suggestions> suggestions = amazonMainPageSteps
                .selectCategory("Baby")
                .input("puzz")
                .getSuggestionsCollection();

        for(Suggestions item:suggestions){
            System.out.println(item.getAttribute("data-keyword"));
        }

       /* AmazonResponse amazonResponse = given()
                .spec(spec)
                .when()
                .get("/api/2017/suggestions?session-id=133-1119860-3142414&customer-id=&request-id=5AZ2JXX655H87RMY0EGB&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=baby-products-intl-ship&b2b=0&fresh=0&ks=86&prefix=puzz&event=onKeyPress&limit=11&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1586854203092")
                .then()
                .statusCode(200)
                .extract().as(AmazonResponse.class);

        List<SuggestionsList> suggestionsLists= amazonResponse.getSuggestions();
        for(SuggestionsList item:suggestionsLists){
            assertThat(item.getValue(), equalToIgnoringCase("puzzles for adults"));
        }
//        elements.forEach(element -> {
//            element.resultName()
//                    should(hasText(containsString(strForSearch)));
//        });
        */
    }
}