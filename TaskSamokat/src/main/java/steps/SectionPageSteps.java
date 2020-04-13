package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SectionPage;

import static matchers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static matchers.HasTextMatcher.hasText;
import static matchers.IsDisplayedMatcher.isDisplayed;
import static matchers.IsSelectedMatcher.isSelected;
import static org.hamcrest.Matchers.everyItem;

public class SectionPageSteps extends WebDriverSteps {

    public SectionPageSteps(WebDriver driver) {
        super(driver);
    }

    public SectionPage onSectionPage() {
        return onPage(SectionPage.class);
    }

    @Step
    public SectionPageSteps shouldSeeSectionName(String section) {
        onSectionPage().leftSection().sectionName().should(isDisplayed()).should(hasText(containsIgnoringCase(section)));
        return this;
    }

    @Step
    public SectionPageSteps shouldSeeDiscountSection() {
        onSectionPage().resultRroducts()
                .extract(result -> result.discount())
                .should(everyItem(isDisplayed()));
        return this;
    }

    @Step
    public SectionPageSteps shouldSeeSectionHeader(String section) {
        onSectionPage().sectionHeader().should(isDisplayed()).should(hasText(containsIgnoringCase(section)));
        return this;
    }

    @Step
    public SectionPageSteps shouldSeeSection(String[] subsections) {
        for (String subsection : subsections) {
            onSectionPage().leftSection().subSectionName(subsection).should(isDisplayed()).should(hasText(containsIgnoringCase(subsection)));
        }
        return this;
    }

    @Step
    public SectionPageSteps shouldSeeResultName(String section) {
        onSectionPage().resultRroducts()
                .extract(result -> result.name())
                .should(everyItem(hasText(containsIgnoringCase(section.substring(0, section.length() - 1)))));
        return this;
    }

    @Step
    public SectionPageSteps openPage(int page) {
        onSectionPage().pagination().page(page).should(isDisplayed()).click();
        return new SectionPageSteps(driver);
    }

    @Step
    public SectionPageSteps openNextPage() {
        onSectionPage().pagination().nextPage().should(isDisplayed()).click();
        return new SectionPageSteps(driver);
    }

    @Step
    public SectionPageSteps openPrevPage() {
        onSectionPage().pagination().previousPage().should(isDisplayed()).click();
        return new SectionPageSteps(driver);
    }

    @Step
    public SectionPageSteps shouldSeePage(int page) {
        onSectionPage().pagination().page(page).should(isSelected());
        return new SectionPageSteps(driver);
    }

    @Step
    public SectionPageSteps shouldSeePageSection(String section, String[] arr) {
        shouldSeeSectionName(section);
        shouldSeeSection(arr);
        shouldSeeSectionHeader(section);
        shouldSeeResultName(section);
        return this;
    }
}