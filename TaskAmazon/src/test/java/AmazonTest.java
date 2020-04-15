import org.testng.annotations.Test;

import static steps.AmazonAPI.getSuggestionsAPI;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazon() {
        amazonMainPageSteps
                .selectCategory("Baby")
                .input("puzz")
                .shouldSeeSuggestions(getSuggestionsAPI()
                        .getSuggestions());
    }
}