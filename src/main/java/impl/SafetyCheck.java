package impl;


import impl.exceptions.PageReadingException;
import impl.matchers.Matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import static impl.HTMLPageReader.readPage;

public class SafetyCheck {

    private final Matcher safetyTest;

    private SafetyCheck(Matcher safetyTest) {
        this.safetyTest = safetyTest;
    }

    public static SafetyCheck create(Matcher test) {
        return new SafetyCheck(test);
    }

    public boolean hasMatches(URL url) {
        try (BufferedReader reader = readPage(url)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (safetyTest.matches(line)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new PageReadingException("There was a problem loading the page.");
        }

        return false;
    }
}