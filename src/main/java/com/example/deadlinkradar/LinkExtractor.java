package com.example.deadlinkradar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {

    public static List<String> extract(String url) {
        List<String> links = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .timeout(5000)
                    .get();

            for (Element element : document.select("a[href]")) {
                String link = element.absUrl("href");
                if (!link.isEmpty()) {
                    links.add(link);
                }
            }
        } catch (Exception e) {
            System.out.println("Could not read: " + url);
        }
        return links;
    }
}
