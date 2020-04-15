import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static steps.AmazonAPI.getSuggestionsAPI;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() throws URISyntaxException {
        amazonMainPageSteps
                .selectCategory("Baby")
                .input("puzz")
                .shouldSeeSuggestions(getSuggestionsAPI()
                        .getSuggestions());
    }
}