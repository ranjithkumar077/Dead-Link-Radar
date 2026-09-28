package com.example.deadlinkradar;

import java.net.HttpURLConnection;
import java.net.URI;

public class LinkChecker {

    public static int check(String url) {
        try {
            URI uri = URI.create(url);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            return connection.getResponseCode();
        } catch (Exception e) {
            return -1;
        }
    }
}
