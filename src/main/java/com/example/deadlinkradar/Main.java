package com.example.deadlinkradar;

public class Main {
    public static void main(String[] args) {
        String url = "https://example.com";
        int status = LinkChecker.check(url);

        System.out.println("URL: " + url);
        System.out.println("Status: " + status);

        if (status >= 400 || status == -1) {
            System.out.println("Result: BROKEN");
        } else {
            System.out.println("Result: WORKING");
        }
    }
}
