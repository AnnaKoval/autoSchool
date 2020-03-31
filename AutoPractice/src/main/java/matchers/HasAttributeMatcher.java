package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HasAttributeMatcher extends TypeSafeMatcher<WebElement> {
    private String attribute;
    private String value;

    public HasAttributeMatcher(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("Web element has " + attribute + " attribute with value = "+ value);
    }

    @Factory
    public static HasAttributeMatcher hasAttribute(String parameter, String value) {
        return new HasAttributeMatcher(parameter, value);
    }

    @Override
    protected boolean matchesSafely(WebElement elem) {
        try {
            if (elem.getAttribute(attribute).equals(value))
                return true;
            else
                return false;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("Web element has no " + attribute + " attribute with value = "+value);
    }
}
