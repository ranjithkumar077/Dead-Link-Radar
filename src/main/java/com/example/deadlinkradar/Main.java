package com.example.deadlinkradar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://example.com";
        List<String> links = LinkExtractor.extract(url);

        System.out.println("Extracted links from " + url + ":");
        for (String link : links) {
            System.out.println(link);
        }
    }
}
