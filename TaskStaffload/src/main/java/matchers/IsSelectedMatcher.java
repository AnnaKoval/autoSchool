package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class IsSelectedMatcher extends TypeSafeMatcher<WebElement> {

    public void describeTo(Description description) {
        description.appendText("Web element is selected");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("element ")
                .appendValue(element)
                .appendText(" is not selected on page");
    }

    @Factory
    public static IsSelectedMatcher isSelected() {
        return new IsSelectedMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement page) {
        try {
            if (page.isSelected())
                return true;
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}