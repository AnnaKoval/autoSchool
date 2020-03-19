package testRest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class TestAssured extends BaseTest {

    @DataProvider(name = "verifyAccessRequest")
    public Object[][] createData() {
        return new Object[][]{
                {"auto_mitsubishi_lancer_21990745.html"},
                {"auto_toyota_camry_22101863.html"},
                {"auto_bmw_520_21996828.html"},
                {"auto_nissan_leaf_22104675.html"},
                {"auto_nissan_leaf_22104647.html"},
                {"auto_mercedes_benz_e_220_21994701.html"},
                {"auto_lexus_nx_200_22083607.html"}
        };
    }


    @Test(dataProvider = "verifyAccessRequest")
    public void verifyAccessRequest(String additionalURL) {
        given().spec(spec)
                .when()
                .get(additionalURL)
                .then()
                .statusCode(200);
    }
}