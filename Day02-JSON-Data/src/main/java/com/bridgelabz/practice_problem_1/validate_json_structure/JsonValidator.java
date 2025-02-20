package com.bridgelabz.practice_problem_1.validate_json_structure;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {
    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json); // Parses JSON; throws exception if invalid
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        System.out.println("Is valid JSON? " + isValidJson(json));
    }
}
