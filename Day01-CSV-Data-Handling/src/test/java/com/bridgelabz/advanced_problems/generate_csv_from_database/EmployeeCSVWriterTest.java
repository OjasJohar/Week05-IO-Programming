package com.bridgelabz.advanced_problems.generate_csv_from_database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeCSVWriterTest {

    private static final String CSV_FILE_PATH = "src/main/resources/database_employees.csv";

    @BeforeEach
    void setUp() {
        File file = new File(CSV_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteEmployeeDataToCSV() {
        String jsonResponse = "[{\"id\":1,\"name\":\"Leanne Graham\"}, {\"id\":2,\"name\":\"Ervin Howell\"}]";

        EmployeeCSVWriter.writeEmployeeDataToCSV(jsonResponse);

        File file = new File(CSV_FILE_PATH);
        assertTrue(file.exists(), "CSV file should be created");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            assertNotNull(header, "CSV header should not be null");
            assertTrue(header.contains("Employee ID"), "Header should contain 'Employee ID'");
            assertTrue(header.contains("Name"), "Header should contain 'Name'");

            String row = reader.readLine();
            assertNotNull(row, "CSV should contain data rows");
            assertTrue(row.contains("Leanne Graham"), "CSV row should contain 'Leanne Graham'");
        } catch (IOException e) {
            fail("IOException occurred while reading the CSV file: " + e.getMessage());
        }
    }
}
