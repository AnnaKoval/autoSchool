package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class IsDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    public void describeTo(Description description) {
        description.appendText("Web element is displayed");
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("Web element is not displayed");
        super.describeMismatchSafely(item, mismatchDescription);
    }

    @Factory
    public static IsDisplayedMatcher isDisplayed() {
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