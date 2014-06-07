package srm621.round1.division2.level1;

/**
 * Sasha has a String[] stringList. No two elements of stringList have the same length.
 * So far, Sasha has learned two ways of sorting strings:
 * He can sort strings lexicographically. For example, "car" < "carriage" < "cats" < "doggies". (See Notes for a definition of the lexicographic order.)
 * He can also sort strings according to their lengths in ascending order. For example, "car" < "cats" < "doggies" < "carriage".
 * Sasha now wonders whether stringList is sorted in either of these two ways. Return "lexicographically" (quotes for clarity) if stringList is sorted lexicographically but not according to the string lengths. Return "lengths" if stringList is sorted according to the string lengths but not lexicographically. Return "both" if it is sorted in both ways. Otherwise, return "none".
 */
public class TwoWaysSorting {
    public String sortingMethod(String[] stringList) {
        boolean lengthSorted = true;
        boolean lexiSorted = true;
        String prev = "";
        for (String s : stringList)
        {
            if (s.length() < prev.length())
            {
                lengthSorted = false;
                break;
            }
            prev = s;
        }
        prev = "";
        for (String s : stringList) {
            if (s.compareTo(prev) < 0) {
                lexiSorted = false;
                break;
            }
            prev = s;
        }
        if (lengthSorted && lexiSorted)
            return "both";
        else if (lengthSorted)
            return "lengths";
        else if (lexiSorted)
            return "lexicographically";
        else
            return "none";
    }
}
