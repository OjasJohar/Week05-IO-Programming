package com.bridgelabz.practice_problem_1.read_a_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void testReadingJson() {
        try {
            // Path to test JSON file
            String testFilePath = "src/main/resources/read_json_data.json";

            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(testFilePath));

            // Verify JSON structure and values
            assertNotNull(rootNode);
            assertTrue(rootNode.isArray());
            assertFalse(rootNode.isEmpty());

            // Validate first entry (assuming the test file contains at least one object)
            JsonNode firstNode = rootNode.get(0);
            assertNotNull(firstNode.get("name"));
            assertNotNull(firstNode.get("email"));

            String name = firstNode.get("name").asText();
            String email = firstNode.get("email").asText();

            // Example expected values (modify as per test file data)
            assertEquals("Alice", name);
            assertEquals("alice@example.com", email);

        } catch (IOException e) {
            fail("Exception occurred while reading JSON: " + e.getMessage());
        }
    }
}
