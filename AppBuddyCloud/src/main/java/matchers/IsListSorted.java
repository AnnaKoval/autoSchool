package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IsListSorted extends TypeSafeMatcher<List<String>> {

    @Override
    public final void describeTo(final Description description) {
        description
                .appendText("List is sorted");
    }

    @Override
    protected boolean matchesSafely(List<String> list) {
        List tmp = new ArrayList(list);
        Collections.sort(tmp);
        return tmp.equals(list);
    }

    @Factory
    public static Matcher<List<String>> isSorted() {
        return new IsListSorted();
    }
}
