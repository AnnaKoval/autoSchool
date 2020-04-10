package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.IsEqual.equalTo;

public class HasIntegerMatcher extends TypeSafeMatcher<WebElement> {
    private Matcher<Integer> m;

    public HasIntegerMatcher(Matcher<Integer> m) {
        this.m = m;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Web element int matches ")
                .appendDescriptionOf(m);
    }

    @Factory
    public static Matcher<WebElement> hasInteger(Integer parameter) {
        return new HasIntegerMatcher(equalTo(parameter));
    }

    @Factory
    public static Matcher<WebElement> hasInteger(Matcher<Integer> m) {
        return new HasIntegerMatcher(m);
    }

    @Override
    protected boolean matchesSafely(WebElement elem) {
        return m.matches(Integer.valueOf(elem.getText().replace(" ", "")));
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("Integer of element ")
                .appendValue(item)
                .appendText(" does not match ")
                .appendValue(item.getText().replace(" ", ""));
    }
}
