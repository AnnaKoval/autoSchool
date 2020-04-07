import org.testng.annotations.Test;

public class TestSamokat extends BaseTest {

    @Test
    public void testSamokat() {
        homePageSteps.selectWomenCityBikes()
                .selectSortPriceAscending()
                .shouldSeeResultList()
                .shouldSeeSortedPrice()
                .selectFilter("pride")
                .selectFilter("20")
                .shouldSeeFilteredProducts("pride");

    }
}