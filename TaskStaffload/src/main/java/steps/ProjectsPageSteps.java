package steps;

import elem.HtmlElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

import java.util.*;

import static matchers.IsDisplayedMatcher.isDisplayed;
import static matchers.IsSelectedMatcher.isSelected;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ProjectsPageSteps extends WebDriverSteps {

    public ProjectsPageSteps(WebDriver driver) {
        super(driver, "reports/index/projects");
    }

    public ProjectsPage onProjectsPage() {
        return onPage(ProjectsPage.class);
    }

    @Step
    public List<String> shouldSeeData() {
        List<String> listData = new ArrayList<>();
        onProjectsPage().data().should(hasSize(greaterThan(0)))
                .forEach(item -> listData.add(item.should(isDisplayed()).getText()));
        listData.add("Всего отчитано");
        listData.add("Всего подтверждено");
        return listData;
    }

    @Step
    public List<String> shouldSeeHours() {
        List<String> listHours = new ArrayList<>();
        onProjectsPage().hours().should(hasSize(greaterThan(0)))
                .forEach(item -> listHours.add(item.getText()));
        return listHours;
    }

    @Step
    public void shouldSeeReports() {
        HashMap<String, String> myHashMap = new LinkedHashMap<>();
        Iterator<String> i1 = shouldSeeData().iterator();
        Iterator<String> i2 = shouldSeeHours().iterator();
        while (i1.hasNext() && i2.hasNext()) {
            myHashMap.put(i1.next(), i2.next());
        }
        printAllReports(myHashMap);
    }

    @Step
    public void printAllReports(HashMap<String, String> myHashMap) {
        for (Map.Entry<String, String> entry : myHashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Step
    public ProjectsPageSteps selectFilter(String month) {
        HtmlElement filter= onProjectsPage().optionsFilter().option(month);
        filter.click();
        filter.should(isSelected());
        return this;
    }
}