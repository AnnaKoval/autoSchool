import ListResource.AmazonResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        AmazonResponse amazonResponse = given()
                .spec(spec)
                .when()
                .get("https://completion.amazon.com/api/2017/suggestions?session-id=133-1119860-3142414&customer-id=&request-id=5AZ2JXX655H87RMY0EGB&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=baby-products-intl-ship&b2b=0&fresh=0&ks=86&prefix=puzz&event=onKeyPress&limit=11&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1586854203092")
                .then()
                .statusCode(200)
                .extract().as(AmazonResponse.class);

        amazonMainPageSteps
                .selectCategory("Baby")
                .input("puzz")
                .shouldSeeSuggestions(amazonResponse.getSuggestions());
    }
}