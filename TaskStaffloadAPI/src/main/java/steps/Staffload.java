package steps;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import io.qameta.allure.Step;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String resp = htmlPath.getString("html.body.div.div.div.div.div.div.div");

        Pattern patternData = Pattern.compile("(\\d{2}\\.\\d{2}\\.2020)");
        Matcher matcherData = patternData.matcher(resp);

        Pattern patternProject = Pattern.compile("(NIX - (\\D*))Всего");
        Matcher matcherProject = patternProject.matcher(resp);

        Pattern patternTime = Pattern.compile("\\D((\\d{1})\\.(\\d{2}))\\D");
        Matcher matcherTime = patternTime.matcher(resp);

        List<String> listProject = new ArrayList<>();
        while (matcherProject.find()) {
            listProject.add(matcherProject.group(1));
        }
        List<String> listTime = new ArrayList<>();
        while (matcherTime.find()) {
            listTime.add(matcherTime.group(1));
        }
        List<String> listData = new ArrayList<>();
        while (matcherData.find()) {
            listData.add(matcherData.group(1));
        }

        List<LinkedHashMap<String, String>> records = new LinkedList<>();
        for (int i = 0; i < listTime.size(); i++) {
            LinkedHashMap map = new LinkedHashMap();
            map.put(listProject.get(0), listTime.get(i));
            records.add(i, map);
        }

        LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<>();
        for (int i = 0; i < listData.size(); i++) {
            map.put(listData.get(i), records.get(i));
        }
        for (Map.Entry<String, LinkedHashMap<String, String>> item : map.entrySet()) {
            HashMap<String, String> m = item.getValue();
            for (Map.Entry<String, String> item1 : m.entrySet()) {
                System.out.println(item.getKey() + " - " + item1.getKey() + " - " + item1.getValue());
            }
        }
    }
}
