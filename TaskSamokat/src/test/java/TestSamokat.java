import org.testng.annotations.Test;

public class TestSamokat extends BaseTest {

    @Test
    public void testSamokat() {
        homePageSteps.selectWomenCityBikes()
                .selectSortPriceAscending()
                .shouldSeeResultList()
                .resultsShouldBeSortedByPrice()
                .inputPriceFilter(10000, 10700)
                .selectMake("pride")
                .selectWheel(20)
                .shouldSeeFilteredProducts("pride", 20, 10000, 10700);

    }
}