package com.bridgelabz.practice_problem_2.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Load JSON file
            File file = new File("src/main/resources/read_json_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);

            // Print keys and values recursively
            printJson(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            // Iterate through object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                System.out.println(prefix + entry.getKey() + ": ");
                printJson(entry.getValue(), prefix + "  ");
            }
        } else if (node.isArray()) {
            // Iterate through array elements
            for (int i = 0; i < node.size(); i++) {
                System.out.println(prefix + "[" + i + "]: ");
                printJson(node.get(i), prefix + "  ");
            }
        } else {
            // Print key-value pairs
            System.out.println(prefix + node.asText());
        }
    }
}
