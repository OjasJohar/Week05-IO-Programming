package com.bridgelabz.practice_problem_2.generate_json_report_from_database;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeJSONReportTest {

    private static final String TEST_JSON_FILE = "src/main/resources/employee_report.json";
    private static final String SAMPLE_JSON_RESPONSE = """
        [
            {"id": 1, "name": "Leanne Graham", "email": "Sincere@april.biz", "address": {"city": "Gwenborough"}, "company": {"name": "Romaguera-Crona"}},
            {"id": 2, "name": "Ervin Howell", "email": "Shanna@melissa.tv", "address": {"city": "Wisokyburgh"}, "company": {"name": "Deckow-Crist"}}
        ]
        """;

    @BeforeEach
    void setUp() throws IOException {
        // Delete old test file
        Files.deleteIfExists(Paths.get(TEST_JSON_FILE));
    }

    @Test
    @DisplayName("Test JSON Report Generation")
    void testGenerateReport() {
        EmployeeJSONReportGenerator.generateReport(SAMPLE_JSON_RESPONSE);

        File jsonFile = new File(TEST_JSON_FILE);
        assertTrue(jsonFile.exists(), "JSON report file should be created.");
        assertTrue(jsonFile.length() > 0, "JSON file should not be empty.");

        try {
            String content = Files.readString(Paths.get(TEST_JSON_FILE));
            assertTrue(content.contains("Leanne Graham"), "JSON report should contain employee name.");
            assertTrue(content.contains("Ervin Howell"), "JSON report should contain second employee name.");
        } catch (IOException e) {
            fail("Error reading JSON file.");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_JSON_FILE));
    }
}