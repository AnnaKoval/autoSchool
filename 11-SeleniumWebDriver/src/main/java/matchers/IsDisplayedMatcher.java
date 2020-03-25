package matchers;

import blocks.Select;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class IsDisplayedMatcher extends TypeSafeMatcher<Select> {

    public void describeTo(Description description) {
        description.appendText("a displayed web element");
    }

    @Factory
    public static IsDisplayedMatcher isDisplayedMatcher() {
        return new IsDisplayedMatcher();
    }

    @Override
    protected boolean matchesSafely(Select categories) {
        try {
            return categories.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

}