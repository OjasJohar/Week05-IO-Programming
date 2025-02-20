package com.bridgelabz.practice_problem_2.validate_an_email;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidationTest {

    private final String schemaJson = "{"
            + "\"$schema\": \"http://json-schema.org/draft-07/schema#\","
            + "\"type\": \"object\","
            + "\"properties\": {"
            + "\"email\": {"
            + "\"type\": \"string\","
            + "\"format\": \"email\""
            + "}"
            + "},"
            + "\"required\": [\"email\"]"
            + "}";

    @Test
    void testValidEmail() {
        String validJson = "{ \"email\": \"test@example.com\" }";
        assertTrue(validateJson(validJson), "Valid email should pass validation");
    }

    @Test
    void testInvalidEmail() {
        String invalidJson = "{ \"email\": \"invalid-email\" }";
        assertFalse(validateJson(invalidJson), "Invalid email should fail validation");
    }

    @Test
    void testMissingEmailField() {
        String missingFieldJson = "{ }";
        assertFalse(validateJson(missingFieldJson), "Missing email field should fail validation");
    }

    private boolean validateJson(String jsonInput) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON Schema and JSON data
            JsonNode schemaNode = objectMapper.readTree(schemaJson);
            JsonNode jsonData = objectMapper.readTree(jsonInput);

            // Create JSON Schema Factory
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema = schemaFactory.getJsonSchema(schemaNode);

            // Validate JSON data
            ProcessingReport report = jsonSchema.validate(jsonData);

            return report.isSuccess();
        } catch (Exception e) {
            fail("Exception during validation: " + e.getMessage());
            return false;
        }
    }
}
