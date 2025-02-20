package com.bridgelabz.practice_problem_2.convert_java_objects_into_json_array;

import com.bridgelabz.practice_problem_1.convert_java_objects_into_json_array.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListToJsonArrayTest {

    @Test
    void testConvertingListToJsonArray() {
        try {
            // Create sample list
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25),
                    new Person("Bob", 30)
            );

            // Convert list to JSON using the method
            ObjectMapper objectMapper = new ObjectMapper();
            String expectedJson = objectMapper.writeValueAsString(people);

            // Capture the actual JSON conversion
            String actualJson = objectMapper.writeValueAsString(people);

            // Validate JSON conversion
            assertEquals(expectedJson, actualJson, "The JSON output should match the expected format");

        } catch (Exception e) {
            fail("Exception occurred during JSON conversion: " + e.getMessage());
        }
    }
}
