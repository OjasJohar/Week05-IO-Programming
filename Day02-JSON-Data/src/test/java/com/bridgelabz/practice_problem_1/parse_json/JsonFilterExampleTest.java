package com.bridgelabz.practice_problem_1.parse_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JsonFilterExampleTest {

    @Test
    void testJsonFiltering() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String jsonString = "[{\"name\":\"John\",\"age\":22},"
                    + "{\"name\":\"Alice\",\"age\":30},"
                    + "{\"name\":\"Bob\",\"age\":27},"
                    + "{\"name\":\"Eve\",\"age\":24}]";

            // Parse JSON into List of Person objects
            List<Person> people = objectMapper.readValue(jsonString, new TypeReference<List<Person>>() {});

            // Apply filtering (age > 25)
            List<Person> filteredPeople = people.stream()
                    .filter(p -> p.age > 25)
                    .toList();

            // Expected filtered JSON
            String expectedJson = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":27}]";
            List<Person> expectedPeople = objectMapper.readValue(expectedJson, new TypeReference<List<Person>>() {});

            // Validate filtered results
            assertEquals(expectedPeople.toString(), filteredPeople.toString());

        } catch (JsonProcessingException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
