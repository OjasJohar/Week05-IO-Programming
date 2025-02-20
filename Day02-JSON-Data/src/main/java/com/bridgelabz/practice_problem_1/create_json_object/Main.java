package com.bridgelabz.practice_problem_1.create_json_object;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Main {
    // Convert object to JSON
    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 20, Arrays.asList("Mathematics", "Computer Science", "Physics"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);
        System.out.println(json);
    }
}
