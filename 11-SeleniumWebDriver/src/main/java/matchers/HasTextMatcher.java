package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class HasTextMatcher extends TypeSafeMatcher<String> {

    public void describeTo(Description description) {
        description.appendText("one product ordered");
    }

    @Factory
    public static HasTextMatcher hasTextMatcher(String text) {
        return new HasTextMatcher();
    }

    @Override
    protected boolean matchesSafely(String text) {
        return text == "1";
    }
}
