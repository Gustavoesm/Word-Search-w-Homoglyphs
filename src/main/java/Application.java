import impl.SafetyCheck;
import impl.matchers.HomoglyphWordMatcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Project made by Gustavo Eugênio to attend Axur's Engineering Intern Test and adapted to Hackoon Space submissal.
 * Personal GitHub -> github.com/Gustavoesm.
 * <p>
 * This project should detect blacklisted words in the webpage stream given the correct url.
 * It should also detect "disguised words", that replaces common latin letters for their respective impl.Homoglyphs.
 * To have access to more information about or include further impl.Homoglyphs, check src/impl/impl.Homoglyphs.java.java.
 * To update the blacklisted words list, check challenge/BlacklistedWords.java.
 * <p>
 * The main class receives the page's URL as it's single argument, and returns any matches with "match" or "no match".
 */
public class Application {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL(args[0]);
        Collection<String> blacklist = Arrays.stream(args, 1, args.length).collect(Collectors.toList());

        SafetyCheck checker = SafetyCheck.create(HomoglyphWordMatcher.createInstanceFor(blacklist));
        if (checker.hasMatches(url)) {
            System.out.println("match");
        } else {
            System.out.println("no match");
        }
    }
}