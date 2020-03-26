package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class HasTextMatcher extends TypeSafeMatcher<WebElement> {
    private String value;
    private Matcher<String> m;

    public HasTextMatcher(String parameter) {
        value = parameter;
    }

    public HasTextMatcher(Matcher<String> m) {
        this.m = m;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Web element text should match: ")
                .appendValue(value);
    }

    @Factory
    public static Matcher<WebElement> hasTextMatcher(String parameter) {
        return new HasTextMatcher(parameter);
    }

    @Factory
    public static Matcher<WebElement> hasTextMatcher(Matcher<String> m) {
        return new HasTextMatcher(m);
    }

    @Override
    protected boolean matchesSafely(WebElement quantity) {
        if (m != null) {
            return m.matches(quantity.getText());
        }
        try {
            return quantity.getText().equals(value);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
