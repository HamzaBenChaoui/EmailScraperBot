package com.kaoba.emailbot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailScraper {
    public static Set<String> scrapeEmails(String url) throws IOException {
        Set<String> emails = new HashSet<>();
        Document doc = Jsoup.connect(url).get();
        String html = doc.html();

        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }
}
