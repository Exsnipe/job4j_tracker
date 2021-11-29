package collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originalText, String duplicateText) {
        String[] origin = originalText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        Set<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String word : duplicate) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
