import org.testng.annotations.Test;

public class TestStaffload extends BaseTest {
    @Test
    public void testStaffload() {
        homePageSteps.login("koval.a", "Life3355")
                .selectFilter("Апрель")
                .shouldSeeReports();
    }
}