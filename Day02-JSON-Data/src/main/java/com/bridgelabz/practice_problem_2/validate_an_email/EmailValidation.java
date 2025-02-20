package com.bridgelabz.practice_problem_2.validate_an_email;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

public class EmailValidation {
    public static void main(String[] args) {
        // Define JSON schema as a string
        String schemaJson = "{"
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

        // Sample JSON input
        String jsonInput = "{ \"email\": \"test@example.com\" }";

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

            if (report.isSuccess()) {
                System.out.println("Valid email!");
            } else {
                System.out.println("Invalid email: " + report);
            }
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
