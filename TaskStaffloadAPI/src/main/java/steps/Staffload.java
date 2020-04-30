package steps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import io.qameta.allure.Step;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.Reader;
import java.io.StringReader;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Staffload {
    @Step
    public void getProjectReports() {
        Response response = given()
                .accept(ContentType.HTML)
                .headers("Cookie", "_ga=GA1.2.1995288714.1586172393; _ym_d=1586172393; _ym_uid=1586172393348922731; _hjid=4805d0a5-6591-46e3-a2fe-0b478a27c7ca; __cfduid=df797266ef04c8f305aaff728759c2a991587406598; _pk_ses.1.7012=*; PHPSESSID=5ntb4okpato985hr0qks1jrgc1; _pk_id.1.7012=e109edf280f49ae3.1584533005.35.1588235831.1588235048.")
                .when()
                .get("https://staffload.nixsolutions.com/ru/reports/index/projects")
                .then().contentType(ContentType.HTML).extract()
                .response();
        assertThat(response.getStatusCode(), equalTo(200));
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        System.out.println(htmlPath.getString("html.body.div.div.div.div.div.div.div"));

    }
}
