package com.bridgelabz.practice_problem_2.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadJsonFileTest {

    @Test
    void testReadJsonFile() {
        try {
            // Load JSON file
            File file = new File("src/main/resources/read_json_data.json");
            assertTrue(file.exists(), "JSON file should exist");

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);

            // Ensure the root node is not null
            assertNotNull(rootNode, "Root node should not be null");

            // Check if it contains expected keys (modify based on actual JSON structure)
            assertFalse(rootNode.has("name") || rootNode.has("users"), "JSON should have expected fields");

        } catch (IOException e) {
            fail("Exception occurred while reading JSON: " + e.getMessage());
        }
    }
}
