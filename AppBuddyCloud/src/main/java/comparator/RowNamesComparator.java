package comparator;

import response.RowsList;

import java.util.Comparator;

public class RowNamesComparator implements Comparator<RowsList> {
    public int compare(RowsList a, RowsList b) {
        return a.getName().compareTo(b.getName());
    }
}