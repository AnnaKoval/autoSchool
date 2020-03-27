package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.IsEqual.equalTo;

public class HasTextMatcher extends TypeSafeMatcher<WebElement> {
    private Matcher<String> m;

    public HasTextMatcher(Matcher<String> m) {
        this.m = m;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Web element text does not match ");
    }

    @Factory
    public static Matcher<WebElement> hasText(String parameter) {
        return new HasTextMatcher(equalTo(parameter));
    }

    @Factory
    public static Matcher<WebElement> hasText(Matcher<String> m) {
        return new HasTextMatcher(m);
    }

    @Override
    protected boolean matchesSafely(WebElement quantity) {
        return m.matches(quantity.getText());
    }
}
