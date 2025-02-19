package com.bridgelabz.advanced_problems.json_csv_converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class JsonToCsvConverter {

    private static final String JSON_FILE_PATH = "src/main/resources/json_student.json";
    private static final String CSV_FILE_PATH = "src/main/resources/csv_students.csv";

    public static void convertJsonToCsv() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(JSON_FILE_PATH));
            JsonNode students = rootNode.get("students");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
                writer.write("ID,Name,Age,Marks");
                writer.newLine();

                for (JsonNode student : students) {
                    int id = student.get("id").asInt();
                    String name = student.get("name").asText();
                    int age = student.get("age").asInt();
                    int marks = student.get("marks").asInt();

                    writer.write(id + "," + name + "," + age + "," + marks);
                    writer.newLine();
                }
                System.out.println("JSON successfully converted to CSV!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
