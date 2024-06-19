package application.src.impl.matchers;

import application.src.impl.StringComparator;

import java.util.Collection;

import static application.src.impl.StringComparator.compareWithHomoglyphs;

public class HomoglyphWordMatcher implements Matcher {

    private final Collection<String> blacklist;

    private HomoglyphWordMatcher(Collection<String> blacklist) {
        this.blacklist = blacklist;
    }

    public static HomoglyphWordMatcher createInstanceFor(Collection<String> blacklist) {
        return new HomoglyphWordMatcher(blacklist);
    }

    public boolean matches(String text) {
        for (String blacklistedWord : blacklist) {
            if (containsHomoglyphWord(text, blacklistedWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsHomoglyphWord(String text, String word) {
        int wordLength = word.length();
        int textLength = text.length();

        for (int index = 0; index <= textLength - wordLength; index++) {
            if (compareWithHomoglyphs(text.substring(index, index + wordLength), word)) {
                return true;
            }
        }
        return false;
    }
}
