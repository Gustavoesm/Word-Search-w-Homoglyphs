package application.src.impl;

import application.src.impl.exceptions.PageReadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class HTMLPageReader {
    private HTMLPageReader() {
    }

    public static BufferedReader readPage(URL url) throws PageReadingException {
        try {
            Reader reader = new InputStreamReader(url.openStream());
            return new BufferedReader(reader);
        } catch (IOException e) {
            throw new PageReadingException("There was a problem loading the page.");
        }
    }
}