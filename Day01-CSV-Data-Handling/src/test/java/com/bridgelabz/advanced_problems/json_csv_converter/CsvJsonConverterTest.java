package com.bridgelabz.advanced_problems.json_csv_converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class CsvJsonConverterTest {

    private static final String CSV_FILE_PATH = "src/main/resources/read_student.csv";
    private static final String JSON_FILE_PATH = "src/main/resources/json_student.json";
    private static final String CONVERTED_CSV_FILE_PATH = "src/main/resources/csv_students.csv";
    private static final String CONVERTED_JSON_FILE_PATH = "src/main/resources/read_student.json";

    @BeforeEach
    void setUp() {
        deleteFile(CSV_FILE_PATH);
        deleteFile(JSON_FILE_PATH);
        deleteFile(CONVERTED_CSV_FILE_PATH);
        deleteFile(CONVERTED_JSON_FILE_PATH);
    }

    private void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testConvertJsonToCsv() {
        String jsonResponse = "{ \"students\": [ { \"id\": 1, \"name\": \"John Doe\", \"age\": 20, \"marks\": 85 }, { \"id\": 2, \"name\": \"Jane Doe\", \"age\": 22, \"marks\": 90 } ] }";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_PATH))) {
            writer.write(jsonResponse);
        } catch (IOException e) {
            fail("IOException occurred while writing JSON file: " + e.getMessage());
        }

        JsonToCsvConverter.convertJsonToCsv();

        File csvFile = new File(CONVERTED_CSV_FILE_PATH);
        assertTrue(csvFile.exists(), "CSV file should be created");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String header = reader.readLine();
            assertNotNull(header, "CSV header should not be null");
            assertTrue(header.contains("ID"), "Header should contain 'ID'");
            assertTrue(header.contains("Name"), "Header should contain 'Name'");

            String row = reader.readLine();
            assertNotNull(row, "CSV should contain data rows");
            assertTrue(row.contains("John Doe"), "CSV row should contain 'John Doe'");
        } catch (IOException e) {
            fail("IOException occurred while reading the CSV file: " + e.getMessage());
        }
    }

    @Test
    void testConvertCsvToJson() {
        String csvContent = "ID,Name,Age,Marks\n1,John Doe,20,85\n2,Jane Doe,22,90";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.write(csvContent);
        } catch (IOException e) {
            fail("IOException occurred while writing CSV file: " + e.getMessage());
        }

        CsvToJsonConverter.convertCsvToJson();

        File jsonFile = new File(CONVERTED_JSON_FILE_PATH);
        assertTrue(jsonFile.exists(), "JSON file should be created");

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            String content = reader.readLine();
            assertNotNull(content, "JSON content should not be null");

        } catch (IOException e) {
            fail("IOException occurred while reading the JSON file: " + e.getMessage());
        }
    }
}
