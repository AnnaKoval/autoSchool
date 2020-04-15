import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        amazonMainPageSteps
                .selectCategory("Baby")
                .input("puzz")
                .shouldSeeSuggestions(amazonMainPageSteps.getResponseAPI()
                        .getSuggestions());
    }
}