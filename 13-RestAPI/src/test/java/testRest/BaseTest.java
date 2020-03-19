package testRest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static RequestSpecification spec;

    @BeforeTest
    public static void setup() {
        spec = new RequestSpecBuilder()
                //.setContentType(ContentType.HTML)
                //.setContentType(ContentType.TEXT)
                .addHeader("ContentType", "TEXT/HTML")
                .addHeader("Content-Encoding", "gzip")
                .addHeader("User-Agent", "Jmeter")
                .setBaseUri("https://auto.ria.com/")
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS))
                .build();
    }
}