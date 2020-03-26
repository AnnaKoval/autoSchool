package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class HasTextMatcher<String> extends TypeSafeMatcher<WebElement> {
    private String value;

    public HasTextMatcher (String parameter) {
        value = parameter;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Quantity should match: ")
                .appendValue(value);
    }

    @Factory
    public HasTextMatcher hasTextMatcher(String parameter) {
        return new HasTextMatcher(parameter);
    }

    @Override
    protected boolean matchesSafely(WebElement quantity) {
        try {
            return quantity.getText().equals(value);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
