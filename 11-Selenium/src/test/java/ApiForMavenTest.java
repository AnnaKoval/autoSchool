import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class ApiForMavenTest {

    private static RequestSpecification spec;

    @BeforeClass
    public static void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://pn.com.ua/")
                .addHeader("User-Agent", "Jmeter")
                .build();
    }

    @Test
    public void testFirst() throws JSONException {
        given().spec(spec)
                .when()
                .get("/ct/1232/?fo=693")
                .then()
                .statusCode(200);
    }

    @Test
    public void testSecond() throws JSONException {
        given().spec(spec)
                .when()
                .get("ct/1232/?fo=693-918")
                .then()
                .statusCode(200);
    }

    @Test
    public void testThird() throws JSONException {
        given().spec(spec)
                .when()
                .get("ct/1232/?fo=518-918-11214")
                .then()
                .statusCode(200);
    }

    @Test
    public void testFourth() throws JSONException {
        given().spec(spec)
                .when()
                .get("ct/1232/?fo=518-693-764-11214")
                .then()
                .statusCode(200);
    }
}
