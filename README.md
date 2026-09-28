# 📡 Dead Link Radar

A high-performance web crawler and dead/broken link detection radar built with **Java 17**, **Spring Boot 3**, and **Jsoup**.

---

## 🧭 Architecture Flow

```
DEAD LINK RADAR
      │
      ▼ Enter website URL (e.g., https://example.com)
┌──────────────┐
│ Web Crawler  │ ──► Download HTML via Jsoup
└──────┬───────┘
       ▼
┌──────────────┐
│ LinkExtractor│ ──► Parse <a href="..."> tags & resolve absolute URLs
└──────┬───────┘
       ▼
┌──────────────┐
│ LinkChecker  │ ──► Issue HTTP HEAD requests with timeout safeguards
└──────┬───────┘
       ├────────────────────────┐
       ▼                        ▼
┌──────────────┐         ┌──────────────┐
│ Working (OK) │         │ Broken Links │
│ Status: 200  │         │ Status: 404, │
│ 301, 302     │         │ 403, 500, -1 │
└──────────────┘         └──────────────┘
       │                        │
       └───────────┬────────────┘
                   ▼
       📊 Output Scan Summary
```

---

## 🛠️ Technology Stack

- **Language:** Java 17 (tested & compatible up to Java 25 LTS)
- **Framework:** Spring Boot 3.4.x (Spring Web)
- **Build Tool:** Apache Maven (with Maven Wrapper `mvnw`)
- **HTML Parsing:** Jsoup 1.18.3
- **Testing:** JUnit 5 (Jupiter)

---

## 📂 Project Structure

```
Dead-Link-Radar/
├── .mvn/wrapper/                  # Maven wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/com/example/deadlinkradar/
│   │   │   ├── DeadLinkRadarApplication.java  # Spring Boot entry point
│   │   │   ├── DeadLinkScanner.java           # Extraction & check coordinator
│   │   │   ├── LinkChecker.java               # HTTP HEAD status verifier
│   │   │   ├── LinkExtractor.java             # Jsoup HTML parser & anchor extractor
│   │   │   └── Main.java                      # Standalone CLI runner / verification
│   │   └── resources/
│   │       └── application.properties         # App & server configuration
│   └── test/
│       └── java/com/example/deadlinkradar/
│           └── LinkCheckerTest.java           # Unit tests
├── mvnw / mvnw.cmd                            # Maven wrapper scripts
├── pom.xml                                    # Maven dependencies & build setup
└── README.md
```

---

## 🚀 Getting Started

### 1. Prerequisites
- **JDK 17+** installed (`java -version`)
- Git

### 2. Clone the Repository
```bash
git clone https://github.com/ranjithkumar077/Dead-Link-Radar.git
cd Dead-Link-Radar
```

### 3. Compile the Project
Using the included Maven wrapper (no separate Maven installation required):

```bash
# On Windows
.\mvnw.cmd compile

# On Linux/macOS
./mvnw compile
```

### 4. Run the Standalone Scanner MVP
```bash
# Compile and run via Java
.\mvnw.cmd test-compile
java -cp "target/classes;target/test-classes;%USERPROFILE%/.m2/repository/org/jsoup/jsoup/1.18.3/jsoup-1.18.3.jar" com.example.deadlinkradar.Main
```

Sample output:
```text
Starting Dead Link Radar scan for: https://example.com
Total links: 1
OK: https://iana.org/help/example-domains [200]
```

---

## 🗺️ Roadmap & Learning Milestones

- [x] **Phase 1: Project Setup & Baseline URL Checker**
  - Initialized Maven build with Spring Boot 3 & Java 17.
  - Built `LinkChecker.java` with fast HTTP `HEAD` requests and 5000ms timeouts.
- [x] **Phase 2: HTML Link Extraction with Jsoup**
  - Built `LinkExtractor.java` querying `a[href]` and resolving absolute URLs via `absUrl()`.
- [x] **Phase 3: Sequential Scanner Integration (MVP)**
  - Built `DeadLinkScanner.java` orchestrating extraction and link-by-link status verification.
- [ ] **Phase 4 & 5: Concurrency with Java `ExecutorService`**
  - Transition from sequential (blocking) scanning to concurrent thread pooling (`ExecutorService`, `Callable`, `Future`).
- [ ] **Phase 6: Deduplication & Domain Boundaries**
  - Use `HashSet` to avoid re-crawling URLs and stay scoped within the origin domain.
- [ ] **Phase 7: Multi-Page Recursive Crawling**
  - Deep crawl across internal pages up to a configurable max depth.
- [ ] **Phase 8: Spring Boot REST API**
  - Expose `POST /api/scan` and `GET /api/scan/{id}` for asynchronous scan jobs.
- [ ] **Phase 9: Interactive Frontend Dashboard**
  - Clean HTML/CSS/JavaScript UI with live scan progress, filters, and reports.
- [ ] **Phase 10: Scan History & Persistence**
  - Save previous scan sessions and analytics.
- [ ] **Phase 11: Containerization & Cloud Deployment**
  - Multi-stage Docker container build and cloud deployment.