package com.bridgelabz.practice_problem_1.convert_java_objects_into_json_array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListToJsonArrayTest {

    @Test
    void testConvertingListToJsonArray() throws JsonProcessingException {
        // Arrange
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(people);

        // Act
        ListToJsonArray.convertingListTojsonArray(people);
        String actualJson = objectMapper.writeValueAsString(people);

        // Assert
        assertEquals(expectedJson, actualJson);
    }
}
