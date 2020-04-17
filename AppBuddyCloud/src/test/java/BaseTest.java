import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static RequestSpecification spec;

    @BeforeTest
    public void setup() {
        spec = new RequestSpecBuilder()
                .setContentType("application/json; charset=utf-8")
                .build();
    }
}
