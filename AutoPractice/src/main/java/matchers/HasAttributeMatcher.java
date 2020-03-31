package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HasAttributeMatcher extends TypeSafeMatcher<WebElement> {
    private String attribute;

    public HasAttributeMatcher(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Web element has " + attribute + " attribute.");
    }

    @Factory
    public static HasAttributeMatcher hasAttribute(String parameter) {
        return new HasAttributeMatcher(parameter);
    }

    @Override
    protected boolean matchesSafely(WebElement elem) {
        try {
            if (!elem.getAttribute(attribute).isEmpty())
                return true;
            else
                return false;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("Web element has no " + attribute + " attribute.");
    }
}
