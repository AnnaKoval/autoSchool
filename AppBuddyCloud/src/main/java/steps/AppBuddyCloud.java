package steps;

import response.AppResponse;
import response.AuthorizationResp;
import response.RowsList;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.jayway.restassured.RestAssured.given;
import static matchers.IsListSorted.isSorted;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppBuddyCloud {
    @Step
    public AuthorizationResp authorizationRequest(RequestSpecification spec) {
        Map<String, String> auto = new HashMap<>();
        auto.put("email", "sf.qa+prod1904@appbuddy.com");
        auto.put("password", "Test@1234");

        return given().spec(spec)
                .body(auto)
                .when()
                .post("https://www.appbuddycloud.com/auth/local")
                .then()
                .statusCode(200)
                .extract().as(AuthorizationResp.class);
    }

    @Step
    public AppResponse getSortedAskRowsRequest(String token) {
        Map<String, Object> param = new HashMap<>();
        param.put("currentPage", 1);
        param.put("order", true);
        param.put("pageSize", 50);
        param.put("sortedField", "%7B%22id%22:1,%22label%22:%22Grid+Name%22,%22key%22:%22name%22,%22fieldForSort%22:%22%5Bview%5D.%5Bname%5D%22,%22dataType%22:%22LITERAL%22%7D");

        return given()
                .pathParams(param)
                .headers("Authorization", token)
                .when()
                .get("https://www.appbuddycloud.com/api/views/?{currentPage}&{order}&{pageSize}&{sortedField}")
                .then()
                .statusCode(200)
                .extract().as(AppResponse.class);
    }

    @Step
    public void rowsShouldBeSortedByName(List<RowsList> rows) {
        assertThat(rows.stream().map(row -> row.getName()).collect(Collectors.toList()), isSorted());
    }
}
