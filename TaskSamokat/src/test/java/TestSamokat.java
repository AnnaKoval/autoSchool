import org.testng.annotations.Test;

public class TestSamokat extends BaseTest {

    @Test
    public void testSamokat() {
        homePageSteps.selectWomenCityBikes()
                .selectSortPriceAscending()
                .shouldSeeResultList()
                .shouldSortedByPrice()
                .inputPriceFilter(10000,10700)
                .selectFilter("Производитель:","pride")
                //.selectFilter("Диаметр колеса (дюймов):", "20")
                .shouldSeeFilteredProducts("pride", "20",10000, 10700);

    }
}