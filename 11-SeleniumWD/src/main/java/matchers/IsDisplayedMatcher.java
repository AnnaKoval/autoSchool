package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

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
        return categories.isDisplayed();
    }

}