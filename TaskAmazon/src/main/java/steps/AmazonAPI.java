package steps;

import ListResource.AmazonResponse;
import io.qameta.allure.Step;
import org.apache.http.client.utils.URIBuilder;


import java.net.URISyntaxException;

import static com.jayway.restassured.RestAssured.given;

public class AmazonAPI {
    @Step
    public static AmazonResponse getSuggestionsAPI() throws URISyntaxException {
        URIBuilder ub = new URIBuilder("https://completion.amazon.com/api/2017/suggestions?session-id=133-1119860-3142414&customer-id=&request-id=5AZ2JXX655H87RMY0EGB&page-type=Search&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=baby-products-intl-ship&b2b=0&fresh=0&ks=86&event=onKeyPress&limit=11&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1586854203092");
        ub.addParameter("prefix", "puzz");
        String url = ub.toString();

        return given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().as(AmazonResponse.class);
    }
}
