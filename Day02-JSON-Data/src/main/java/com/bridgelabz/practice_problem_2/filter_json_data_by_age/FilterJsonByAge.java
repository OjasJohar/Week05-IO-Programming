package com.bridgelabz.practice_problem_2.filter_json_data_by_age;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJsonByAge {

    public static void filteringJsonDataByAge(String jsonData){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode users = rootNode.get("users");

            System.out.println("Users older than 25:");
            for (JsonNode user : users) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println("Name: " + user.get("name").asText() + ", Age: " + age);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String jsonData = """
        {
            "users": [
                {"name": "Alice", "age": 24},
                {"name": "Bob", "age": 30},
                {"name": "Charlie", "age": 27},
                {"name": "David", "age": 22}
            ]
        }
        """;

        filteringJsonDataByAge(jsonData);

    }
}
