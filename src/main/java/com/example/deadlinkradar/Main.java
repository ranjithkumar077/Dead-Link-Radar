package com.example.deadlinkradar;

public class Main {
    public static void main(String[] args) {
        String website = "https://example.com";
        System.out.println("Starting Dead Link Radar scan for: " + website);
        DeadLinkScanner.scan(website);
    }
}
