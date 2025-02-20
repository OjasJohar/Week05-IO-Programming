package com.bridgelabz.practice_problem_2.convert_csv_data_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CsvToJsonConverterTest {

    private static final String TEST_CSV_FILE = "src/test/resources/test_data.csv";

    @Test
    void testReadCsv() throws IOException {
        // Create test CSV file
        createTestCsv(TEST_CSV_FILE);

        // Read CSV data
        List<Map<String, String>> data = CsvToJsonConverter.readCsv(TEST_CSV_FILE);

        // Expected Data
        List<Map<String, String>> expectedData = new ArrayList<>();
        Map<String, String> row1 = new LinkedHashMap<>();
        row1.put("Name", "Alice");
        row1.put("Age", "25");
        row1.put("City", "New York");
        expectedData.add(row1);

        Map<String, String> row2 = new LinkedHashMap<>();
        row2.put("Name", "Bob");
        row2.put("Age", "30");
        row2.put("City", "Los Angeles");
        expectedData.add(row2);

        // Validate CSV parsing
        assertEquals(expectedData, data);
    }

    @Test
    void testConvertToJson() throws IOException {
        // Create sample data
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> row1 = new LinkedHashMap<>();
        row1.put("Name", "Alice");
        row1.put("Age", "25");
        row1.put("City", "New York");
        data.add(row1);

        Map<String, String> row2 = new LinkedHashMap<>();
        row2.put("Name", "Bob");
        row2.put("Age", "30");
        row2.put("City", "Los Angeles");
        data.add(row2);

        // Convert to JSON
        String jsonOutput = CsvToJsonConverter.convertToJson(data);

        // Convert expected data to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String expectedJson = objectMapper.writeValueAsString(data);

        // Validate JSON conversion
        assertEquals(expectedJson, jsonOutput.trim());
    }

    // Helper method to create a test CSV file
    private void createTestCsv(String filePath) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Name,Age,City\n");
            writer.write("Alice,25,New York\n");
            writer.write("Bob,30,Los Angeles\n");
        }
    }
}
