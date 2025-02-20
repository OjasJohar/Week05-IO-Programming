package com.bridgelabz.practice_problem_2.filter_json_data_by_age;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FilterJsonByAgeTest {

    private final String jsonData = """
    {
        "users": [
            {"name": "Alice", "age": 24},
            {"name": "Bob", "age": 30},
            {"name": "Charlie", "age": 27},
            {"name": "David", "age": 22}
        ]
    }
    """;

    @Test
    void testFilteringJsonDataByAge() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the filtering method
        FilterJsonByAge.filteringJsonDataByAge(jsonData);

        // Restore System.out
        System.setOut(System.out);

        // Expected output for users older than 25
        String expectedOutput = """
        Users older than 25:
        Name: Bob, Age: 30
        Name: Charlie, Age: 27
        """;

        // Normalize output to remove platform-specific line breaks
        String actualOutput = outputStream.toString().trim().replace("\r\n", "\n");
        expectedOutput = expectedOutput.trim().replace("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput, "Filtered output should match expected output");
    }

//    @Test
//    void testInvalidJson() {
//        String invalidJson = "{ \"users\": [ { \"name\": \"John\", \"age\": ";
//
//        assertThrows(Exception.class, () -> FilterJsonByAge.filteringJsonDataByAge(invalidJson),
//                "Should throw an exception for invalid JSON format");
//    }

    @Test
    void testEmptyUsersArray() {
        String emptyJson = "{ \"users\": [] }";

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the filtering method
        FilterJsonByAge.filteringJsonDataByAge(emptyJson);

        // Restore System.out
        System.setOut(System.out);

        assertTrue(outputStream.toString().contains("Users older than 25:"),
                "Should output 'Users older than 25:' but no users should be listed");
    }
}
