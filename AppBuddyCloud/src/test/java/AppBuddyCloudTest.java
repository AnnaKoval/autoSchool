import org.testng.annotations.Test;
import steps.AppBuddyCloud;

public class AppBuddyCloudTest extends BaseTest {

    @Test
    public void shouldBeSortedByName() {
        AppBuddyCloud appBuddyCloud = new AppBuddyCloud();
        String token = "Bearer " + appBuddyCloud.authorizationRequest(spec).getToken();
        appBuddyCloud.rowsShouldBeSortedByName(appBuddyCloud
                .getSortedAskRowsRequest(token)
                .getRows());
    }
}