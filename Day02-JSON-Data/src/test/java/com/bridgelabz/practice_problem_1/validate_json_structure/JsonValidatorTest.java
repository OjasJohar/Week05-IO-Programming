package com.bridgelabz.practice_problem_1.validate_json_structure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonValidatorTest {

    @Test
    void testValidJson() {
        String validJson = "{ \"name\": \"John\", \"age\": 30 }";
        assertTrue(JsonValidator.isValidJson(validJson), "Expected valid JSON to return true");
    }

    @Test
    void testInvalidJson() {
        String invalidJson = "{ \"name\": \"John\", \"age\": 30 "; // Missing closing brace
        assertFalse(JsonValidator.isValidJson(invalidJson), "Expected invalid JSON to return false");
    }

    @Test
    void testEmptyJson() {
        String emptyJson = "";
        assertTrue(JsonValidator.isValidJson(emptyJson), "Expected empty JSON to return false");
    }

    @Test
    void testNullJson() {
        assertFalse(JsonValidator.isValidJson(null), "Expected null JSON to return false");
    }
}
