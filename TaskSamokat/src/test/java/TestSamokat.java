import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.SectionPageSteps;

public class TestSamokat extends BaseTest {

    @DataProvider(name = "sectionData")
    public static Object[][] testData() {
        return new Object[][]{
                {"Самокаты", new String[]{"Детские самокаты", "Самокаты для взрослых", "Электросамокаты", "Трюковые и экстрим самокаты"}},
                {"Трюковые самокаты", new String[]{"Трюковые начального уровня", "Трюковые среднего уровня"}},
                {"Запчасти  трюковых самокатов", new String[]{"Колеса", "Грипсы", "Зажимы", "Рули"}},
                {"Беговелы", new String[]{"Беговелы для детей от 1 года", "Беговелы для детей от 1,5 года", "Беговелы для детей от 2 лет", "Беговелы для детей от 3 лет"}},
                {"Велосипеды", new String[]{"Детские велосипеды", "Горные велосипеды (MTB)", "Городские велосипеды", "BMX и экстрим велосипеды", "Шоссейные велосипеды"}},
                {"Скейтборды", new String[]{"Пенниборды", "Круизеры", "Лонгборды", "Рипстики (вейвборды)", "Скейтборды классические"}}
        };
    }

    @DataProvider(name = "Pagination")
    public static Object[][] testDataPagination() {
        return new Object[][]{
                {"Беговелы",
                        new String[]{"Беговелы для детей от 1 года",
                                "Беговелы для детей от 1,5 года",
                                "Беговелы для детей от 2 лет",
                                "Беговелы для детей от 3 лет"}}
        };
    }


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

    @Test(dataProvider = "sectionData")
    public void testSection(String section, String[] arr) {
        homePageSteps.selectSection(section)
                .shouldSeeSectionName(section)
                .shouldSeeSection(arr)
                .shouldSeeSectionHeader(section)
                .shouldSeeResultName(section);
    }

    @Test
    public void testDiscountSection() {
        homePageSteps.selectSection("Скидки")
                .shouldSeeDiscountSection()
                .shouldSeeSectionHeader("Скидки и Распродажи");
    }

    @Test(dataProvider = "Pagination")
    public void testPagination(String section, String[] arr) {
        SectionPageSteps sectionPageSteps = homePageSteps.selectSection(section);
        sectionPageSteps.shouldSeePageSection(section, arr)
                .shouldSeePage("/catalog/begovely/")
                .openPage("/catalog/begovely/?page=2")
                .shouldSeePage("/catalog/begovely/?page=2")
                .openPage("/catalog/begovely/?page=3")
                .shouldSeePage("/catalog/begovely/?page=3")
                .openPage("/catalog/begovely/?page=2")
                .shouldSeePage("/catalog/begovely/?page=2");
    }
}