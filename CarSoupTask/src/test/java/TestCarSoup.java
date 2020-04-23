import org.testng.annotations.Test;

public class TestCarSoup extends BaseTest {
    @Test
    public void testarSoup() {
        homePageSteps.selectAdvancedSearch()
                .selectMakes("Alfa Romeo")
                .selectMakes("AMC")
                .selectModels("Stelvio")
                .selectModels("Giulia")
                .selectColor("Black")
                .selectColor("White")
                .selectCylinderCount("4 Cylinders")
                .advancedSearch()
                .shouldSeeSelectedBrandFilter("Alfa Romeo")
                .shouldSeeSelectedBrandFilter("AMC")
                .shouldSeeSelectedModelFilter("Stelvio_Alfa Romeo")
                .shouldSeeSelectedModelFilter("Giulia_Alfa Romeo")
                .shouldSeeSelectedColorFilter("Black")
                .shouldSeeSelectedColorFilter("White")
                .shouldSeeSelectedCylinderFilter(4)
                .shouldSeeResultList()
                .shouldSeeFilteredProductManufacturer("Alfa Romeo", "AMC")
                .shouldSeeFilteredProductModel("Stelvio", "Giulia")
                .shouldSeeFilteredProductColor("Black", "White")
                .shouldSeeFilteredProductCylinders("4 Cyl.");
    }
}