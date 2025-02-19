package com.bridgelabz.advanced_problems.json_csv_converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;

public class CsvToJsonConverter {

    private static final String CSV_FILE_PATH = "src/main/resources/read_student.csv";
    private static final String JSON_OUTPUT_PATH = "src/main/resources/read_student.json";

    public static void convertCsvToJson() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode studentsArray = objectMapper.createArrayNode();

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ObjectNode student = objectMapper.createObjectNode();
                student.put("id", Integer.parseInt(data[0]));
                student.put("name", data[1]);
                student.put("age", Integer.parseInt(data[2]));
                student.put("marks", Integer.parseInt(data[3]));
                studentsArray.add(student);
            }

            ObjectNode root = objectMapper.createObjectNode();
            root.set("students", studentsArray);

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_OUTPUT_PATH), root);
            System.out.println("CSV successfully converted back to JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
