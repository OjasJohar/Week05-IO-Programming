package com.bridgelabz.practice_problem_1.merge_two_json_objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonMergeExampleTest {

    @Test
    void testMergingTwoJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON Strings
            String json1 = "{ \"name\": \"Alice\", \"age\": 25 }";
            String json2 = "{ \"city\": \"New York\", \"age\": 30 }"; // Overlapping key "age"

            // Convert to JsonNode
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge JSON objects
            ObjectNode mergedNode = (ObjectNode) node1.deepCopy();
            mergedNode.setAll((ObjectNode) node2);

            // Expected JSON result after merging
            String expectedJson = "{ \"name\": \"Alice\", \"age\": 30, \"city\": \"New York\" }";
            JsonNode expectedNode = objectMapper.readTree(expectedJson);

            // Validate merged JSON
            assertEquals(expectedNode, mergedNode);

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
