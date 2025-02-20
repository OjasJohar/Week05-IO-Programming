package com.bridgelabz.practice_problem_1.convert_java_objects_into_json_format;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarToJsonTest {

    @Test
    void testConvertingObjectToJson() {
        try {
            Car car = new Car("Toyota", "Corolla", 2023);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(car);

            String expectedJson = "{\"brand\":\"Toyota\",\"model\":\"Corolla\",\"year\":2023}";
            assertEquals(expectedJson, jsonString);

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
