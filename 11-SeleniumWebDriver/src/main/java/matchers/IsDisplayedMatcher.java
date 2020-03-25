package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class IsDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    public void describeTo(Description description) {
        description.appendText("a displayed web element");
    }

    @Factory
    public static IsDisplayedMatcher isDisplayedMatcher() {
        return new IsDisplayedMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement categories) {
        try {
            return categories.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}