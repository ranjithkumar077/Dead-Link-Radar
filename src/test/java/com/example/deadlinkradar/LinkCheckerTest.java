package com.example.deadlinkradar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkCheckerTest {

    @Test
    void testCheckValidUrl() {
        int status = LinkChecker.check("https://example.com");
        assertTrue(status >= 200 && status < 400, "Valid URL should return 2xx or 3xx status code");
    }

    @Test
    void testCheckInvalidUrl() {
        int status = LinkChecker.check("https://this-domain-should-definitely-not-exist-123456789.org");
        assertEquals(-1, status, "Non-existent domain should return -1");
    }
}
