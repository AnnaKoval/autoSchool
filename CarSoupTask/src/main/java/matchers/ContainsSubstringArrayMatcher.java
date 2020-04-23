package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ContainsSubstringArrayMatcher extends TypeSafeMatcher<String> {

    private final String[] subString;

    private ContainsSubstringArrayMatcher(final String[] subString) {
        this.subString = subString;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("containing substring " + subString);
    }

    @Factory
    public static Matcher<String> containsArray(final String[] subString) {
        return new ContainsSubstringArrayMatcher(subString);
    }

    @Override
    protected boolean matchesSafely(String actualString) {
        for(int i=0; i<subString.length;i++){
            if(actualString.contains(subString[i])){
                return true;
            }
        }
        return false;
    }
}