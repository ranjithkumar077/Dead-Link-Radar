package com.example.deadlinkradar;

import java.util.List;

public class DeadLinkScanner {

    public static void scan(String website) {
        List<String> links = LinkExtractor.extract(website);
        System.out.println("Total links: " + links.size());

        for (String link : links) {
            int status = LinkChecker.check(link);
            if (status >= 400 || status == -1) {
                System.out.println("BROKEN: " + link + " [" + status + "]");
            } else {
                System.out.println("OK: " + link + " [" + status + "]");
            }
        }
    }
}
