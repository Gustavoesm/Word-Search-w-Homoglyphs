package impl;

import java.util.Map;

import static impl.Homoglyphs.getHomoglyphsMap;
import static java.lang.Character.toUpperCase;

public class StringComparator {

    private StringComparator() {
        // static
    }

    public static boolean compareWithHomoglyphs(String text, String searchWord) {
        if (text == null || searchWord == null) {
            return false;
        }

        Map<Character, String> homoglyphs = getHomoglyphsMap();

        for (int index = 0; index < text.length(); index++) {
            char textChar = text.charAt(index);
            char wordChar = toUpperCase(searchWord.charAt(index));

            String letterHomoglyphs = homoglyphs.get(wordChar);
            if (!letterHomoglyphs.contains(String.valueOf(textChar))) {
                return false;
            }
        }

        return true;
    }
}