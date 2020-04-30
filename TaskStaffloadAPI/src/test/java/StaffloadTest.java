import org.testng.annotations.Test;
import steps.Staffload;

public class StaffloadTest {
    @Test
    public void shouldSeeProjectReports() {
        Staffload staffload = new Staffload();
        staffload.getProjectReports();
    }
}